package com.example.demo.model;

import jakarta.persistence.Entity;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;
    private String descricao;
    private String precoVenda;

    @ManyToMany
    private List<Insumos> insumos;

    public Produto() {
    }

    public Produto(String nome, String descricao, String precoVenda, List<Insumos> insumos) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.insumos = insumos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(String precoVenda) {
        this.precoVenda = precoVenda;
    }

    public List <Insumos> getInsumos() {
        return insumos;
    }

    public void setInsumos(List <Insumos> insumos) {
        this.insumos = insumos;
    }
}
