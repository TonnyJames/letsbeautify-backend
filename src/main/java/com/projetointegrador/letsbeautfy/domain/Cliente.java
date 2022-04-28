package com.projetointegrador.letsbeautfy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetointegrador.letsbeautfy.domain.dtos.ClienteDTO;
import com.projetointegrador.letsbeautfy.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Cliente extends Pessoa{

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(ClienteDTO obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
