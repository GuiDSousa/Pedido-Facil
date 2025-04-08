package com.example.demo.repository;

import org.springframework.data.jpa.repository.*;
import com.example.demo.model.Financeiro;

import java.time.LocalDate;
import java.util.List;

public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {
    List<Financeiro> findByData (LocalDate data);
}
