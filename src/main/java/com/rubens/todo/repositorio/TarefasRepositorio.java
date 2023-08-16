package com.rubens.todo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubens.todo.modelo.Tarefas;

public interface TarefasRepositorio extends JpaRepository<Tarefas, Long>{
    
}
