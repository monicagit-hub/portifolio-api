package com.portfolio.api.service;

import com.portfolio.api.model.Projeto;
import com.portfolio.api.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {
    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }

    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    // buscar por id
    public Projeto buscarPorId(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }

    // atualizar
    public Projeto atualizar(Long id, Projeto projetoAtualizado) {
        Projeto projeto = buscarPorId(id);
        projeto.setNome(projetoAtualizado.getNome());
        projeto.setDescricao(projetoAtualizado.getDescricao());
        projeto.setImagemUrl(projetoAtualizado.getImagemUrl());
        projeto.setLinkDemo(projetoAtualizado.getLinkDemo());
        projeto.setLinkGithub(projetoAtualizado.getLinkGithub());
        projeto.setDocumentacao(projetoAtualizado.getDocumentacao());
        return projetoRepository.save(projeto);
    }

    // deletar
    public void deletar(Long id) {
        buscarPorId(id);
        projetoRepository.deleteById(id);
    }
}
