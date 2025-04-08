package com.example.demo.repository;

import com.example.demo.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface  ItemRepository extends JpaRepository<ItemPedido, Long> {
    List<ItemPedido> findByPedido_Id(Long pedidoId);
    
}
