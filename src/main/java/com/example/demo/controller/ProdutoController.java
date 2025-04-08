package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")

public class ProdutoController {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String listarProdutos(Model model) {
        try {
            logger.info("Listando todos os produtos.");
            List<Produto> produtos = produtoRepository.findAll();
            model.addAttribute(" produtos", produtos);
            return "produto/lista"; // nome da view
        } catch (Exception e) {
            logger.error("Erro ao listar produtos: {} ", e.getMessage(), e);
            return "error"; // nome da view de erro
        }
    }

    @GetMapping("/novo")
    public String novoProduto(Model model) {
        try {
            logger.info("Abrindo formulário para novo produto.");
            model.addAttribute("produto", new Produto());
            return "produto/form";
        } catch (Exception e) {
            logger.error("Erro ao abrir formulário de produto: {}", e.getMessage(), e);
            return "error"; // nome da view de erro
        }
    }

    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute Produto produto) {
        try {
            logger.info("Salvando produto: {}", produto);
            produtoRepository.save(produto);
            return "redirect:/produtos"; // redireciona para a lista de produtos
        } catch (Exception e) {
            logger.error("Erro ao salvar produto: {}", e.getMessage(), e);
            return "error"; // nome da view de erro
        }
    }

    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        try {
            logger.info("Editando produto com ID: {}", id);
            Optional<Produto> produto = produtoRepository.findById(id);
            if (produto.isPresent()) {
                model.addAttribute("produto", produto.get());
                return "produto/form";
            } else {
                logger.warn("Produto com ID {} não encontrado.", id);
                return "redirect:/produtos"; // redireciona para a lista de produtos
            }
        } catch (Exception e) {
            logger.error("Erro ao editar produto: {}", e.getMessage(), e);
            return "error"; // nome da view de erro
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Long id) {
        try {
            logger.info("Deletando produto com ID: {}", id);
            produtoRepository.deleteById(id);
            return "redirect:/produtos"; // redireciona para a lista de produtos
        } catch (Exception e) {
            logger.error("Erro ao deletar produto: {}", e.getMessage(), e);
            return "error"; // nome da view de erro
        }
    }
}
