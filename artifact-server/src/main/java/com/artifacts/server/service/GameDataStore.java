package com.artifacts.server.service;

import java.io.IOException;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.client.AccountsApi;
import org.openapitools.client.CharactersApi;
import org.openapitools.client.EventsApi;
import org.openapitools.client.ItemsApi;
import org.openapitools.client.MapsApi;
import org.openapitools.client.MyAccountApi;
import org.openapitools.client.MyCharactersApi;
import org.openapitools.client.model.CharacterSchema;
import org.openapitools.client.model.CharactersListSchema;
import org.springframework.stereotype.Service;

import com.artifacts.server.config.ArtifactsApiProperties;
import com.artifacts.server.utils.Utils;

import okhttp3.OkHttpClient;

@Service
public class GameDataStore {
	private final String token;
	private final String baseUrl;
	private final ApiClient apiClient;
	private final MapsApi mapsApi;
	private final MyCharactersApi myCharactersApi;
	private final CharactersApi charactersApi;
	private final MyAccountApi myAccountApi;
	private final AccountsApi accountsApi;
	private final ItemsApi itemsApi;
	private final EventsApi eventsApi;
	
	private final List<CharacterSchema> characters;
	private final ConcurrentHashMap<String, Thread> runningActions = new ConcurrentHashMap<>();
	
	private final ExecutorService executor = Executors.newCachedThreadPool();
	
	private final String accountName;

	public GameDataStore(ArtifactsApiProperties props) throws ApiException {
        this.token = props.getToken();
        this.baseUrl = props.getBaseUrl();
        
		OkHttpClient client = new OkHttpClient();
		this.apiClient = new ApiClient(client);
		this.apiClient.setConnectTimeout(60000);
		this.apiClient.setBasePath(baseUrl);
		this.apiClient.setBearerToken(token);
		this.myAccountApi = new MyAccountApi(this.apiClient);
		this.eventsApi = new EventsApi(this.apiClient);
    	
    	mapsApi = new MapsApi(this.apiClient);
    	myCharactersApi = new MyCharactersApi(this.apiClient);
    	accountsApi = new AccountsApi(this.apiClient);
    	charactersApi = new CharactersApi(this.apiClient);
    	itemsApi = new ItemsApi(this.apiClient);
    	
    	this.accountName = GetAccountName();
    	characters = UpdateCharacters();
    }
	
	private String GetAccountName() throws ApiException
	{
		String accountName = null;
    	accountName = myAccountApi.getAccountDetailsMyDetailsGet().getData().getUsername();
    	return accountName;
	}
	
	public List<CharacterSchema> UpdateCharacters() throws ApiException
	{
		
		CharactersListSchema charactersListSchema = accountsApi.getAccountCharactersAccountsAccountCharactersGet(this.accountName);
		return charactersListSchema.getData();
	}
	
	public List<CharacterSchema> getCharacters() throws ApiException {
		for(CharacterSchema characterSchema : UpdateCharacters())
		{
			updateCharacter(characterSchema);
		}
        return characters;
    }
	
	public CharacterSchema getCharacter(String characterName)
	{
		return characters.stream().filter(c -> c.getName().equals(characterName)).findFirst().get();
	}
	
	public void updateCharacter(CharacterSchema updatedCharacter) {
	    for (int i = 0; i < characters.size(); i++) {
	        if (characters.get(i).getName().equals(updatedCharacter.getName())) {
	            characters.set(i, updatedCharacter);
	            return;
	        }
	    }
	    throw new IllegalArgumentException("Character with ID " + updatedCharacter.getName() + " not found.");
	}
	
	public boolean isActionRunning(String characterId) {
        Thread t= runningActions.get(characterId);
        return t != null && t.isAlive();
    }
	
	public String GetAction(String characterId)
	{
		Thread t = runningActions.get(characterId);
		if (t != null)
		{
			return t.getName();
		}
		else
		{
			return "";
		}
	}
	
	public String GetEquipment (String characterId)
	{
		CharacterSchema characterSchema = getCharacter(characterId);
		String equipment = "weapon=" + characterSchema.getWeaponSlot() +
				"&helmet=" + characterSchema.getHelmetSlot() +
				"&shield=" + characterSchema.getShieldSlot() +
				"&bodyArmor=" + characterSchema.getBodyArmorSlot() +
				"&amulet=" + characterSchema.getAmuletSlot() +
				"&legArmor=" + characterSchema.getLegArmorSlot() +
				"&boots=" + characterSchema.getBootsSlot() +
				"&ring1=" + characterSchema.getRing1Slot() +
				"&ring2=" + characterSchema.getRing2Slot() +
				"&artifact1=" + characterSchema.getArtifact1Slot() +
				"&artifact2=" + characterSchema.getArtifact2Slot() +
				"&artifact3=" + characterSchema.getArtifact3Slot() +
				"&rune=" + characterSchema.getRuneSlot() +
				"&bag=" + characterSchema.getBagSlot();
		return equipment;
	}
	
	/*public void startAction(String characterId, Runnable task) {
	    if (isActionRunning(characterId)) {
	        throw new IllegalStateException("Action already running for character " + characterId);
	    }

	    Runnable wrappedTask = () -> {
	        try {
	        	System.out.println("run");
	            task.run();
	        } catch (Exception e) {
	            System.err.println("Erreur pendant l'action de " + characterId + " : " + e.getMessage());
	            e.printStackTrace();
	        } finally {
	            // Nettoyage automatique à la fin du thread
	            runningActions.remove(characterId);
	            System.out.println("Action terminée ou interrompue pour " + characterId);
	        }
	    };

	    Future<?> future = executor.submit(wrappedTask);
	    runningActions.put(characterId, future);
	}*/
	

	public void startAction(String characterId, Thread task) {
	    if (isActionRunning(characterId)) {
	        throw new IllegalStateException("Action already running for character " + characterId);
	    }
	
	    Thread actionThread = new Thread(() -> {
	        try {
	            System.out.println("Thread " + Thread.currentThread().getName() + " started");
	            OffsetDateTime offsetDateTime = getCharacter(characterId).getCooldownExpiration();
	            OffsetDateTime offsetDateTime2 = OffsetDateTime.now();
	            Duration remaining = Duration.between(offsetDateTime2, offsetDateTime);
	            Thread.sleep(Math.max(remaining.getSeconds()+1,1)*1000);
	            task.run();
	        } catch (Exception e) {
	            System.err.println("Erreur pendant l'action de " + characterId + " : " + e.getMessage());
	            e.printStackTrace();
	            try {
					Utils.SendPushBulletNotification("Artifacts Serveur","Erreur pendant l'action de " + characterId + " : " + e.getStackTrace().toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        } finally {
	            // Nettoyage automatique à la fin du thread
	        	try {
					Utils.SendPushBulletNotification("Artifacts Serveur","Fin de l'action pour " + characterId);
				} catch (IOException e) {
					e.printStackTrace();
				}
	        	runningActions.remove(characterId);
	            System.out.println("Action terminée ou interrompue pour " + characterId);
	        }
	    }, "CharacterAction-" + characterId);
	    actionThread.setName(task.getName());
	    runningActions.put(characterId, actionThread);
	    actionThread.start();
	}
	
	/*public void cancelAction(String characterId) {
        Future<?> future = runningActions.get(characterId);
        if (future != null && !future.isDone()) {
            future.cancel(true); // envoie une interruption au thread
        }
        runningActions.remove(characterId);
    }*/
	
	public void cancelAction(String characterId) {
		Thread t = runningActions.get(characterId);
        if (t != null && t.isAlive()) {
            t.interrupt(); // envoie une interruption au thread
        }
        runningActions.remove(characterId);
	}
	
	public void clearCompletedActions() {
        runningActions.entrySet().removeIf(entry -> entry.getValue().isAlive());
    }

	public MapsApi getMapsApi() {
		return mapsApi;
	}

	public MyCharactersApi getMyCharactersApi() {
		return myCharactersApi;
	}

	public CharactersApi getCharactersApi() {
		return charactersApi;
	}

	public ItemsApi getItemsApi() {
		return itemsApi;
	}
	
	public MyAccountApi getMyAccountApi()
	{
		return myAccountApi;
	}

	public EventsApi getEventsApi() {
		return eventsApi;
	}
}
