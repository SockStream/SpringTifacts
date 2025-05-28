package com.artifacts.server.controller;

import java.io.IOException;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.artifacts.server.utils.Utils;

@Component
public class ApplicationStartup 
implements ApplicationListener<ApplicationReadyEvent>
{
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event)
	{
		try {
			Utils.SendPushBulletNotification("Artifacts Serveur", "serveur démarré");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}
}
