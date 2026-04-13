package com.portfolio.api.controller;

import com.portfolio.api.model.Tecnologia;
import com.portfolio.api.service.TecnologiaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnologias")
public class TecnologiaController {
    private final TecnologiaService tecnologiaService;

    public TecnologiaController(TecnologiaService tecnologiaService) {
        this.tecnologiaService = tecnologiaService;
    }

    @GetMapping
    public List<Tecnologia> listarTodos() {
        return tecnologiaService.listarTodos();
    }

    @PostMapping
    public Tecnologia salvar(@Valid @RequestBody Tecnologia tecnologia) {
        return tecnologiaService.salvar(tecnologia);
    }

    // buscar por id — GET /projetos/1
    @GetMapping("/{id}")
    public Tecnologia buscarPorId(@PathVariable Long id) {
        return tecnologiaService.buscarPorId(id);
    }

    // atualizar — PUT /projetos/1
    @PutMapping("/{id}")
    public Tecnologia atualizar(@PathVariable Long id, @Valid @RequestBody Tecnologia tecnologia) {
        return tecnologiaService.atualizar(id, tecnologia);
    }

    // deletar — DELETE /projetos/1
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tecnologiaService.deletar(id);
    }
}
