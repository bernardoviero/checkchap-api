package com.example.checkchap.controller;

import com.example.checkchap.tarefa.Tarefa;
import com.example.checkchap.tarefa.TarefaRepository;
import com.example.checkchap.tarefa.TarefaRequestDTO;
import com.example.checkchap.tarefa.TarefaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("tarefa")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @PostMapping
    public void saveTarefa(@RequestBody TarefaRequestDTO data){
        Tarefa tarefaData = new Tarefa(data);
        repository.save(tarefaData);
        return;
    }
    @GetMapping
    public List<TarefaResponseDTO> getAll(){

        List<TarefaResponseDTO> listaTarefas = repository.findAll().stream().map(TarefaResponseDTO::new).toList();
        return listaTarefas;
    }
}
