package com.example.checkchap.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> getItensByTarefaId(Long tarefaId);
}
