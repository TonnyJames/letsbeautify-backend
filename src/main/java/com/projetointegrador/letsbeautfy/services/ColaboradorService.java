package com.projetointegrador.letsbeautfy.services;

import com.projetointegrador.letsbeautfy.domain.Colaborador;
import com.projetointegrador.letsbeautfy.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;

    public Colaborador findById(Integer id){
        Optional<Colaborador> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
