package com.portfolio.api.controller;

import com.portfolio.api.model.Projeto;
import com.portfolio.api.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping
    public List<Projeto> listarTodos() {
        return projetoService.listarTodos();
    }

    @PostMapping
    public Projeto salvar(@Valid @RequestBody Projeto projeto) {
        return projetoService.salvar(projeto);
    }

    // buscar por id — GET /projetos/1
    @GetMapping("/{id}")
    public Projeto buscarPorId(@PathVariable Long id) {
        return projetoService.buscarPorId(id);
    }

    // atualizar — PUT /projetos/1
    @PutMapping("/{id}")
    public Projeto atualizar(@PathVariable Long id, @Valid @RequestBody Projeto projeto) {
        return projetoService.atualizar(id, projeto);
    }

    // deletar — DELETE /projetos/1
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        projetoService.deletar(id);
    }
}
