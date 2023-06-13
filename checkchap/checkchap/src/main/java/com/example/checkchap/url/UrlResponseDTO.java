package com.example.checkchap.url;

import com.example.checkchap.item.Item;

public record UrlResponseDTO(String url) {
    public UrlResponseDTO(Url url){
        this(url.getUrl());
    }

}
