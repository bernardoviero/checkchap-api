package com.example.checkchap.controller;

import com.example.checkchap.item.Item;
import com.example.checkchap.item.ItemRepository;
import com.example.checkchap.item.ItemRequestDTO;
import com.example.checkchap.item.ItemResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
        repository.save(ItemData);
        return "sucesso";
    }
    @GetMapping
    public List<ItemResponseDTO> getAll(){

        List<ItemResponseDTO> listaItens = repository.findAll().stream().map(ItemResponseDTO::new).toList();
        return listaItens;
    }
}
