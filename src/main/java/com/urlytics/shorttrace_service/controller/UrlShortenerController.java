package com.urlytics.shorttrace_service.controller;

import com.urlytics.shorttrace_service.model.ShortenUrlRequest;
import com.urlytics.shorttrace_service.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortenerController {


    @Autowired
    UrlShortenerService urlShortenerService;

    @PostMapping("/shorten-url")
    public String shortenUrl(@RequestBody ShortenUrlRequest request){

        return urlShortenerService.shortenUrl(request);
    }
}
