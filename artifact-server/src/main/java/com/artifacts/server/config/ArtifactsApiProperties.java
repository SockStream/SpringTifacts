package com.artifacts.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "artifacts.api")
public class ArtifactsApiProperties {
    private String token;
    private String baseUrl;

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }
}