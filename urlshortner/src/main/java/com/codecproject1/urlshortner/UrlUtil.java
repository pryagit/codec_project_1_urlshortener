package com.codecproject1.urlshortner;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class UrlUtil {
    private final UrlConfig urlConfig;
    public UrlUtil(UrlConfig urlConfig) {
        this.urlConfig = urlConfig;
    }
    
    public String generateUniqueKey() {
        int keyLength = urlConfig.getKeyLength();
        String allowedCharacters = urlConfig.getAllowedCharacters();
        
        StringBuilder keyBuilder = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < keyLength; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            keyBuilder.append(allowedCharacters.charAt(randomIndex));
        }
        
        return keyBuilder.toString();
    }
}
