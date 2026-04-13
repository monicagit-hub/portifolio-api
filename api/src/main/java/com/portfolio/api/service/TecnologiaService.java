package com.portfolio.api.service;

import com.portfolio.api.model.Projeto;
import com.portfolio.api.model.Tecnologia;
import com.portfolio.api.repository.TecnologiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnologiaService {
    private final TecnologiaRepository tecnologiaRepository;

    public TecnologiaService(TecnologiaRepository tecnologiaRepository) {
        this.tecnologiaRepository = tecnologiaRepository;
    }

    public List<Tecnologia> listarTodos() {
        return tecnologiaRepository.findAll();
    }

    public Tecnologia salvar(Tecnologia tecnologia) {
        return tecnologiaRepository.save(tecnologia);
    }

    // buscar por id
    public Tecnologia buscarPorId(Long id) {
        return tecnologiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tecnologia não encontrada"));
    }

    // atualizar
    public Tecnologia atualizar(Long id, Tecnologia tecnologiaAtualizada) {
        Tecnologia tecnologia = buscarPorId(id);
        tecnologia.setNome(tecnologiaAtualizada.getNome());
        tecnologia.setIconeUrl(tecnologiaAtualizada.getIconeUrl());
        return tecnologiaRepository.save(tecnologia);
    }
        // deletar
        public void deletar (Long id){
            buscarPorId(id);
            tecnologiaRepository.deleteById(id);
        }
    }

