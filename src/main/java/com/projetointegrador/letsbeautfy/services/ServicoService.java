package com.projetointegrador.letsbeautfy.services;

import com.projetointegrador.letsbeautfy.domain.Cliente;
import com.projetointegrador.letsbeautfy.domain.Servico;
import com.projetointegrador.letsbeautfy.domain.dtos.ServicoDTO;
import com.projetointegrador.letsbeautfy.repositories.ServicoRepository;
import com.projetointegrador.letsbeautfy.services.exceptions.DataIntegrityViolationException;
import com.projetointegrador.letsbeautfy.services.exceptions.ObjectnotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    //    @Autowired
//    private ColaboradorService colaboradorService;
    @Autowired
    private ClienteService clienteService;

    public Servico findById(Integer id) {
        Optional<Servico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoudException("Objeto não encontrado! Id: " + id));
    }

    public List<Servico> findByAdmin(Integer id) throws Exception {
        try {
            List<Servico> objLista = repository.findByAdmin(id);
            return objLista;
        } catch (Exception e) {
            throw new ObjectnotFoudException("Erro ao buscar lista de servico pelo id do usuario: " + id);
        }
    }

    public List<Servico> findAll() {
        return repository.findAll();
    }

    public Servico create(ServicoDTO objDTO) {
        objDTO.setId(null);
//        objDTO.setSenha(encoder.encode(objDTO.getSenha()));
        validaPorNrInscEEmail(objDTO);
        Servico newObj = newServico(objDTO);
        return repository.save(newObj);
    }

    public Servico update(Integer id, @Valid ServicoDTO objDTO) {
        objDTO.setId(id);
        Servico oldObj = findById(id);

//        if(!objDTO.getSenha().equals((oldObj))) {
//            objDTO.setSenha(encoder.encode(objDTO.getSenha()));
//        }
        validaPorNrInscEEmail(objDTO);
        oldObj = newServico(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Servico obj = findById(id);
//        if (obj.getAgendamentos().size() > 0) {
//            throw new DataIntegrityViolationException("O serviço ainda possui agendamentos futuros e não pode ser deletado");
//        }
        repository.deleteById(id);
    }


    private Servico newServico(ServicoDTO obj) {

        Cliente admin = clienteService.findById(obj.getAdmin());
        Servico servico = new Servico();

        if (obj.getId() != null) {
            servico.setId(obj.getId());
        }

        servico.setCategoria(obj.getCategoria());
        servico.setNmNegocio(obj.getNmNegocio());
        servico.setNrInsc(obj.getNrInsc());
        servico.setTelefone(obj.getTelefone());
        servico.setEmail(obj.getEmail());
        servico.setAdmin(admin);

        return servico;
    }


    private void validaPorNrInscEEmail(ServicoDTO objDTO) {
        Optional<Servico> obj = repository.findByNrInsc(objDTO.getNrInsc());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("Numero de inscrição já cadastrado");
        }
        obj = repository.findByEmail(objDTO.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado");
        }
    }
}
