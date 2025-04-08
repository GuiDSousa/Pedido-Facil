package com.example.demo.repository;

import com.example.demo.model.Insumos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsumosRepository extends JpaRepository <Insumos, Long>  {
    List<Insumos> findByNomeContainingIgnoreCase(String nome); // Busca insumos pelo nome, ignorando maiúsculas e minúsculas
}
