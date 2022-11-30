package com.projetointegrador.letsbeautfy.services;


import com.projetointegrador.letsbeautfy.domain.Agendamento;
import com.projetointegrador.letsbeautfy.domain.Cliente;
import com.projetointegrador.letsbeautfy.domain.Servico;
import com.projetointegrador.letsbeautfy.domain.enums.Categoria;
import com.projetointegrador.letsbeautfy.domain.enums.Horarios;
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

//        Colaborador colab1 = new Colaborador(null, "Christine", "82831771099", "christine@mail.com", encoder.encode("123"));
//        colab1.addPerfil(Perfil.COLABORADOR);
//        Colaborador colab2 = new Colaborador(null, "Abraham", "86237320067", "abraham@mail.com", encoder.encode("123"));
//        colab2.addPerfil(Perfil.COLABORADOR);
//        Colaborador colab3 = new Colaborador(null, "Andre", "09814693022", "andre@mail.com", encoder.encode("123"));
//        colab3.addPerfil(Perfil.COLABORADOR);

        Cliente cli1 = new Cliente(null, "Jackeline dos Santos Soares", "75409273052", "jack@mail.com", encoder.encode("123"));
        Cliente cli2 = new Cliente(null, "Bruna Pereira de Souza", "36464790005", "bruna@mail.com", encoder.encode("123"));
        Cliente cli3 = new Cliente(null, "Tonny James P. Dos Reis", "75909714058", "tonny@mail.com", encoder.encode("123"));
        Cliente cli4 = new Cliente(null, "Roger Yukio Delvalle", "62076562028", "roger@mail.com", encoder.encode("123"));
        Cliente cli5 = new Cliente(null, "Luma Taynara Guimaraes Yoshida", "42006330004", "luma@mail.com", encoder.encode("123"));
        Cliente cli6 = new Cliente(null, "André Santos Isidoro", "71807965066", "andre@mail.com", encoder.encode("123"));

        Servico serv1 = new Servico(null, Categoria.ESTETICA, "Jack Beautify", "53416478000163", "(11) 2764-6317", "jackbeautyfy@mail.com", cli1);
        Servico serv2 = new Servico(null, Categoria.BELEZA, "Bruna's Studio Hair", "56462241000107", "(98) 3398-5480", "brunahair@mail.com", cli2);
        Servico serv3 = new Servico(null, Categoria.BARBEARIA, "Descanso dos Rudes", "07422607000109", "(21) 2986-4393", "descansodosrudes@mail.com", cli3);
        Servico serv4 = new Servico(null, Categoria.BARBEARIA, "Barba Pirata", "16106001000155", "(84) 3548-5964", "barbapirata@mail.com", cli4);

        Agendamento agend1 = new Agendamento(null, serv4, "2022-12-28",Horarios.H3, "Corte cabelo e barba", "Corte sem maquina", cli3);
        Agendamento agend2 = new Agendamento(null, serv1, "2022-12-11",Horarios.H2, "Luzes e unhas", "Não usar marca Luminous", cli2);
        Agendamento agend3 = new Agendamento(null, serv2, "2022-12-12", Horarios.H1,  "Cilios e Sombrancelha", "", cli1);
        Agendamento agend4 = new Agendamento(null, serv3, "2022-12-05",Horarios.H3, "Corte cabelo", "Estilo Pompador", cli4);
        Agendamento agend5 = new Agendamento(null, serv2, "2022-12-05",Horarios.H3, "Unhas", "Unhas de Gel manutenção", cli5);
        Agendamento agend6 = new Agendamento(null, serv4, "2022-12-05",Horarios.H3, "Corte cabelo", "Moicano", cli6);

//        colaboradorRepository.saveAll(Arrays.asList(colab1, colab2, colab3));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
        servicoRepository.saveAll(Arrays.asList(serv1, serv2, serv3, serv4));
        agendamentosRepository.saveAll(Arrays.asList(agend1, agend2, agend3, agend4, agend5, agend6));
//
    }
}
