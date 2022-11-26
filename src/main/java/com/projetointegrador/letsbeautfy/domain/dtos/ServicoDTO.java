package com.projetointegrador.letsbeautfy.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetointegrador.letsbeautfy.domain.Agendamento;
import com.projetointegrador.letsbeautfy.domain.Servico;
import com.projetointegrador.letsbeautfy.domain.enums.Categoria;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ServicoDTO implements Serializable {

    private static final Long serialVersionUID = 1l;

    private Integer id;

    @NotNull(message = "O campo CATEGORIA é requerido")
    private Categoria categoria;

    @NotNull(message = "O campo NOME é requerido")
    private String nmNegocio;

    @NotNull(message = "O campo NÚMERO DE INSCRIÇÃO é requerido")
    private String nrInsc; //cpf ou cnpj

    @NotNull(message = "O campo TELEFONE é requerido")
    private String telefone;

    @NotNull(message = "O campo EMAIL é requerido")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    @NotNull(message = "O campo adminID é requerido")
    private Integer admin;

    private String nomeAdmin;

    private List<Agendamento> Agendamentos;

    public ServicoDTO() {
        //vazio
//        addPerfis(Perfil.SERVICO);
    }

    public ServicoDTO(Servico obj) {
        this.id = obj.getId();
        this.categoria = obj.getCategoria();
        this.nmNegocio = obj.getNmNegocio();
        this.nrInsc = obj.getNrInsc();
        this.telefone = obj.getTelefone();
        this.email = obj.getEmail();
        this.dataCriacao = obj.getDataCriacao();
        this.admin = obj.getAdmin().getId();
        this.nomeAdmin = obj.getAdmin().getNome();
        this.Agendamentos = obj.getAgendamentos();
    }

    //getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNmNegocio() {
        return nmNegocio;
    }

    public void setNmNegocio(String nmNegocio) {
        this.nmNegocio = nmNegocio;
    }

    public String getNrInsc() {
        return nrInsc;
    }

    public void setNrInsc(String nrInsc) {
        this.nrInsc = nrInsc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getNomeAdmin() {
        return nomeAdmin;
    }

    public void setNomeAdmin(String nomeAdmin) {
        this.nomeAdmin = nomeAdmin;
    }

    public List<Agendamento> getAgendamentos() {
        return Agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        Agendamentos = agendamentos;
    }
}
