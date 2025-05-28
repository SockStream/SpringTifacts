package com.artifacts.server.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Service
public class EtatActionsService {
    private final Map<String, String> etats = new ConcurrentHashMap<>();

    public void setEtat(String personnage, String etat) {
        etats.put(personnage, etat);
    }

    public String getEtat(String personnage) {
        return etats.getOrDefault(personnage, "inconnu");
    }
}