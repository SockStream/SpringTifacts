package com.artifacts.server.bigbrain;

import org.openapitools.ApiException;
import org.openapitools.client.model.CharacterSchema;
import org.springframework.stereotype.Component;

import com.artifacts.server.service.ActionService;
import com.artifacts.server.service.GameDataStore;

@Component
public class BigBrain {

	private final GameDataStore gameDataStore;
	private final ActionService actionService;
	
	public BigBrain(GameDataStore gameDtaStore, ActionService actionService)
	{
		this.gameDataStore = gameDtaStore;
		this.actionService = actionService;
	}
	
	
	
	public void DoProcess() throws ApiException
	{
		for(CharacterSchema characterSchema : gameDataStore.getCharacters())
		{
			String status = gameDataStore.GetAction(characterSchema.getName());
			if(status.isBlank())
			{
				actionService.RéaliserTache(characterSchema.getName(), null);
			}
		}
	}
}
