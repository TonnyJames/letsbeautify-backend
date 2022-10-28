package com.projetointegrador.letsbeautfy.services;


import com.projetointegrador.letsbeautfy.domain.Agendamento;
import com.projetointegrador.letsbeautfy.domain.Cliente;
import com.projetointegrador.letsbeautfy.domain.Colaborador;
import com.projetointegrador.letsbeautfy.domain.Servico;
import com.projetointegrador.letsbeautfy.domain.enums.Categoria;
import com.projetointegrador.letsbeautfy.domain.enums.Horarios;
import com.projetointegrador.letsbeautfy.domain.enums.Perfil;
import com.projetointegrador.letsbeautfy.repositories.AgendamentosRepository;
import com.projetointegrador.letsbeautfy.repositories.ClienteRepository;
import com.projetointegrador.letsbeautfy.repositories.ColaboradorRepository;
import com.projetointegrador.letsbeautfy.repositories.ServicoRepository;
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
    private ServicoRepository servicoRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB(){

        Colaborador colab1 = new Colaborador(null, "Christine", "828.317.710-99", "christine@mail.com", encoder.encode("123"));
        colab1.addPerfil(Perfil.COLABORADOR);
        Colaborador colab2 = new Colaborador(null, "Abraham", "862.373.200-67", "abraham@mail.com", encoder.encode("123"));
        colab2.addPerfil(Perfil.COLABORADOR);
        Colaborador colab3 = new Colaborador(null, "Andre", "098.146.930-22", "andre@mail.com", encoder.encode("123"));
        colab3.addPerfil(Perfil.COLABORADOR);

        Cliente cli1 = new Cliente(null, "Jack", "754.092.730-52", "jack@mail.com", encoder.encode("123"));
        Cliente cli2 = new Cliente(null, "Bruna", "364.647.900-05", "bruna@mail.com", encoder.encode("123"));
        Cliente cli3 = new Cliente(null, "Tonny", "759.097.140-58", "tonny@mail.com", encoder.encode("123"));
        Cliente cli4 = new Cliente(null, "Roger", "620.765.620-28", "roger@mail.com", encoder.encode("123"));

        Servico serv1 = new Servico(null, Categoria.ESTUDIO_DE_ESTETICA, "Jack Beautify", "53416478000163", "(66) 2764-6317", "jackbeauty@mail.com", cli1);
        Servico serv2 = new Servico(null, Categoria.SALAO_DE_BELEZA, "Lia Hair", "56462241000107", "(98) 3398-5480", "liahair@mail.com", cli2);
        Servico serv3 = new Servico(null, Categoria.BARBARIA, "Descanso dos Rudes", "07422607000109", "(21) 2986-4393", "ddr@mail.com", cli3);
        Servico serv4 = new Servico(null, Categoria.BARBARIA, "Barba Pirata", "16106001000155", "(84) 3548-5964", "barbapirata@mail.com", cli4);


        Agendamento agend1 = new Agendamento(null, "2020-03-12", Horarios.H1,  "visita 001", "Primeira visita", colab1,cli1, serv3);
        Agendamento agend2 = new Agendamento(null, "2021-04-11",Horarios.H2, "visita 002", "Cabelos e unhas ", colab2,cli2, serv2);
        Agendamento agend3 = new Agendamento(null, "2022-05-29",Horarios.H3, "visita 003", "limpeza de pele", colab3,cli3, serv1);

//        serv1.setAgendamentos(Arrays.asList(agend3));
//        serv2.setAgendamentos(Arrays.asList(agend2));
//        serv3.setAgendamentos(Arrays.asList(agend1));

        colaboradorRepository.saveAll(Arrays.asList(colab1, colab2, colab3));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4));
        servicoRepository.saveAll(Arrays.asList(serv1, serv2, serv3, serv4));
        agendamentosRepository.saveAll(Arrays.asList(agend1, agend2, agend3));
//
    }
}
