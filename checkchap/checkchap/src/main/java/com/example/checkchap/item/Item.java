package com.example.checkchap.item;

import com.example.checkchap.tarefa.Tarefa;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Itens")
@Entity(name = "Itens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_tarefa")
    private Tarefa tarefa;

    private String nome;

    private int situacao;

    public Item(ItemRequestDTO data){
        this.tarefa = data.id_tarefa();
        this.nome = data.nome();
        this.situacao = data.situacao();
    }
}
