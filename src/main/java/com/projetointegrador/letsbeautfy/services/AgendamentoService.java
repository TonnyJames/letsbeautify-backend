package com.projetointegrador.letsbeautfy.services;

import com.projetointegrador.letsbeautfy.domain.Agendamento;
import com.projetointegrador.letsbeautfy.repositories.AgendamentosRepository;
import com.projetointegrador.letsbeautfy.services.exceptions.ObjectnotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentosRepository repository;

    public Agendamento findById(Integer id){
        Optional<Agendamento> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoudException("Objeto Não encontrado " + id));
    }

    public List<Agendamento> findAll() {
        return repository.findAll();
    }
}
