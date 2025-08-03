package com.codecproject1.urlshortner;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "short-url")
public class UrlConfig {
    private String allowedCharacters;
    private int keyLength;
    
    public String getAllowedCharacters() {
        return allowedCharacters;
    }
    
    public void setAllowedCharacters(String allowedCharacters) {
        this.allowedCharacters = allowedCharacters;
    }
    
    public int getKeyLength() {
        return keyLength;
    }
    
    public void setKeyLength(int keyLength) {
        this.keyLength = keyLength;
    }
}