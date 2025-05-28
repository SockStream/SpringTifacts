package com.artifacts.server.controller;

import java.io.IOException;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import com.artifacts.server.utils.Utils;

@Component
public class ApplicationShutdown implements DisposableBean {
	    
	@Override
    public void destroy() throws InterruptedException {
    	try {
			Utils.SendPushBulletNotification("Artifacts Serveur", "Shutdown serveur");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
