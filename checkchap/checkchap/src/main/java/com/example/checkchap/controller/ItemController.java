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

    @PutMapping("nome/{id_item}/{nome}")
    public Item updateNomeItem(@PathVariable(value = "id_item") Long id_item, @PathVariable(value = "nome") String nome){
        Item novoItem = repository.findItem(id_item);
        novoItem.setNome(nome);
        repository.save(novoItem);
        return novoItem;
    }

    @PutMapping("situacao/{id_item}/{situacao}")
    public Item updateSituacaoItem(@PathVariable(value = "id_item") Long id_item, @PathVariable(value = "situacao") int situacao){
        Item novoItem = repository.findItem(id_item);
        novoItem.setSituacao(situacao);
        repository.save(novoItem);

        return novoItem;
    }

    @DeleteMapping("{id_item}")
    public Item deleteItem(@PathVariable(value = "id_item") Long id_item){
        Item itemDeletado = repository.findItem(id_item);
        repository.deleteById(id_item);

        return itemDeletado;
    }
}
