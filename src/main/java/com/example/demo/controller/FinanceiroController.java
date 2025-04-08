package com.example.demo.controller;

import com.example.demo.model.Financeiro;
import com.example.demo.repository.FinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/financeiro")

public class FinanceiroController {
    
    @Autowired
    private FinanceiroRepository financeiroRepository;

    @GetMapping
    public String listarFinanceiro (Model model) {
        List <Financeiro> registros = financeiroRepository.findAll();
        model.addAttribute("registros", registros);
        return "financeiro/listar";
    }

    @GetMapping("/novo")
    public String novoRegistro(Model model) {
        model.addAttribute("registro", new Financeiro());
        return "financeiro/form";
    }

    @PostMapping("/salvar")
    public String salvarRegistro (@ModelAttribute Financeiro financeiro) {
        financeiroRepository.save(financeiro);
        return "redirect:/financeiro";
    }

    @GetMapping("/editar/{id}")
    public String editarRegistro (@PathVariable Long id, Model model) {
        var registro = financeiroRepository.findById(id);
        if (registro.isPresent()) {
            model.addAttribute("registro", registro.get());
            return "financeiro/form";
        } else {
            return "redirect:/financeiro";
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarRegistro (@PathVariable Long id) {
        financeiroRepository.deleteById(id);
        return "redirect:/financeiro";
    }

    
}

