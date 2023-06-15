package com.example.checkchap.tarefa;

import com.example.checkchap.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Tarefa findByUrlId(Long urlId);

    default Tarefa findTarefa(Long id) {
        Optional<Tarefa> optionalTarefa = findById(id);
        return optionalTarefa.orElse(null);
    }
}
