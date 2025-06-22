package com.artifacts.server.implement;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import org.openapitools.ApiException;
import org.openapitools.client.CharactersApi;
import org.openapitools.client.ItemsApi;
import org.openapitools.client.MyCharactersApi;
import org.openapitools.client.model.BankGoldTransactionResponseSchema;
import org.openapitools.client.model.BankItemTransactionResponseSchema;
import org.openapitools.client.model.CharacterFightResponseSchema;
import org.openapitools.client.model.CharacterMovementResponseSchema;
import org.openapitools.client.model.CharacterResponseSchema;
import org.openapitools.client.model.CharacterRestResponseSchema;
import org.openapitools.client.model.CharacterSchema;
import org.openapitools.client.model.CraftSchema;
import org.openapitools.client.model.CraftSkill;
import org.openapitools.client.model.CraftingSchema;
import org.openapitools.client.model.DepositWithdrawGoldSchema;
import org.openapitools.client.model.DestinationSchema;
import org.openapitools.client.model.EquipSchema;
import org.openapitools.client.model.EquipmentResponseSchema;
import org.openapitools.client.model.InventorySlot;
import org.openapitools.client.model.ItemResponseSchema;
import org.openapitools.client.model.ItemSchema;
import org.openapitools.client.model.ItemSlot;
import org.openapitools.client.model.MapContentType;
import org.openapitools.client.model.MapSchema;
import org.openapitools.client.model.RecyclingResponseSchema;
import org.openapitools.client.model.RecyclingSchema;
import org.openapitools.client.model.RewardDataResponseSchema;
import org.openapitools.client.model.SimpleItemSchema;
import org.openapitools.client.model.SkillResponseSchema;
import org.openapitools.client.model.TaskResponseSchema;
import org.openapitools.client.model.UnequipSchema;
import org.openapitools.client.model.UseItemResponseSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.artifacts.server.service.GameDataStore;
import com.artifacts.server.utils.Utils;

@Component
public class PersonnageAction {
	public static GameDataStore gameDataStore;
	
	@Autowired
	public PersonnageAction(GameDataStore gameDataStore)
	{
		PersonnageAction.gameDataStore = gameDataStore;
	}
		
	public static Runnable Bouger(String characterId, String mapContentCode, MapContentType mapContentType, AtomicBoolean interrupted)
	{
		Thread t = new Thread(() -> {
			Boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try
				{
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
			    	CharacterSchema characterSchema = gameDataStore.getCharacters().stream().filter(c -> c.getName().equals(characterId)).findFirst().get();
			    	
			    	MapSchema mapSchema = Utils.PlusProcheDe(characterSchema, mapContentCode, mapContentType);
			    	System.out.println(mapContentCode + " le plus proche de " + characterId + ": " + mapSchema.getX()+"," + mapSchema.getY());
			    	
			    	if (characterSchema.getX() != mapSchema.getX() || characterSchema.getY() != mapSchema.getY())
			    	{
			    		System.out.println(characterId +" se déplace à: " + mapSchema.getX()+","+mapSchema.getY());
			        	
			        	DestinationSchema destinationSchema = new DestinationSchema();
			        	destinationSchema.setX(mapSchema.getX());
			        	destinationSchema.setY(mapSchema.getY());
			        	CharacterMovementResponseSchema characterMovementResponseSchema = myCharactersApi.actionMoveMyNameActionMovePost(characterId, destinationSchema);
			        	gameDataStore.updateCharacter(characterMovementResponseSchema.getData().getCharacter());
			        	Thread.sleep(characterMovementResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
			    	}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}
	
	private static Runnable Bouger(String characterId, int x, int y, AtomicBoolean interrupted)
	{
		Thread t = new Thread(() -> {
			Boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try
				{
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
					DestinationSchema destinationSchema = new DestinationSchema();
		        	destinationSchema.setX(x);
		        	destinationSchema.setY(y);
		        	CharacterMovementResponseSchema characterMovementResponseSchema = myCharactersApi.actionMoveMyNameActionMovePost(characterId, destinationSchema);
		        	gameDataStore.updateCharacter(characterMovementResponseSchema.getData().getCharacter());
		        	Thread.sleep(characterMovementResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}
	
	public static Runnable Gathering(String characterId, AtomicBoolean interrupted)
	{
		Thread t = new Thread(() -> {
			Boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try
				{
		    		System.out.println(characterId +" récupère des resources");
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
					SkillResponseSchema skillResponseSchema = myCharactersApi.actionGatheringMyNameActionGatheringPost(characterId);
					
					gameDataStore.updateCharacter(skillResponseSchema.getData().getCharacter());
		        	Thread.sleep(skillResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}

	public static Runnable ViderInventaire(String characterId, AtomicBoolean interrupted) {
		Thread t = new Thread(() -> {
			Boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try
				{
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
					CharacterSchema characterSchema = gameDataStore.getCharacters().stream().filter(c -> c.getName().equals(characterId)).findFirst().get();
					for(InventorySlot inventorySlot : characterSchema.getInventory())
			    	{
			    		if (!inventorySlot.getCode().isEmpty())
			    		{
			        		SimpleItemSchema simpleItemSchema = new SimpleItemSchema();
			        		simpleItemSchema.setCode(inventorySlot.getCode());
			        		simpleItemSchema.setQuantity(inventorySlot.getQuantity());
			        		System.out.println(characterId + " dépose: " + inventorySlot.getCode());
			        		
			        		BankItemTransactionResponseSchema bankItemTransactionResponseSchema = myCharactersApi.actionDepositBankMyNameActionBankDepositPost(characterId, simpleItemSchema);
			            	gameDataStore.updateCharacter(bankItemTransactionResponseSchema.getData().getCharacter());
			        		Thread.sleep(bankItemTransactionResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
			    		}
			    	}
					if (characterSchema.getGold() > 0)
					{
						DepositWithdrawGoldSchema depositWithdrawGoldSchema = new DepositWithdrawGoldSchema();
						depositWithdrawGoldSchema.setQuantity(characterSchema.getGold());
						BankGoldTransactionResponseSchema bankGoldTransactionResponseSchema = myCharactersApi.actionDepositBankGoldMyNameActionBankDepositGoldPost(characterId, depositWithdrawGoldSchema);
						gameDataStore.updateCharacter(bankGoldTransactionResponseSchema.getData().getCharacter());
		        		Thread.sleep(bankGoldTransactionResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}
	
	public static Runnable Combattre (String characterId, AtomicBoolean interrupted)
	{
		Thread t = new  Thread(() ->
		{
			Boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try
				{
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
					CharacterSchema characterSchema = gameDataStore.getCharacters().stream().filter(c -> c.getName().equals(characterId)).findFirst().get();
					int x = characterSchema.getX();
					int y = characterSchema.getY();
	        		System.out.println(characterId + " combat");
					CharacterFightResponseSchema characterFightResponseSchema = myCharactersApi.actionFightMyNameActionFightPost(characterId);
					gameDataStore.updateCharacter(characterFightResponseSchema.getData().getCharacter());
	
		    		Thread.sleep(characterFightResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					if(characterFightResponseSchema.getData().getFight().getResult().getValue().equals("loss"))
					{
						System.out.println(characterId+ " a perdu son combat");
						Runnable bouger = PersonnageAction.Bouger(characterId, x,y,interrupted);
						bouger.run();
						if(interrupted.get())
						{
							throw new InterruptedException();
						}
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}
	
	public static Runnable PrendreTask(String characterId, AtomicBoolean interrupted)
	{
		Thread t = new  Thread(() ->
		{
			Boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try
				{
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
	        		System.out.println(characterId + " prend une tache");
					TaskResponseSchema taskResponseSchema = myCharactersApi.actionAcceptNewTaskMyNameActionTaskNewPost(characterId);
					gameDataStore.updateCharacter(taskResponseSchema.getData().getCharacter());
					Thread.sleep(taskResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}
	
	public static Runnable RendreTask(String characterId, AtomicBoolean interrupted)
	{
		Thread t = new  Thread(() ->
		{
			Boolean isfinished = false;
			while(! isfinished)
			{
				isfinished = true;
				try
				{
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
	        		System.out.println(characterId + " rend une tache");
					RewardDataResponseSchema rewardDataResponseSchema = myCharactersApi.actionCompleteTaskMyNameActionTaskCompletePost(characterId);
					gameDataStore.updateCharacter(rewardDataResponseSchema.getData().getCharacter());
					Thread.sleep(rewardDataResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}
	
	public static Runnable Rest(String characterId, AtomicBoolean interrupted)
	{
		Thread t = new  Thread(() ->
		{
			Boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try
				{
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
	        		System.out.println(characterId + " se repose");
					CharacterRestResponseSchema characterRestResponseSchema = myCharactersApi.actionRestMyNameActionRestPost(characterId);
					gameDataStore.updateCharacter(characterRestResponseSchema.getData().getCharacter());
					Thread.sleep(characterRestResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}
	
	public static Runnable Manger(String characterId, String foodName, int quantity, AtomicBoolean interrupted)
	{
		Thread t = new Thread(() ->
		{
			Boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try
				{
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
					System.out.println(characterId + " mange " + quantity + " " + foodName);
					SimpleItemSchema itemSchema = new SimpleItemSchema();
					itemSchema.setCode(foodName);
					itemSchema.setQuantity(quantity);
					UseItemResponseSchema useItemResponseSchema = myCharactersApi.actionUseItemMyNameActionUsePost(characterId, itemSchema);
					gameDataStore.updateCharacter(useItemResponseSchema.getData().getCharacter());
					Thread.sleep(useItemResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
			
		});
		return t;
	}
	
	public static Runnable RetirerBanque(String characterId, String itemCode, int quantity, AtomicBoolean interrupted)
	{
		Thread t = new  Thread(() ->
		{
			Boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try
				{
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
					SimpleItemSchema simpleItemSchema = new SimpleItemSchema();
					simpleItemSchema.setCode(itemCode);
					simpleItemSchema.setQuantity(quantity);
		    		System.out.println(characterId + " retire " + quantity + " " + itemCode);
					BankItemTransactionResponseSchema bankItemTransactionResponseSchema = myCharactersApi.actionWithdrawBankMyNameActionBankWithdrawPost(characterId, simpleItemSchema);
					gameDataStore.updateCharacter(bankItemTransactionResponseSchema.getData().getCharacter());
					Thread.sleep(bankItemTransactionResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}
	
	public static Runnable Crafter(String characterId, String itemCode, int quantity, AtomicBoolean interrupted)
	{
		Thread t = new  Thread(() ->
		{
			Boolean isfinished = false;
			while(! isfinished)
			{
				isfinished = true;
				try
				{
					ItemsApi itemsApi = gameDataStore.getItemsApi();
			    	ItemResponseSchema itemResponseSchema = itemsApi.getItemItemsCodeGet(itemCode);
			    	ItemSchema itemData = itemResponseSchema.getData();
			    	
			    	Runnable bougerRBanque = PersonnageAction.Bouger(characterId, "bank",null,interrupted);
					bougerRBanque.run();
					if(interrupted.get())
					{
						throw new InterruptedException();
					}
					
					Runnable viderInventaire = PersonnageAction.ViderInventaire(characterId,interrupted);
					viderInventaire.run();
					if(interrupted.get())
					{
						throw new InterruptedException();
					}
			    	
			    	CraftSchema craftSchema = itemData.getCraft();
			    	for (SimpleItemSchema simpleItemSchema : craftSchema.getItems())
			    	{
			    		ItemSchema simpleItemData = itemsApi.getItemItemsCodeGet(simpleItemSchema.getCode()).getData();
			    		if (simpleItemData.getCraft()!=null) //on va devoir le craft d'abord
			    		{
			    			int quantiteEnBanque = Utils.QuantiteEnBanque(simpleItemData.getCode());
			    			Runnable craft = Crafter(characterId, simpleItemData.getCode(), simpleItemSchema.getQuantity() * quantity - quantiteEnBanque,interrupted);
			    			craft.run();
							if(interrupted.get())
							{
								throw new InterruptedException();
							}
			    		}
			    	}
			    	//là on a crafté toutes les non resources
			    	
			    	int nombreItemsPourCraft = Utils.NombreItemsPourCraftUn(itemCode);
			    	CharacterSchema characterSchema = gameDataStore.getCharacters().stream().filter(c -> c.getName().equals(characterId)).findFirst().get();
			    	int nombreDeStack = characterSchema.getInventoryMaxItems() / nombreItemsPourCraft; //on va crafter par paquets de nombreDeStack max
			    	
			    	int quantiteCraftee = 0;
			    	while (quantiteCraftee < quantity)
			    	{
			    		int tailleDeMonStack = Math.min(quantity - quantiteCraftee, nombreDeStack);
			    		for(SimpleItemSchema simpleItemSchema : craftSchema.getItems())
			    		{
			    			Runnable retirerBanque = RetirerBanque(characterId, simpleItemSchema.getCode(), tailleDeMonStack * simpleItemSchema.getQuantity(),interrupted);
			    			retirerBanque.run();
							if(interrupted.get())
							{
								throw new InterruptedException();
							}
			    		}
			        	String endroitOuCraft = null;
			        	switch(craftSchema.getSkill())
			        	{
							case ALCHEMY:
								endroitOuCraft = "alchemy";
								break;
							case COOKING:
								endroitOuCraft = "cooking";
								break;
							case GEARCRAFTING:
								endroitOuCraft = "gearcrafting";
								break;
							case JEWELRYCRAFTING:
								endroitOuCraft = "jewelrycrafting";
								break;
							case MINING:
								endroitOuCraft = "mining";
								break;
							case WEAPONCRAFTING:
								endroitOuCraft = "weaponcrafting";
								break;
							case WOODCUTTING:
								endroitOuCraft = "woodcutting";
								break;
							default:
								break;
			        	
			        	}
			        	Runnable bougerWorkShop = PersonnageAction.Bouger(characterId, endroitOuCraft,null,interrupted);
			        	bougerWorkShop.run();
						if(interrupted.get())
						{
							throw new InterruptedException();
						}
			        	
			        	Runnable crafterItem = PersonnageAction.ActionCrafter(characterId,itemCode, tailleDeMonStack,interrupted);
			        	crafterItem.run();
						if(interrupted.get())
						{
							throw new InterruptedException();
						}
			        	
			        	bougerRBanque.run();
						if(interrupted.get())
						{
							throw new InterruptedException();
						}
			        	viderInventaire.run();
						if(interrupted.get())
						{
							throw new InterruptedException();
						}
			        	
			        	quantiteCraftee += tailleDeMonStack;
			    	}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}

	public static Runnable ActionCrafter(String characterId, String itemCode, int quantity, AtomicBoolean interrupted) {

		Thread t = new  Thread(() ->
		{
			boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try
				{
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
					System.out.println(characterId + " crafte " + quantity + " " + itemCode);
					CraftingSchema craftingSchema = new CraftingSchema();
					craftingSchema.setCode(itemCode);
					craftingSchema.setQuantity(quantity);
					SkillResponseSchema skillResponseSchema = myCharactersApi.actionCraftingMyNameActionCraftingPost(characterId,craftingSchema);
					gameDataStore.updateCharacter(skillResponseSchema.getData().getCharacter());
					Thread.sleep(skillResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}
	
	public static Runnable AllerWorkShop(String characterId, String itemCode, AtomicBoolean interrupted)
	{
		Thread t = new Thread(() ->
		{
			Boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try {
					ItemsApi itemsApi = gameDataStore.getItemsApi();
					ItemResponseSchema itemResponseSchema = itemsApi.getItemItemsCodeGet(itemCode);
					ItemSchema itemSchema = itemResponseSchema.getData();
					CraftSkill craftSkill = itemSchema.getCraft().getSkill();
	
		        	String endroitOuCraft = null;
					switch(craftSkill)
					{
						case ALCHEMY:
							endroitOuCraft = "alchemy";
							break;
						case COOKING:
							endroitOuCraft = "cooking";
							break;
						case GEARCRAFTING:
							endroitOuCraft = "gearcrafting";
							break;
						case JEWELRYCRAFTING:
							endroitOuCraft = "jewelrycrafting";
							break;
						case MINING:
							endroitOuCraft = "mining";
							break;
						case WEAPONCRAFTING:
							endroitOuCraft = "weaponcrafting";
							break;
						case WOODCUTTING:
							endroitOuCraft = "woodcutting";
							break;
						default:
							break;
					}
					Runnable bougerWorkShop = PersonnageAction.Bouger(characterId, endroitOuCraft,null,interrupted);
		        	bougerWorkShop.run();
					if(interrupted.get())
					{
						throw new InterruptedException();
					}
					
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}
	
	public static Runnable Recycler (String characterId, String itemCode, int quantity, AtomicBoolean interrupted)
	{

		Thread t = new Thread(() ->
		{
			Boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try
				{
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
					
					RecyclingSchema recyclingSchema = new RecyclingSchema();
					recyclingSchema.setCode(itemCode);
					recyclingSchema.setQuantity(quantity);
					
					RecyclingResponseSchema recyclingResponseSchema = myCharactersApi.actionRecyclingMyNameActionRecyclingPost(characterId, recyclingSchema);
					gameDataStore.updateCharacter(recyclingResponseSchema.getData().getCharacter());
					Thread.sleep(recyclingResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}
	
	public static Runnable Equiper(String characterId, String objectList, AtomicBoolean interrupted)
	{

		Thread t = new Thread(() ->
		{
			Boolean isfinished = false;
			while(!isfinished)
			{
				isfinished = true;
				try
				{
					MyCharactersApi myCharactersApi = gameDataStore.getMyCharactersApi();
					CharactersApi charactersApi = gameDataStore.getCharactersApi();
					
					CharacterResponseSchema characterResponseSchema = charactersApi.getCharacterCharactersNameGet(characterId);
					CharacterSchema characterSchema = characterResponseSchema.getData();
					
					Runnable bougerRBanque = Bouger(characterId, "bank",null,interrupted);
					bougerRBanque.run();
					if(interrupted.get())
					{
						return;
					}
					Runnable rest = PersonnageAction.Rest(characterId, interrupted);
					if(characterSchema.getHp() < characterSchema.getMaxHp())
					{
						rest.run();
						if (interrupted.get())
						{
							return;
						}
					}
	
					String weaponSlot = characterSchema.getWeaponSlot();
					String helmetSlot = characterSchema.getHelmetSlot();
					String shieldSlot = characterSchema.getShieldSlot();
					String bodyArmorSlot = characterSchema.getBodyArmorSlot();
					String amuletSlot = characterSchema.getAmuletSlot();
					String legArmorSlot = characterSchema.getLegArmorSlot();
					String bootsSlot = characterSchema.getBootsSlot();
					String ring1Slot = characterSchema.getRing1Slot();
					String ring2Slot = characterSchema.getRing2Slot();
					String artifact1Slot = characterSchema.getArtifact1Slot();
					String artifact2Slot = characterSchema.getArtifact2Slot();
					String artifact3Slot = characterSchema.getArtifact3Slot();
					String runeSlot = characterSchema.getRuneSlot();
					String bagSlot = characterSchema.getBagSlot();
					
					Map<String, String> itemsToEquipMap = Arrays.stream(objectList.split("&"))
						    .map(entry -> entry.split("=", 2)) // split chaque élément en [clé, valeur]
						    .collect(Collectors.toMap(
						        parts -> parts[0],
						        parts -> parts.length > 1 ? parts[1].replaceAll("\\d+$", "") : ""
						    ));
					if (!weaponSlot.isEmpty() && !weaponSlot.equals(itemsToEquipMap.get("weapon")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.WEAPON);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!helmetSlot.isEmpty() && !helmetSlot.equals(itemsToEquipMap.get("helmet")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.HELMET);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!shieldSlot.isEmpty() && !shieldSlot.equals(itemsToEquipMap.get("shield")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.SHIELD);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!bodyArmorSlot.isEmpty() && !bodyArmorSlot.equals(itemsToEquipMap.get("bodyArmor")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.BODY_ARMOR);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!amuletSlot.isEmpty() && !amuletSlot.equals(itemsToEquipMap.get("amulet")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.AMULET);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!legArmorSlot.isEmpty() && !legArmorSlot.equals(itemsToEquipMap.get("legArmor")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.LEG_ARMOR);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!bootsSlot.isEmpty() && !bootsSlot.equals(itemsToEquipMap.get("boots")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.BOOTS);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!ring1Slot.isEmpty() && !ring1Slot.equals(itemsToEquipMap.get("ring1")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.RING1);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!ring2Slot.isEmpty() && !ring2Slot.equals(itemsToEquipMap.get("ring2")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.RING2);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!artifact1Slot.isEmpty() && !artifact1Slot.equals(itemsToEquipMap.get("artifact1")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.ARTIFACT1);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!artifact2Slot.isEmpty() && !artifact2Slot.equals(itemsToEquipMap.get("artifact2")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.ARTIFACT2);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!artifact3Slot.isEmpty() && !artifact3Slot.equals(itemsToEquipMap.get("artifact3")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.ARTIFACT3);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!runeSlot.isEmpty() && !runeSlot.equals(itemsToEquipMap.get("rune")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.RUNE);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					if (!bagSlot.isEmpty() && !bagSlot.equals(itemsToEquipMap.get("bag")))
					{
						UnequipSchema unequipSchema = new UnequipSchema();
						unequipSchema.setQuantity(1);
						unequipSchema.setSlot(ItemSlot.BAG);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionUnequipItemMyNameActionUnequipPost(characterId, unequipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					Runnable vider = ViderInventaire(characterId, interrupted);
					vider.run();
					if (interrupted.get())
					{
						return;
					}
					characterSchema = gameDataStore.getCharacters().stream().filter(c -> c.getName().equals(characterId)).findFirst().get();
					if (!itemsToEquipMap.get("weapon").isEmpty() && characterSchema.getWeaponSlot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("weapon"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("weapon"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.WEAPON);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("helmet").isEmpty() && characterSchema.getHelmetSlot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("helmet"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("helmet"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.HELMET);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("shield").isEmpty() && characterSchema.getShieldSlot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("shield"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("shield"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.SHIELD);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("bodyArmor").isEmpty() && characterSchema.getBodyArmorSlot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("bodyArmor"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("bodyArmor"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.BODY_ARMOR);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("amulet").isEmpty() && characterSchema.getAmuletSlot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("amulet"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("amulet"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.AMULET);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("legArmor").isEmpty() && characterSchema.getLegArmorSlot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("legArmor"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("legArmor"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.LEG_ARMOR);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("boots").isEmpty() && characterSchema.getBootsSlot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("boots"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("boots"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.BOOTS);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("ring1").isEmpty() && characterSchema.getRing1Slot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("ring1"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("ring1"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.RING1);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("ring2").isEmpty() && characterSchema.getRing2Slot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("ring2"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("ring2"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.RING2);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("artifact1").isEmpty() && characterSchema.getArtifact1Slot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("artifact1"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("artifact1"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.ARTIFACT1);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("artifact2").isEmpty() && characterSchema.getArtifact2Slot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("artifact2"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("artifact2"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.ARTIFACT2);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("artifact3").isEmpty() && characterSchema.getArtifact3Slot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("artifact3"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("artifact3"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.ARTIFACT3);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("rune").isEmpty() && characterSchema.getRuneSlot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("rune"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("rune"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.RUNE);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
					if (!itemsToEquipMap.get("bag").isEmpty() && characterSchema.getBagSlot().isEmpty())
					{
						Runnable retirerBanque = RetirerBanque(characterId, itemsToEquipMap.get("bag"), 1, interrupted);
						retirerBanque.run();
						if (interrupted.get())
						{
							return;
						}
						EquipSchema equipSchema = new EquipSchema();
						equipSchema.setCode(itemsToEquipMap.get("bag"));
						equipSchema.setQuantity(1);
						equipSchema.setSlot(ItemSlot.BAG);
						EquipmentResponseSchema equipmentResponseSchema = myCharactersApi.actionEquipItemMyNameActionEquipPost(characterId, equipSchema);
						gameDataStore.updateCharacter(equipmentResponseSchema.getData().getCharacter());
						Thread.sleep(equipmentResponseSchema.getData().getCooldown().getTotalSeconds()* 1000);
					}
					
				}
				catch (InterruptedException e) {
					e.printStackTrace();
					interrupted.set(true);
	    			Thread.currentThread().interrupt();
				}
				catch(ApiException e)
				{
					if (e.getCode() == 499) // cooldown
					{
						isfinished = false;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							isfinished = true;
							e1.printStackTrace();
						}
					}
					else
					{
						interrupted.set(true);
						isfinished = true;
					}
				}
			}
		});
		return t;
	}
}
