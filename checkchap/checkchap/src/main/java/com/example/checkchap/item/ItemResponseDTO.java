package com.example.checkchap.item;


public record ItemResponseDTO(Long id, String nome, Long id_tarefa, int situacao) {
    public ItemResponseDTO(Item item){
        this(item.getId(), item.getNome(), item.getId_tarefa(), item.getSituacao());
    }
}
