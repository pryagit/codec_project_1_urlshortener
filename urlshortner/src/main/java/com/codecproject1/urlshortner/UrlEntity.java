package com.codecproject1.urlshortner;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String originalUrl;
    
    @Column(nullable = false, unique = true, name = "url_key")  // map column name explicitly
    private String urlKey;
    
    @Column
    private int clickCount = 0;
    
    public void incrementClickCount() {
        this.clickCount++;
    }
    
    public String getOriginalUrl() {
        return originalUrl;
    }
    
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
    
    public String getUrlKey() {
        return urlKey;
    }
    
    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
    }
}
