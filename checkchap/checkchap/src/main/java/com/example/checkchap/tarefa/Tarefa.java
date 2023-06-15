package com.example.checkchap.tarefa;

import com.example.checkchap.url.Url;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tarefas")
@Entity(name = "tarefas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarefa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_url")
    private Url url;

    private String titulo;

    public Tarefa(Long id) {
        this.id = id;
    }

    public Tarefa(TarefaRequestDTO data) {
        this.url = data.id_url();
        this.titulo = data.titulo();
    }
}
