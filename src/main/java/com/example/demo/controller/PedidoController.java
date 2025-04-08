package com.example.demo.controller;

import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;// serve para a busca de um pedido específico

@Controller
@RequestMapping("/pedidos")

public class PedidoController {
    
    private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public String listarPedidos(Model model) {
        try {
            logger.info ("Listando todos os pedidos.");
            List<Pedido> pedidos = pedidoRepository.findAll();
            model.addAttribute("pedidos", pedidos);
            return "pedidos/lista"; // nome da view
        } catch (Exception e) {
            logger.error("Erro ao listar pedidos: {} ", e.getMessage(), e);
            return "error"; // nome da view de erro
        }
    }

    @GetMapping("/novo")
    public String novoPedido(Model model) {
        try {
            logger.info("Abrindo formulário para novo pedido.");
            model.addAttribute("pedido", new Pedido());
            return "pedido/form";
        } catch (Exception e) {
            logger.error("Erro ao abrir formulário de pedido: {}", e.getMessage(), e);
            return "error"; // nome da view de erro
        }
    }
    
    @PostMapping("/salvar")
    public String salvarPedido(@ModelAttribute Pedido pedido) {
        try {
            logger.info("Salvando pedido: {}", pedido);
            pedidoRepository.save(pedido);
            return "redirect:/pedidos"; // redireciona para a lista de pedidos
        } catch (Exception e) {
            logger.error("Erro ao salvar pedido: {}", e.getMessage(), e);
            return "error"; // nome da view de erro
        }
    }

    @GetMapping("/editar/{id}")
    public String editarPedido(@PathVariable Long id, Model model) {
        try {
            logger.info("Editando pedido com ID: {}", id);
            Optional<Pedido> pedido = pedidoRepository.findById(id);
            if (pedido.isPresent()) {
                model.addAttribute("pedido", pedido.get());
                return "pedido/form"; // nome da view de edição
            } else {
                logger.warn("Pedido com ID {} não encontrado.", id);
                return "redirect:/pedidos"; // redireciona para a lista de pedidos
            }
        } catch (Exception e) {
            logger.error("Erro ao editar o pedido: {}", e.getMessage(), e);
            return "error"; // nome da view de erro
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarPedido(@PathVariable Long id) {
        try {
            logger.info ("Deletando o pedido com ID: {}", id);
            pedidoRepository.deleteById(id);
            return "redirect:/pedidos"; // redireciona para a lista de pedidos
        } catch (Exception e) {
            logger.error("Erro ao deletar o pedido: {}", e.getMessage(), e);
            return "error"; // nome da view de erro
        }
    }
}
