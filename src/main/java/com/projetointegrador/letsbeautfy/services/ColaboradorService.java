package com.projetointegrador.letsbeautfy.services;

import com.projetointegrador.letsbeautfy.domain.Colaborador;
import com.projetointegrador.letsbeautfy.domain.Pessoa;
import com.projetointegrador.letsbeautfy.domain.dtos.ColaboradorDTO;
import com.projetointegrador.letsbeautfy.repositories.ColaboradorRepository;
import com.projetointegrador.letsbeautfy.repositories.PessoaRepository;
import com.projetointegrador.letsbeautfy.services.exceptions.DataIntegrityViolationException;
import com.projetointegrador.letsbeautfy.services.exceptions.ObjectnotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Colaborador findById(Integer id){
        Optional<Colaborador> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoudException("Objeto não encontrado! Id: " + id));
    }

    public List<Colaborador> findAll() {
        return repository.findAll();
    }

    public Colaborador create(ColaboradorDTO objDTO) {
        objDTO.setId(null);
        validaPorCpfEEmail(objDTO);
        Colaborador newObj = new Colaborador(objDTO);
        return repository.save(newObj);
    }

    private void validaPorCpfEEmail(ColaboradorDTO objDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("Cpf Já cadastrado");
        }
        obj = pessoaRepository.findByEmail(objDTO.getEmail());
            if (obj.isPresent() && obj.get().getId() != objDTO.getId()){
                throw new DataIntegrityViolationException("E-mail já cadastrado");
            }
    }
}
