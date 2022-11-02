package com.projetointegrador.letsbeautfy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetointegrador.letsbeautfy.domain.enums.Categoria;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CollectionTable(name = "CATEGORIA")
    private Categoria categoria;
    private String nmNegocio;

    @Column(unique = true)
    private String nrInsc; //cpf ou cnpj
    private String telefone;

    @Column(unique = true)
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Cliente admin;

    @JsonIgnore
    @OneToMany(mappedBy = "servico")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Servico() {
        //vazio
    }

    public Servico(Integer id, Categoria categoria, String nmNegocio, String nrInsc, String telefone, String email, Cliente admin) {
        this.id = id;
        this.categoria = categoria;
        this.nmNegocio = nmNegocio;
        this.nrInsc = nrInsc;
        this.telefone = telefone;
        this.email = email;
        this.admin = admin;
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

    public Cliente getAdmin() {
        return admin;
    }

    public void setAdmin(Cliente responsavel) {
        this.admin = responsavel;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return Objects.equals(id, servico.id) && Objects.equals(nmNegocio, servico.nmNegocio) && Objects.equals(nrInsc, servico.nrInsc) && Objects.equals(email, servico.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nmNegocio, nrInsc, email);
    }
}
