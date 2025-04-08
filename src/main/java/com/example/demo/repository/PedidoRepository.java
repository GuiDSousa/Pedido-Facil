package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pedido;

public interface PedidoRepository extends JpaRepository <Pedido, Long>{
    List<Pedido> findByDataHora (LocalDate dataHora);
    List<Pedido> findByCliente_NomeContainingIgnoreCase (String nome);
}
