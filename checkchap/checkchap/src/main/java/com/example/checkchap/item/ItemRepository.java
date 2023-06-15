package com.example.checkchap.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> getItensByTarefaId(Long tarefaId);
    default Item findItem(Long id) {
        Optional<Item> optionalItem = findById(id);
        return optionalItem.orElse(null);
    }
}
