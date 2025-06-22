package com.artifacts.server.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import org.openapitools.ApiException;
import org.openapitools.client.model.CharacterSchema;
import org.openapitools.client.model.InventorySlot;
import org.openapitools.client.model.MapContentType;
import org.openapitools.client.model.MyCharactersListSchema;
import org.openapitools.client.model.SimpleEffectSchema;
import org.springframework.stereotype.Service;

import com.artifacts.server.implement.PersonnageAction;
import com.artifacts.server.utils.Utils;

@Service
public class ActionService {

	private final GameDataStore gameDataStore;
	
	public ActionService(GameDataStore gameDataStore)
	{
		this.gameDataStore = gameDataStore;
	}

    public void ViderInventaire(String characterId) {
    	AtomicBoolean interrupted = new AtomicBoolean(false);
        Thread t = new Thread(() -> {
            System.out.println(characterId + " part vider son inventaire");
            Runnable bougerBanque = PersonnageAction.Bouger(characterId, "bank",null,interrupted);
			bougerBanque.run();
			if (interrupted.get())
			{
				return;
			}
			Runnable viderInventaire = PersonnageAction.ViderInventaire(characterId,interrupted);
			viderInventaire.run();
			if (interrupted.get())
			{
				return;
			}
            System.out.println("Fin des actions pour " + characterId);
        });
        t.setName("Vider Inventaire");
        gameDataStore.startAction(characterId, t);
    }
    
    public void ViderInventaireTous() throws ApiException
    {
    	for(CharacterSchema characterSchema : gameDataStore.getCharacters())
    	{
    		ViderInventaire(characterSchema.getName());
    	}
    }
    
    public void AnnulerTous() throws ApiException
    {

    	for(CharacterSchema characterSchema : gameDataStore.getCharacters())
    	{
    		ArreterAction(characterSchema.getName());
    	}
    }
    
    public void Basher(String characterId, String monsterId, String additionalParams)
    {
    	
    	AtomicBoolean interrupted = new AtomicBoolean(false);
        Thread t = new Thread(() -> {
        	
        	Map<String, String> additionalParamsMap = null;
        	if (additionalParams != null && !additionalParams.isEmpty())
        	{
        		additionalParamsMap = Arrays.stream(additionalParams.split("&"))
        			    .map(entry -> entry.split("=", 2)) // split chaque élément en [clé, valeur]
        			    .collect(Collectors.toMap(
        			        parts -> parts[0],
        			        parts -> parts.length > 1 ? parts[1].replaceAll("\\d+$", "") : ""
        			    ));
        	}
        	String food = additionalParamsMap.get("food");
        	
        	if (additionalParamsMap != null && food != null && Utils.QuantiteEnInventaire(characterId, food) == 0)
        	{
        		Runnable bougerRBanque = PersonnageAction.Bouger(characterId, "bank",null,interrupted);
				bougerRBanque.run();
				if (interrupted.get())
				{
					return;
				}
				Runnable retirerBanque = PersonnageAction.RetirerBanque(characterId, food, 50, interrupted);
				retirerBanque.run();
				if (interrupted.get())
				{
					return;
				}
        	}

    		System.out.println(characterId + " part pour le monstre " + monsterId);
            Runnable bougerResource = PersonnageAction.Bouger(characterId, monsterId,null,interrupted);
            bougerResource.run();
			if (interrupted.get())
			{
				return;
			}
			
			Runnable rest = PersonnageAction.Rest(characterId, interrupted);
			if(gameDataStore.getCharacter(characterId).getHp() < gameDataStore.getCharacter(characterId).getMaxHp())
			{
				rest.run();
				if (interrupted.get())
				{
					return;
				}
			}
			
            Boolean isFinished = false;
        	while(!isFinished)
        	{
        		Runnable gathering = PersonnageAction.Combattre(characterId,interrupted);
				gathering.run();
				if (interrupted.get())
				{
					return;
				}
				
				if(food != null &&gameDataStore.getCharacter(characterId).getHp() < gameDataStore.getCharacter(characterId).getMaxHp())
				{
					try {
						List<SimpleEffectSchema> listeEffets = gameDataStore.getItemsApi().getItemItemsCodeGet(additionalParamsMap.get("food")).getData().getEffects();
						int healValue = listeEffets.stream().filter(e -> e.getCode().equals("heal")).findFirst().get().getValue();
						int nb_consommables = (gameDataStore.getCharacter(characterId).getMaxHp() - gameDataStore.getCharacter(characterId).getHp()) / healValue;
						
						int nbDansSac = 0;
						Optional<InventorySlot> slotOpt = gameDataStore.getCharacter(characterId).getInventory().stream().filter(i -> i.getCode().equals(food)).findFirst();
						if(slotOpt != null)
						{
							nbDansSac = slotOpt.get().getQuantity();
						}
						Runnable manger = PersonnageAction.Manger(characterId, food,Math.min(nbDansSac,nb_consommables),interrupted);
						manger.run();
						
						if (interrupted.get())
						{
							return;
						}
						
					} catch (ApiException e) {
						e.printStackTrace();
					}
				}
				
				
				if(gameDataStore.getCharacter(characterId).getHp() < gameDataStore.getCharacter(characterId).getMaxHp())
				{
					rest.run();
					if (interrupted.get())
					{
						return;
					}
				}
				
				int tailleSac = Utils.CompterObjetsSac(gameDataStore.getCharacter(characterId));
				if (gameDataStore.getCharacter(characterId).getInventoryMaxItems() * 0.95 <= tailleSac)
				{
					Runnable bougerRBanque = PersonnageAction.Bouger(characterId, "bank",null,interrupted);
					bougerRBanque.run();
					if (interrupted.get())
					{
						return;
					}
					Runnable viderInventaire = PersonnageAction.ViderInventaire(characterId,interrupted);
					viderInventaire.run();
					if (interrupted.get())
					{
						return;
					}
				}
	        	
	        	if (food != null && Utils.QuantiteEnInventaire(characterId, food) == 0)
	        	{
	        		Runnable bougerRBanque = PersonnageAction.Bouger(characterId, "bank",null,interrupted);
					bougerRBanque.run();
					if (interrupted.get())
					{
						return;
					}
					Runnable retirerBanque = PersonnageAction.RetirerBanque(characterId, food, 50, interrupted);
					retirerBanque.run();
					if (interrupted.get())
					{
						return;
					}
	        	}
				
				System.out.println(characterId + " part pour le monstre " + monsterId);
			    bougerResource.run();
				if (interrupted.get())
				{
					return;
				}
        	}
        });
        t.setName("Bashe " + monsterId);
        gameDataStore.startAction(characterId, t);
    }
    
    public void Farmer(String characterId, String resourceId)
    {
    	AtomicBoolean interrupted = new AtomicBoolean(false);
        Thread t = new Thread(() -> {

    		System.out.println(characterId + " part pour la resource " + resourceId);
            Runnable bougerResource = PersonnageAction.Bouger(characterId, resourceId,null,interrupted);
            bougerResource.run();
			if (interrupted.get())
			{
				return;
			}
            
            Boolean isFinished = false;
        	while(!isFinished)
        	{
        		Runnable gathering = PersonnageAction.Gathering(characterId,interrupted);
				gathering.run();
				if (interrupted.get())
				{
					return;
				}
				
				int tailleSac = Utils.CompterObjetsSac(gameDataStore.getCharacter(characterId));
				if (gameDataStore.getCharacter(characterId).getInventoryMaxItems() * 0.95 <= tailleSac)
				{
					Runnable bougerRBanque = PersonnageAction.Bouger(characterId, "bank",null,interrupted);
					bougerRBanque.run();
					if (interrupted.get())
					{
						return;
					}
					Runnable viderInventaire = PersonnageAction.ViderInventaire(characterId,interrupted);
					viderInventaire.run();
					if (interrupted.get())
					{
						return;
					}
					
					System.out.println(characterId + " part pour la resource " + resourceId);
				    bougerResource.run();
					if (interrupted.get())
					{
						return;
					}
				}
        	}
        });
        t.setName("Farme " + resourceId);
        gameDataStore.startAction(characterId, t);
    }
    
    public void RéaliserTache(String characterId, String additionalParams)
    {

    	AtomicBoolean interrupted = new AtomicBoolean(false);
    	 Thread t = new Thread(() -> {
    		 
    		 Map<String, String> additionalParamsMap = null;
    	    	if (additionalParams != null && !additionalParams.isEmpty())
    	    	{
    	    		additionalParamsMap = Arrays.stream(additionalParams.split("&"))
    	    			    .map(entry -> entry.split("=", 2)) // split chaque élément en [clé, valeur]
    	    			    .collect(Collectors.toMap(
    	    			        parts -> parts[0],
    	    			        parts -> parts.length > 1 ? parts[1].replaceAll("\\d+$", "") : ""
    	    			    ));
    	    	}
	    	String foodTmp = null;

	    	Boolean hasFood = false;
	    	if (additionalParamsMap != null && additionalParamsMap.get("food") != null)
	    	{
	    		hasFood = true;
	    		foodTmp = additionalParamsMap.get("food");
	    	}
	    	
	    	final String food = foodTmp;
    		 
    		 Boolean interrupt = false;
			String task = gameDataStore.getCharacter(characterId).getTask();
			String taskType = gameDataStore.getCharacter(characterId).getTaskType();
			
			Boolean taskFinished = false;

			Runnable bouger =  PersonnageAction.Bouger(characterId, task,null,interrupted);
			bouger.run();
			if (interrupted.get())
			{
				return;
			}
			
			while(!interrupt && ! taskFinished)
			{
				if (taskType.equals("monsters"))
				{
					Runnable rest = PersonnageAction.Rest(characterId,interrupted);
					if(gameDataStore.getCharacter(characterId).getHp() < gameDataStore.getCharacter(characterId).getMaxHp())
					{
						rest.run();
						if (interrupted.get())
						{
							return;
						}
					}
					
					Runnable combat = PersonnageAction.Combattre(characterId,interrupted);
					combat.run();
					if (interrupted.get())
					{
						return;
					}
					

					if(gameDataStore.getCharacter(characterId).getHp() < gameDataStore.getCharacter(characterId).getMaxHp())
					{
						if (hasFood)
						{
							int healValue = 0;
							try {

								List<SimpleEffectSchema> listeEffets = gameDataStore.getItemsApi().getItemItemsCodeGet(food).getData().getEffects();

								healValue = listeEffets.stream().filter(e -> e.getCode().equals("heal")).findFirst().get().getValue();
							} catch (ApiException e) {
								e.printStackTrace();
							}
							int nb_consommables = (gameDataStore.getCharacter(characterId).getMaxHp() - gameDataStore.getCharacter(characterId).getHp()) / healValue;
							
							int nbDansSac = 0;
							Optional<InventorySlot> slotOpt = gameDataStore.getCharacter(characterId).getInventory().stream().filter(i -> i.getCode().equals(food)).findFirst();
							if(slotOpt != null)
							{
								nbDansSac = slotOpt.get().getQuantity();
							}
							Runnable manger = PersonnageAction.Manger(characterId, food,Math.min(nbDansSac,nb_consommables),interrupted);
							manger.run();
							
							if (interrupted.get())
							{
								return;
							}
						}
						if(gameDataStore.getCharacter(characterId).getHp() < gameDataStore.getCharacter(characterId).getMaxHp())
						{
							rest.run();
							if (interrupted.get())
							{
								return;
							}
						}
					}
					
					if (gameDataStore.getCharacter(characterId).getTaskProgress().equals(gameDataStore.getCharacter(characterId).getTaskTotal()))
					{
						taskFinished = true;
					}
					
			        int tailleSac = Utils.CompterObjetsSac(gameDataStore.getCharacter(characterId));
			        int nbFood = 0;
					Optional<InventorySlot> slotOpt = gameDataStore.getCharacter(characterId).getInventory().stream().filter(i -> i.getCode().equals(food)).findFirst();
					if(slotOpt != null)
					{
						nbFood = slotOpt.get().getQuantity();
					}
					if (taskFinished || gameDataStore.getCharacter(characterId).getInventoryMaxItems() * 0.95 <= tailleSac || (hasFood && nbFood == 0))
					{
						Runnable bougerRBanque = PersonnageAction.Bouger(characterId, "bank",null,interrupted);
						bougerRBanque.run();
						if (interrupted.get())
						{
							return;
						}
						Runnable viderInventaire = PersonnageAction.ViderInventaire(characterId,interrupted);
						viderInventaire.run();
						if (interrupted.get())
						{
							return;
						}
						
						if (hasFood)
						{
							Runnable retirerBanque = PersonnageAction.RetirerBanque(characterId, food, 50 - nbFood, interrupted);
							retirerBanque.run();
							if (interrupted.get())
							{
								return;
							}
						}
						
						if(!taskFinished)
						{
							System.out.println(characterId + " part pour la resource " + task);
							bouger.run();
							if (interrupted.get())
							{
								return;
							}
						}
					}
				}
			}
			
			if(taskFinished)
			{
				Runnable bougerTaskMaster = PersonnageAction.Bouger(characterId, "monsters",MapContentType.TASKS_MASTER,interrupted);
				bougerTaskMaster.run();
				if (interrupted.get())
				{
					return;
				}
				Runnable rendreTask = PersonnageAction.RendreTask(characterId,interrupted);
				rendreTask.run();
				if (interrupted.get())
				{
					return;
				}
				Runnable prendreTask = PersonnageAction.PrendreTask(characterId,interrupted);
				prendreTask.run();
				if (interrupted.get())
				{
					return;
				}
				Runnable bougerRBanque = PersonnageAction.Bouger(characterId, "bank",null,interrupted);
				bougerRBanque.run();
				if (interrupted.get())
				{
					return;
				}
				Runnable viderInventaire = PersonnageAction.ViderInventaire(characterId,interrupted);
				viderInventaire.run();
				if (interrupted.get())
				{
					return;
				}
			}
    		 
    	 });
    	 t.setName("Réalise ses taches");
         gameDataStore.startAction(characterId, t);
    }
    
    public void Crafter(String characterId, String itemCode, int quantity)
    {
    	AtomicBoolean interrupted = new AtomicBoolean(false);
    	Thread t = new Thread(() -> {
		Runnable crafter = PersonnageAction.Crafter(characterId,itemCode,quantity,interrupted);
		crafter.run();
		if (interrupted.get())
		{
			return;
		}
    	});
    	t.setName("crafte " + quantity + " " + itemCode);
        gameDataStore.startAction(characterId, t);
    }
    
    public void Recycler(String characterId, String itemCode, int quantity)
    {
    	AtomicBoolean interrupted = new AtomicBoolean(false);
        Thread t = new Thread(() -> {

    		System.out.println(characterId + " recycle " + quantity + " " + itemCode);
    		Runnable bougerRBanque = PersonnageAction.Bouger(characterId, "bank",null,interrupted);
    		bougerRBanque.run();
    		if (interrupted.get())
    		{
    			return;
    		}
    		
    		Runnable vider = PersonnageAction.ViderInventaire(characterId, interrupted);
    		vider.run();
    		if (interrupted.get())
    		{
    			return;
    		}
    		int qte = 0;
    		while(qte < quantity)
    		{
    			int retire = Math.min(30, quantity-qte);
    			
    			Runnable retirer = PersonnageAction.RetirerBanque(characterId, itemCode, retire, interrupted);
        		retirer.run();
        		if (interrupted.get())
        		{
        			return;
        		}
        		
        		Runnable allerWorkShop = PersonnageAction.AllerWorkShop(characterId, itemCode, interrupted);
        		allerWorkShop.run();
        		if (interrupted.get())
        		{
        			return;
        		}
        		
        		Runnable recycler = PersonnageAction.Recycler(characterId, itemCode, retire, interrupted);
        		recycler.run();
        		if (interrupted.get())
        		{
        			return;
        		}
        		bougerRBanque.run();
        		if (interrupted.get())
        		{
        			return;
        		}
        		vider.run();
        		if (interrupted.get())
        		{
        			return;
        		}
    			
    			qte += retire;
    		}
    		
        });
    	t.setName("recycle " + quantity + " " + itemCode);
        gameDataStore.startAction(characterId, t);
        
    }
    
    public void Vendre (String characterId, String itemCode, int quantity)
    {
    	AtomicBoolean interrupted = new AtomicBoolean(false);
    	Thread t = new Thread(() -> {
    	
    	});
    	t.setName("vends " + quantity + " " + itemCode);
        gameDataStore.startAction(characterId, t);
    }
    
    public void Equiper(String characterId, String objectList)
    {
    	AtomicBoolean interrupted = new AtomicBoolean(false);
        Thread t = new Thread(() -> {
        	Runnable equiper = PersonnageAction.Equiper(characterId, objectList, interrupted);
        	equiper.run();
    		if (interrupted.get())
    		{
    			return;
    		}
        });
    	t.setName("s'équipe");
        gameDataStore.startAction(characterId, t);
    }
    
    public void ArreterAction(String characterId)
    {
    	gameDataStore.cancelAction(characterId);
    }
    
    public String GetStatus(String characterId)
    {
    	return gameDataStore.GetAction(characterId);
    }
    
    public String GetEquipment(String characterId)
    {
    	String equipment = "";
    	
    	equipment = gameDataStore.GetEquipment(characterId);
    	
    	return equipment;
    }

	public List<CharacterSchema> GetCharacters() throws ApiException {
		return gameDataStore.getMyCharactersApi().getMyCharactersMyCharactersGet().getData();		
	}
}