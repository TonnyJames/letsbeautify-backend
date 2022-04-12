package com.projetointegrador.letsbeautfy.domain;

import java.util.ArrayList;
import java.util.List;

public class Colaborador extends Pessoa{

    private List<Agendamentos> agendamentos = new ArrayList<>();

    public Colaborador() {
        super();
    }

    public Colaborador(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public List<Agendamentos> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamentos> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
