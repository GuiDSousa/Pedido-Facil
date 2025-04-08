package com.example.demo.repository;

import com.example.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{
    List<Produto> findByNomeContainingIgnoreCase(String nome);
    // This class will handle the database operations for the Produto entity
}
