package com.projetointegrador.letsbeautfy.repositories;

import com.projetointegrador.letsbeautfy.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentosRepository extends JpaRepository<Agendamento, Integer> {

    List<Agendamento> findAgendamentoByCliente_Cpf(String cpf);
}
