package com.portfolio.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ProjetoTecnologia {

        // chave primária composta
        @EmbeddedId
        private ProjetoTecnologiaId id;

        // referência ao projeto
        @ManyToOne
        @MapsId("projetoId")
        @JoinColumn(name = "projeto_id")
        private Projeto projeto;

        // referência à tecnologia
        @ManyToOne
        @MapsId("tecnologiaId")
        @JoinColumn(name = "tecnologia_id")
        private Tecnologia tecnologia;

        // campo extra da tabela intermediária
        private String motivoUso;
    }

