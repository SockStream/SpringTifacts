package com.artifacts.server.controller;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationShutdown implements DisposableBean {
	    @Override
	    public void destroy() throws InterruptedException {
	        for (int i = 0; i < 5; i++) {
	            System.out.println("Shutting down in " + (5 - i) + " seconds");
	            Thread.sleep(1000);
	    }
	}
}
