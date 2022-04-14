package com.projetointegrador.letsbeautfy.resources;

import com.projetointegrador.letsbeautfy.domain.Colaborador;
import com.projetointegrador.letsbeautfy.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorResource {

    //localhost:8080/colaboradores

    @Autowired
    private ColaboradorService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Colaborador> findById(@PathVariable Integer id){
        Colaborador obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }
}
