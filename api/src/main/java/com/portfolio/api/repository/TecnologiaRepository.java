package com.portfolio.api.repository;

import com.portfolio.api.model.Projeto;
import com.portfolio.api.model.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long> {
}
