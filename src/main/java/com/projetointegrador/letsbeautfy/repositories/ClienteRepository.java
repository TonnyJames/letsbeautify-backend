package com.projetointegrador.letsbeautfy.repositories;

import com.projetointegrador.letsbeautfy.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
