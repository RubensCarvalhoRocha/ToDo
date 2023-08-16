package com.rubens.todo.controle;

import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin(origins = "http://localhost:4200/") //Cors Fix
public class Controle {
       
    //Para não precisar instanciar esse objeto em cada rota.
    @Autowired
    private TarefasRepositorio acao;

    @PostMapping("/")               	//Incluir
    public Tarefas cadastrar(@RequestBody Tarefas t){
        return acao.save(t);
    }

    @GetMapping("/")            	//Selecionar
    public Iterable<Tarefas> selecionar(){               
        return acao.findAll();
    }

    @PutMapping("/")         	//Atualizar
    public Tarefas atualizar(@RequestBody Tarefas t) {
            return acao.save(t);
    }

    @DeleteMapping("/{id}")//Deletar
    public void deletar(@PathVariable long id){
        acao.deleteById(id);
    }
}
