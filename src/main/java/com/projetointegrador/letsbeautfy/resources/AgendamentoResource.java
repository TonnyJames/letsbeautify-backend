package com.projetointegrador.letsbeautfy.resources;

import com.projetointegrador.letsbeautfy.domain.Agendamento;
import com.projetointegrador.letsbeautfy.domain.dtos.AgendamentoDTO;
import com.projetointegrador.letsbeautfy.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResource {

    @Autowired
    private AgendamentoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AgendamentoDTO> findById(@PathVariable Integer id) {
        Agendamento obj = service.findById(id);
        return ResponseEntity.ok().body(new AgendamentoDTO(obj));
    }

}
