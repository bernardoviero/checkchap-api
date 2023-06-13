package com.example.checkchap.controller;

import com.example.checkchap.item.Item;
import com.example.checkchap.item.ItemRepository;
import com.example.checkchap.item.ItemRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemRepository repository;

    @PostMapping
    public Item saveItem(@RequestBody ItemRequestDTO data){
        Item itemData = new Item(data);
        repository.save(itemData);

        return itemData;
    }

    @GetMapping("{id_tarefa}")
    public List<Item> getItensById(@PathVariable(value = "id_tarefa") long id_tarefa){
        return repository.getItensByTarefaId(id_tarefa);
    }
}
