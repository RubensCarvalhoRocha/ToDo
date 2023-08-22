package com.rubens.todo.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubens.todo.modelo.Tarefas;
import com.rubens.todo.repositorio.TarefasRepositorio;


@RestController
@CrossOrigin(origins = "http://localhost:4200/") // Cors Fix
public class Controle {

    @Autowired
    private TarefasRepositorio acao;

    @PostMapping("/") // Incluir
    public List<Tarefas> cadastrar(@RequestBody Tarefas t) {
        acao.save(t);
        return listar();
    }

    @GetMapping("/") // Selecionar
    public List<Tarefas> listar() {
        
        // Recurso de Ordenação
        Sort sort = Sort.by(
            Sort.Order.desc("prioridade")
                           );
        
        return acao.findAll(sort);
    }

    @PutMapping("/") // Atualizar
    public List<Tarefas> atualizar(@RequestBody Tarefas t) {
        acao.save(t);
        return listar();
    }

    @DeleteMapping("/{id}") // Deletar
    public List<Tarefas> deletar(@PathVariable long id) {
        acao.deleteById(id);
        return listar();
    }
}
