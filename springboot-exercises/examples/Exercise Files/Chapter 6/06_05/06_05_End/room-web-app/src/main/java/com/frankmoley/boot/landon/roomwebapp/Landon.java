package com.frankmoley.boot.landon.roomwebapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Landon implements Endpoint<Map<String, String>>{

    @Value("${landon.logging.logger-name}")
    private String loggingName;

    @Override
    public String getId() {
        return "landon";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isSensitive() {
        return false;
    }

    @Override
    public Map<String, String> invoke() {
        Map<String, String> results = new HashMap<>();
        results.put("Logger Name", loggingName);
        results.put("Author Name", "Frank Moley");
        return results;
    }
}
