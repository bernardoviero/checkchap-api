package com.example.checkchap.item;


import com.example.checkchap.tarefa.Tarefa;

public record ItemResponseDTO(Long id, String nome, Tarefa id_tarefa, int situacao) {
    public ItemResponseDTO(Item item){
        this(item.getId(), item.getNome(), item.getTarefa(), item.getSituacao());
    }
}
