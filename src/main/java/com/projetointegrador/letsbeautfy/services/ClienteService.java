package com.projetointegrador.letsbeautfy.services;

import com.projetointegrador.letsbeautfy.domain.Cliente;
import com.projetointegrador.letsbeautfy.domain.Pessoa;
import com.projetointegrador.letsbeautfy.domain.dtos.ClienteDTO;
import com.projetointegrador.letsbeautfy.repositories.ClienteRepository;
import com.projetointegrador.letsbeautfy.repositories.PessoaRepository;
import com.projetointegrador.letsbeautfy.services.exceptions.DataIntegrityViolationException;
import com.projetointegrador.letsbeautfy.services.exceptions.ObjectnotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoudException("Objeto não encontrado! Id: " + id));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        objDTO.setId(null);
        validaPorCpfEEmail(objDTO);
        Cliente newObj = new Cliente(objDTO);
        return repository.save(newObj);
    }

    public Cliente update(Integer id, @Valid ClienteDTO objDto){
        objDto.setId(id);
        Cliente oldObj = findById(id);
        validaPorCpfEEmail(objDto);
        oldObj = new Cliente(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Cliente obj = findById(id);
        if(obj.getAgendamentos().size() > 0){
            throw new DataIntegrityViolationException("O cliente tem agendamentos e não pode ser deletado!");
        }
            repository.deleteById(id);
    }

    private void validaPorCpfEEmail(ClienteDTO objDTO) {
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
