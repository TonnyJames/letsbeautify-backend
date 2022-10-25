package com.projetointegrador.letsbeautfy.services;


import com.projetointegrador.letsbeautfy.domain.Agendamento;
import com.projetointegrador.letsbeautfy.domain.Cliente;
import com.projetointegrador.letsbeautfy.domain.Colaborador;
import com.projetointegrador.letsbeautfy.domain.enums.Horarios;
import com.projetointegrador.letsbeautfy.domain.enums.Perfil;
import com.projetointegrador.letsbeautfy.repositories.AgendamentosRepository;
import com.projetointegrador.letsbeautfy.repositories.ClienteRepository;
import com.projetointegrador.letsbeautfy.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AgendamentosRepository agendamentosRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB(){
        Colaborador colab1 = new Colaborador(null, "Bruna", "828.317.710-99", "bruna@mail.com", encoder.encode("123"));
        colab1.addPerfil(Perfil.ADMIN);
        Colaborador colab2 = new Colaborador(null, "Tonny", "862.373.200-67", "tonny@mail.com", encoder.encode("123"));
        colab2.addPerfil(Perfil.ADMIN);
        Colaborador colab3 = new Colaborador(null, "Roger", "098.146.930-22", "roger@mail.com", encoder.encode("123"));
        colab3.addPerfil(Perfil.COLABORADOR);

        Cliente cli1 = new Cliente(null, "Jack", "754.092.730-52", "jack@mail.com", encoder.encode("123"));
        Cliente cli2 = new Cliente(null, "Lia", "364.647.900-05", "Lia@mail.com", encoder.encode("123"));
        Cliente cli3 = new Cliente(null, "Fatima", "759.097.140-58", "fatima@mail.com", encoder.encode("123"));
        Cliente cli4 = new Cliente(null, "Graziella", "620.765.620-28", "graziella@mail.com", encoder.encode("123"));

        Agendamento agend1 = new Agendamento(null, "2020-03-12", Horarios.H1,  "visita 001", "Primeira visita", colab1,cli1);
        Agendamento agend2 = new Agendamento(null, "2021-04-11",Horarios.H2, "visita 002", "Cabelos e unhas ", colab2,cli2);
        Agendamento agend3 = new Agendamento(null, "2022-05-29",Horarios.H3, "visita 003", "limpeza de pele", colab3,cli3);

        colaboradorRepository.saveAll(Arrays.asList(colab1, colab2, colab3));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4));
        agendamentosRepository.saveAll(Arrays.asList(agend1, agend2, agend3));
    }
}
