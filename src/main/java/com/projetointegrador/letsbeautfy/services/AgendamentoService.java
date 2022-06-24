package com.projetointegrador.letsbeautfy.services;

import com.projetointegrador.letsbeautfy.domain.Agendamento;
import com.projetointegrador.letsbeautfy.domain.Cliente;
import com.projetointegrador.letsbeautfy.domain.Colaborador;
import com.projetointegrador.letsbeautfy.domain.dtos.AgendamentoDTO;
import com.projetointegrador.letsbeautfy.domain.enums.Prioridade;
import com.projetointegrador.letsbeautfy.domain.enums.Status;
import com.projetointegrador.letsbeautfy.repositories.AgendamentosRepository;
import com.projetointegrador.letsbeautfy.services.exceptions.ObjectnotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentosRepository repository;
    @Autowired
    private ColaboradorService colaboradorService;
    @Autowired
    private ClienteService clienteService;

    public Agendamento findById(Integer id){
        Optional<Agendamento> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoudException("Objeto Não encontrado " + id));
    }

    public List<Agendamento> findAll() {
        return repository.findAll();
    }

    public Agendamento create(AgendamentoDTO objDTO) {
        return repository.save(newAgendamento(objDTO));
    }

    public Agendamento update(Integer id, AgendamentoDTO objDTO) {
        objDTO.setId(id);
        Agendamento oldObj = findById(id);
        oldObj = newAgendamento(objDTO);
        return repository.save(oldObj);
    }



    private Agendamento newAgendamento(AgendamentoDTO obj){
        Colaborador colaborador = colaboradorService.findById(obj.getColaborador());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Agendamento agendamento = new Agendamento();
        if(obj.getId() != null ){
            agendamento.setId(obj.getId());
        }

//        if (obj.getStatus().equals(2)){
//          agendamento.setDataAgendada(LocalDate.now());
//    }
        agendamento.setDataAgendada(LocalDate.parse(obj.getDataAgendada()));
        agendamento.setColaborador(colaborador);
        agendamento.setCliente(cliente);
        agendamento.setTitulo(obj.getTitulo());
        agendamento.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        agendamento.setStatus(Status.toEnum(obj.getStatus()));
        agendamento.setObservacoes(obj.getObservacoes());
        return agendamento;
    }


}
