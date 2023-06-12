package com.example.checkchap.controller;

import com.example.checkchap.item.Item;
import com.example.checkchap.item.ItemRepository;
import com.example.checkchap.item.ItemRequestDTO;
import com.example.checkchap.item.ItemResponseDTO;
import com.example.checkchap.tarefa.Tarefa;
import com.example.checkchap.tarefa.TarefaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemRepository repository;

    @PostMapping
    public String saveItem(@RequestBody ItemRequestDTO data){
        Item ItemData = new Item(data);
        try {
            repository.save(ItemData);
            return "success";
        } catch (Exception e) {
            return "Erro: " + e;
        }
    }
    @GetMapping
    public List<ItemResponseDTO> getAll(){

        List<ItemResponseDTO> listaItens = repository.findAll().stream().map(ItemResponseDTO::new).toList();
        return listaItens;
    }
    @GetMapping("/{tarefaId}")
    public ResponseEntity<ItemResponseDTO> getItensByTarefa(@PathVariable Long tarefaId) {
        Tarefa tarefa = repository.findByUrlId(urlId);

        if (tarefa != null) {
            TarefaResponseDTO responseDTO = new TarefaResponseDTO(tarefa);
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
