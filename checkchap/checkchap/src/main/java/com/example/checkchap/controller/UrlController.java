package com.example.checkchap.controller;

import com.example.checkchap.url.Url;
import com.example.checkchap.url.UrlRepository;
import com.example.checkchap.url.UrlResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("")
public class UrlController {
    @Autowired
    private UrlRepository urlRepository;

    @PostMapping
    @ResponseBody
    public Url saveUrl(@RequestBody Url url) {
        Url urlData = url;
        LocalDateTime now = LocalDateTime.now();
        urlData.setData(now);
        urlRepository.save(urlData);
        return url;
    }

    @GetMapping("/{url}")
    public ResponseEntity<UrlResponseDTO> redirectUrl(@PathVariable String url) {
        Url urlRedirect = urlRepository.findLatestByUrl(url);

        if (urlRedirect != null) {
            UrlResponseDTO responseDto = new UrlResponseDTO(urlRedirect.getUrl(), urlRedirect.getId());
            return ResponseEntity.ok(responseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}