package com.example.checkchap.tarefa;

public record TarefaResponseDTO(Long id,String titulo) {
    public TarefaResponseDTO(Tarefa tarefa){
        this(tarefa.getId(), tarefa.getTitulo());
    }
}
