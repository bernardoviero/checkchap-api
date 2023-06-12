package com.example.checkchap.item;

import com.example.checkchap.tarefa.Tarefa;

public record ItemRequestDTO(Tarefa id_tarefa, String nome, int situacao) {
}
