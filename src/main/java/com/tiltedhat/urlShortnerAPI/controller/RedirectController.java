package com.tiltedhat.urlShortnerAPI.controller;

import com.tiltedhat.urlShortnerAPI.model.UrlMapping;
import com.tiltedhat.urlShortnerAPI.service.UrlMappingService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://spiffy-blini-477fea.netlify.app")
public class RedirectController {
    private final UrlMappingService urlMappingService;

    public RedirectController(UrlMappingService urlMappingService) {
        this.urlMappingService = urlMappingService;
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirect(@PathVariable String shortUrl){
        UrlMapping urlMapping = urlMappingService.getOriginalurl(shortUrl);
        if(urlMapping != null){
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Location", urlMapping.getOriginalUrl());
            return ResponseEntity.status(302).headers(httpHeaders).build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
