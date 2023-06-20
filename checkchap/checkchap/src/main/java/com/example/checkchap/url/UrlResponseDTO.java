package com.example.checkchap.url;

import com.example.checkchap.item.Item;

public record UrlResponseDTO(String url, Long idUrl) {
        public UrlResponseDTO(String url, Long idUrl) {
            this.idUrl = idUrl;
            this.url = url;
        }

}
