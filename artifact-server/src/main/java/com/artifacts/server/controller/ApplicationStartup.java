package com.artifacts.server.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openapitools.ApiException;
import org.openapitools.client.EventsApi;
import org.openapitools.client.model.ActiveEventSchema;
import org.openapitools.client.model.DataPageActiveEventSchema;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.artifacts.server.service.GameDataStore;
import com.artifacts.server.utils.Utils;

@Component
public class ApplicationStartup 
implements ApplicationListener<ApplicationReadyEvent>
{
	private final GameDataStore gameDataStore;
	
	public ApplicationStartup(GameDataStore gameDataStore)
	{
		this.gameDataStore = gameDataStore;
	}
	
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event)
	{
		try {
			Utils.SendPushBulletNotification("Artifacts Serveur", "serveur démarré");
			WatchEvents();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
	
	private void WatchEvents()
	{

		Thread t = new Thread(() -> {
			
			List<String> ActiveEventList = new ArrayList<String>();
			EventsApi eventsApi = gameDataStore.getEventsApi();
			
			while(true)
			{
				DataPageActiveEventSchema dataPageActiveEventSchema = null;
				try {
					dataPageActiveEventSchema = eventsApi.getAllActiveEventsEventsActiveGet(1, 100);
				} catch (ApiException e) {
					e.printStackTrace();
				}
				List<ActiveEventSchema> activeEventSchemaList = dataPageActiveEventSchema.getData();
				
				for(ActiveEventSchema activeEventSchema : activeEventSchemaList)
				{
					if (!ActiveEventList.contains(activeEventSchema.getCode()))
					{
						try {
							Utils.SendPushBulletNotification("Artifacts Serveur", "Nouvel évènement " + activeEventSchema.getCode());
						} catch (IOException e) {
							e.printStackTrace();
						}
						ActiveEventList.add(activeEventSchema.getCode());
					}
				}
				
				List<String> tmp = new ArrayList<String>();
				
				for (String eventEnregistré : ActiveEventList)
				{
					Boolean existe = false;
					
					for(ActiveEventSchema activeEventSchema : activeEventSchemaList)
					{
						if (activeEventSchema.getCode().equals(eventEnregistré))
						{
							tmp.add(eventEnregistré);
						}
					}
				}
				
				ActiveEventList = tmp;
				
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t.run();
	}
}
