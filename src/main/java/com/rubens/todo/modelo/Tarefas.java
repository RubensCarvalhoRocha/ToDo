package com.rubens.todo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tarefas")
public class Tarefas {
    //Declarando as colunas da minha tabela:
    @Id                                                                 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //--> Gerador de Id automatico
    private long id;
    private String descricao;
    private boolean realizado;
    private int prioridade;

    //Getters e Setters:
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isRealizado() {
        return realizado;
    }
    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
