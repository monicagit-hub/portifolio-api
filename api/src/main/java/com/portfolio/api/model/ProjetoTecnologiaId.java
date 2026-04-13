package com.portfolio.api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoTecnologiaId implements Serializable {

    private Long projetoId;
    private Long tecnologiaId;
}