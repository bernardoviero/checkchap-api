package com.example.checkchap.item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Itens")
@Entity(name = "Itens")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_tarefa;

    private String nome;

    private int situacao;

    public Item(ItemRequestDTO data){
        this.id_tarefa = data.id_tarefa();
        this.nome = data.nome();
        this.situacao = data.situacao();
    }
}
