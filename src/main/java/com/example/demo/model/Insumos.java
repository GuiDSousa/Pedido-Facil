package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Insumos{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;
    private Double precoUnitario;
    private String unidadeMedida;
    private Double quantidadeEstoque;

    public Insumos() {
    }

    public Insumos (String nome, Double precoUnitario, String unidadeMedida, double quantidadeEstoque) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.unidadeMedida = unidadeMedida;
        this.quantidadeEstoque = quantidadeEstoque;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida (String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    
}