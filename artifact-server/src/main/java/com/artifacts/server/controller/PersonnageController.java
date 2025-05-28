package com.artifacts.server.controller;

import com.artifacts.server.service.ActionService;
import com.artifacts.server.service.ArtifactsApiClient;

import org.openapitools.ApiException;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/personnages")
public class PersonnageController {

    private final ArtifactsApiClient client;
    private final ActionService actionService;

    public PersonnageController(ArtifactsApiClient client, ActionService actionService) {
        this.client = client;
        this.actionService = actionService;
    }

    @GetMapping("/{id}/stats")
    public Map<String, Object> getStats(@PathVariable String id) throws ApiException {
        return client.getStatsFor(id);
    }

    @GetMapping("/{id}/vider")
    public void vider(@PathVariable String id) throws ApiException {
    	actionService.ViderInventaire(id);
    }
    
    @GetMapping("/{id}/farmer/{resourceId}")
    public void farmerResource(@PathVariable String id, @PathVariable String resourceId)
    {
    	actionService.Farmer(id,resourceId);
    }
    
    @GetMapping("/{id}/basher/{monsterId}")
    public void basherResource(@PathVariable String id, @PathVariable String monsterId)
    {
    	actionService.Basher(id,monsterId, null);
    }
    
    @GetMapping("/{id}/basher/{monsterId}/{additionalParams}")
    public void basherResource(@PathVariable String id, @PathVariable String monsterId, String additionalParams)
    {
    	actionService.Basher(id,monsterId, additionalParams);
    }

    @GetMapping("/{id}/cancel")
    public void Annuler(@PathVariable String id) throws ApiException {
    	actionService.ArreterAction(id);
    }

    @GetMapping("/{id}/task")
    public void RéaliserTache(@PathVariable String id) throws ApiException {
    	actionService.RéaliserTache(id,null);
    }

    @GetMapping("/{id}/task/{additionalParams}")
    public void RéaliserTache(@PathVariable String id, @PathVariable String additionalParams) throws ApiException {
    	actionService.RéaliserTache(id,additionalParams);
    }

    @GetMapping("/{id}/craft/{code}/{quantity}")
    public void Crafter(@PathVariable String id, @PathVariable String code, @PathVariable int quantity) throws ApiException {
    	actionService.Crafter(id,code,quantity);
    }


    @GetMapping("/{id}/recycle/{itemId}/{quantity}")
    public void Recycler(@PathVariable String id, @PathVariable String itemId, @PathVariable int quantity) throws ApiException {
    	actionService.Recycler(id, itemId, quantity);
    }
    
    @GetMapping("/{id}/equip/{objectList}")
    public void Equiper(@PathVariable String id, @PathVariable String objectList) throws ApiException {
    	actionService.Equiper(id,objectList);
    }
    
    @GetMapping("/{id}/status")
    public String GetStatus(@PathVariable String id)
    {
    	return actionService.GetStatus(id);
    }
    
    @GetMapping("{id}/getEquipment")
    public String GetEquipment(@PathVariable String id)
    {
    	return actionService.GetEquipment(id);
    }
}