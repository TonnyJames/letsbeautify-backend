package com.projetointegrador.letsbeautfy.repositories;

import com.projetointegrador.letsbeautfy.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    Optional<Servico> findByNrInsc(String nrInsc);
    Optional<Servico> findByEmail(String email);
}
