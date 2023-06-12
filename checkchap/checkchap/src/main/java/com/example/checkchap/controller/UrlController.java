package com.example.checkchap.controller;

import com.example.checkchap.url.Url;
import com.example.checkchap.url.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/urls")
public class UrlController {
    @Autowired
    private UrlRepository urlRepository;

    @PostMapping
    @ResponseBody
    public String saveUrl(@RequestBody Url url) {
        try{
            urlRepository.save(url);
            return "success";
        }catch(Exception e){
            return "Erro: " + e;
        }
    }

    @GetMapping("/{url}")
    public ResponseEntity<String> redirectUrl(@PathVariable String url) {
        Url urlRedirect = urlRepository.findByUrl(url);

        if (url != null) {
            return ResponseEntity.ok("Redirecionado com sucesso para " + urlRedirect.getUrl());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("URL não encontrada para a url " + url);
        }
    }
}