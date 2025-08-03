package com.codecproject1.urlshortner;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Service
public class UrlService {
    
    private final UrlRepository repository;
    private final UrlUtil util;
    
    public UrlService(UrlRepository repository, UrlUtil util) {
        this.repository = repository;
        this.util = util;
    }
    
    
    public UrlResponse createShortUrl(UrlRequest request) {
        String fullUrl = request.getUrl();
        Optional<UrlEntity> existingShortUrl = repository.findByOriginalUrl(fullUrl);
        UrlResponse response = new UrlResponse();
        
        if (existingShortUrl.isPresent()) {
            response.setKey(existingShortUrl.get().getUrlKey());
        } else {
            String newKey = util.generateUniqueKey();
            UrlEntity newEntity = new UrlEntity();
            newEntity.setUrlKey(newKey);
            newEntity.setOriginalUrl(request.getUrl());
            repository.save(newEntity);
            response.setKey(newEntity.getUrlKey());
        }
        return response;
    }
    
    public ResponseEntity<Object> getOriginalUrl(String urlKey) {
        Optional<UrlEntity> entityInDb = repository.findByUrlKey(urlKey);
        
        if (entityInDb.isPresent()) {
            UrlEntity url = entityInDb.get();
            url.incrementClickCount();
            repository.save(url);
            return ResponseEntity.status(302).location(URI.create(url.getOriginalUrl())).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
