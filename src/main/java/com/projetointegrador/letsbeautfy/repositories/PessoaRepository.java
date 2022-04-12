package com.projetointegrador.letsbeautfy.repositories;

import com.projetointegrador.letsbeautfy.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {


}
