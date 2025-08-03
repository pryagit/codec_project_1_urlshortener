package com.codecproject1.urlshortner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urlshortener")
public class UrlController {
    
    private final UrlService service;
    
    public UrlController(UrlService service) {
        this.service = service;
    }
    
    @PostMapping("/shorten")
    public UrlResponse shortenUrl(@RequestBody UrlRequest request) {
        return service.createShortUrl(request);
    }
    
    @GetMapping("/redirect/{key}")
    public ResponseEntity<Object> redirect(@PathVariable String key) {
        return service.getOriginalUrl(key);
    }
    
}
