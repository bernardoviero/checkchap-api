package com.example.checkchap.controller;

import com.example.checkchap.tarefa.Tarefa;
import com.example.checkchap.tarefa.TarefaRepository;
import com.example.checkchap.tarefa.TarefaRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @PutMapping("/{idTarefa}/{titulo}")
    public Tarefa updateTituloTarefa(@PathVariable(value = "idTarefa") Long idTarefa, @PathVariable(value = "titulo") String titulo){
        Tarefa tarefa = repository.findTarefa(idTarefa);
        tarefa.setTitulo(titulo);
        repository.save(tarefa);

        return tarefa;
    }

    @DeleteMapping("{idTarefa}")
    public Tarefa deleteTarefa(@PathVariable(value = "idTarefa") Long idTarefa){
        Tarefa tarefaDelatada = repository.findTarefa(idTarefa);
        repository.deleteById(idTarefa);

        return tarefaDelatada;
    }
}
