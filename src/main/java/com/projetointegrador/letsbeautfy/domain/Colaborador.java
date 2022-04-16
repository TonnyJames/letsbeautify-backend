package com.projetointegrador.letsbeautfy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetointegrador.letsbeautfy.domain.dtos.ColaboradorDTO;
import com.projetointegrador.letsbeautfy.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Colaborador extends Pessoa{

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "colaborador")
    private List<Agendamentos> agendamentos = new ArrayList<>();

    public Colaborador() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Colaborador(ColaboradorDTO obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }

    public Colaborador(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }

    public List<Agendamentos> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamentos> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
