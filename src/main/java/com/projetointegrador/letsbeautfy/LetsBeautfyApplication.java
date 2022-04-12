package com.projetointegrador.letsbeautfy;

import com.projetointegrador.letsbeautfy.domain.Agendamentos;
import com.projetointegrador.letsbeautfy.domain.Cliente;
import com.projetointegrador.letsbeautfy.domain.Colaborador;
import com.projetointegrador.letsbeautfy.domain.enums.Perfil;
import com.projetointegrador.letsbeautfy.domain.enums.Prioridade;
import com.projetointegrador.letsbeautfy.domain.enums.Status;
import com.projetointegrador.letsbeautfy.repositories.AgendamentosRepository;
import com.projetointegrador.letsbeautfy.repositories.ClienteRepository;
import com.projetointegrador.letsbeautfy.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class LetsBeautfyApplication implements CommandLineRunner {

    @Autowired
    private ColaboradorRepository colaboradorRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private AgendamentosRepository agendamentosRepository;

    public static void main(String[] args) {
        SpringApplication.run(LetsBeautfyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Colaborador colab1 = new Colaborador(null, "Jorge", "828.317.710-99", "jorge@mail.com", "123");
        colab1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Jack", "754.092.730-52", "jack@mail.com", "123");

        Agendamentos agend1 = new Agendamentos(null, Prioridade.ALTA, Status.ABERTO, "visita 001", "Primeira visita", colab1,cli1);

        colaboradorRepository.saveAll(Arrays.asList(colab1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        agendamentosRepository.saveAll(Arrays.asList(agend1));

    }
}
