package com.artifacts.server.service;

import com.artifacts.server.config.ArtifactsApiProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.openapitools.ApiException;
import org.openapitools.client.CharactersApi;
import org.openapitools.client.model.CharacterResponseSchema;
import org.springframework.http.*;
import java.util.Map;

@Service
public class ArtifactsApiClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final GameDataStore gameDataStore;

    public ArtifactsApiClient(GameDataStore gameDataStore) {
    	this.gameDataStore = gameDataStore;
    }

    public Map<String, Object> getStatsFor(String characterName) throws ApiException {
    	
    	CharactersApi charactersApi = gameDataStore.getCharactersApi();
    	CharacterResponseSchema characterResponseSchema = charactersApi.getCharacterCharactersNameGet(characterName);

    	gameDataStore.updateCharacter(characterResponseSchema.getData());
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.registerModule(new JavaTimeModule());
    	Map<String, Object> map = objectMapper.convertValue(characterResponseSchema.getData(), new TypeReference<Map<String, Object>>() {});
    	
        return map;
    }
}