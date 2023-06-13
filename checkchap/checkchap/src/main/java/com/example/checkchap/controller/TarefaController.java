package com.example.checkchap.controller;

import com.example.checkchap.tarefa.Tarefa;
import com.example.checkchap.tarefa.TarefaRepository;
import com.example.checkchap.tarefa.TarefaRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @PostMapping
    public Tarefa saveTarefa(@RequestBody TarefaRequestDTO data){
        Tarefa tarefaData = new Tarefa(data);
        repository.save(tarefaData);

        return tarefaData;
    }

    @GetMapping("/{idUrl}")
    public Tarefa getTarefaByURL(@PathVariable Long idUrl) {
        Tarefa tarefa = repository.findByUrlId(idUrl);

        return tarefa;
    }
}
