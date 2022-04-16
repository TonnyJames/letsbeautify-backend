package com.projetointegrador.letsbeautfy.resources;

import com.projetointegrador.letsbeautfy.domain.Colaborador;
import com.projetointegrador.letsbeautfy.domain.dtos.ColaboradorDTO;
import com.projetointegrador.letsbeautfy.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorResource {

    //localhost:8080/colaboradores

    @Autowired
    private ColaboradorService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ColaboradorDTO> findById(@PathVariable Integer id){
        Colaborador obj = service.findById(id);
        return ResponseEntity.ok(new ColaboradorDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> findAll(){
        List<Colaborador> list = service.findAll();
        List<ColaboradorDTO> listSTO = list.stream().map(obj -> new ColaboradorDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listSTO);
    }
}
