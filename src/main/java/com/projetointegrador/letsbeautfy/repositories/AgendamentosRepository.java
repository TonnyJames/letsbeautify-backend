package com.projetointegrador.letsbeautfy.repositories;

import com.projetointegrador.letsbeautfy.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentosRepository extends JpaRepository<Agendamento, Integer> {
}
