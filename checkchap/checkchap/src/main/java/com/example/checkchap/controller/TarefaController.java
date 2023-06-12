package com.example.checkchap.controller;

import com.example.checkchap.tarefa.Tarefa;
import com.example.checkchap.tarefa.TarefaRepository;
import com.example.checkchap.tarefa.TarefaRequestDTO;
import com.example.checkchap.tarefa.TarefaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarefa")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @PostMapping
    public String saveTarefa(@RequestBody TarefaRequestDTO data){
        Tarefa tarefaData = new Tarefa(data);
        try{
            repository.save(tarefaData);
            return "success";
        }catch(Exception e){
            return "Erro: " + e;
        }
    }
    @GetMapping
    public List<TarefaResponseDTO> getAll(){
        List<TarefaResponseDTO> listaTarefas = repository.findAll().stream().map(TarefaResponseDTO::new).toList();
        return listaTarefas;
    }

    @GetMapping("/{urlId}")
    public ResponseEntity<TarefaResponseDTO> getTarefaByURL(@PathVariable Long urlId) {
        Tarefa tarefa = repository.findByUrlId(urlId);

        if (tarefa != null) {
            TarefaResponseDTO responseDTO = new TarefaResponseDTO(tarefa);
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
