package com.projetointegrador.letsbeautfy.resources;

import com.projetointegrador.letsbeautfy.domain.Agendamento;
import com.projetointegrador.letsbeautfy.domain.dtos.AgendamentoDTO;
import com.projetointegrador.letsbeautfy.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> findAll(){
        List<Agendamento> list = service.findAll();
        List<AgendamentoDTO> listDTO = list.stream().map(obj -> new AgendamentoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> create(@Valid @RequestBody AgendamentoDTO objDTO){
        Agendamento obj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AgendamentoDTO> update(@PathVariable Integer id, @Valid @RequestBody AgendamentoDTO objDTO){
        Agendamento newObj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new AgendamentoDTO(newObj));
    }

}
