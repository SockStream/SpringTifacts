package com.artifacts.server.controller;

import java.util.List;

import org.openapitools.ApiException;
import org.openapitools.client.model.CharacterSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artifacts.server.service.ActionService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
private final ActionService actionService;
    
    public AccountController(ActionService actionService)
    {
    	this.actionService = actionService;
    }
    
    @GetMapping("/getpersonnages")
    public List<CharacterSchema> vider() throws ApiException {
    	return actionService.GetCharacters();
    }
}
