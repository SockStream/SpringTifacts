package com.artifacts.server.controller;

import org.openapitools.ApiException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artifacts.server.service.ActionService;

@RestController
@RequestMapping("/api/all")
public class GlobalController {
	
    private final ActionService actionService;
    
    public GlobalController(ActionService actionService)
    {
    	this.actionService = actionService;
    }
    
    @GetMapping("/vider")
    public void vider() throws ApiException {
    	actionService.ViderInventaireTous();
    }
    
    @GetMapping("/cancel")
    public void Annuler() throws ApiException {
    	actionService.AnnulerTous();
    }

}
