package com.example.checkchap.controller;

import com.example.checkchap.item.Item;
import com.example.checkchap.item.ItemRepository;
import com.example.checkchap.item.ItemRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/item")
public class ItemController {
    @Autowired
    private ItemRepository repository;

    @PostMapping
    public Item saveItem(@RequestBody ItemRequestDTO data){
        Item itemData = new Item(data);
        repository.save(itemData);

        return itemData;
    }

    @GetMapping("/{idTarefa}")
    public List<Item> getItensById(@RequestParam("idTarefa") long id_tarefa){
        return repository.getItensByTarefaId(id_tarefa);
    }

    @PutMapping("nome/{idItem}/{nome}")
    public Item updateNomeItem(@PathVariable(value = "idItem") Long idItem, @PathVariable(value = "nome") String nome){
        Item novoItem = repository.findItem(idItem);
        novoItem.setNome(nome);
        repository.save(novoItem);
        return novoItem;
    }

    @PutMapping("situacao/{idItem}/{situacao}")
    public Item updateSituacaoItem(@PathVariable(value = "idItem") Long idItem, @PathVariable(value = "situacao") int situacao){
        Item novoItem = repository.findItem(idItem);
        novoItem.setSituacao(situacao);
        repository.save(novoItem);

        return novoItem;
    }

    @DeleteMapping("{idItem}")
    public Item deleteItem(@PathVariable(value = "idItem") Long idItem){
        Item itemDeletado = repository.findItem(idItem);
        repository.deleteById(idItem);

        return itemDeletado;
    }
}
