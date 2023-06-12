package com.example.checkchap.tarefa;

import com.example.checkchap.url.Url;

public record TarefaResponseDTO(Long id, Url id_url, String titulo) {
    public TarefaResponseDTO(Tarefa tarefa){
        this(tarefa.getId(), tarefa.getUrl(), tarefa.getTitulo());
    }
}
