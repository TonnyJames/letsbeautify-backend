package com.projetointegrador.letsbeautfy.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetointegrador.letsbeautfy.domain.dtos.ServicoDTO;
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

//    private String senha;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "PERFIS")
//    private Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente responsavel;

    @JsonIgnore
    @OneToMany(mappedBy = "servico")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Servico() {
//        addPerfis(Perfil.SERVICO);
    }

    public Servico(Integer id, Categoria categoria, String nmNegocio, String nrInsc, String telefone, String email/*, String senha*/, Cliente responsavel) {
        this.id = id;
        this.categoria = categoria;
        this.nmNegocio = nmNegocio;
        this.nrInsc = nrInsc;
        this.telefone = telefone;
        this.email = email;
//        this.senha = senha;
//        addPerfis(Perfil.SERVICO);
        this.responsavel = responsavel;
    }

    public Servico(ServicoDTO obj) {
        this.id = obj.getId();
        this.categoria = obj.getCategoria();
        this.nmNegocio = obj.getNmNegocio();
        this.nrInsc = obj.getNrInsc();
        this.telefone = obj.getTelefone();
        this.email = obj.getEmail();
//        this.senha = obj.getSenha();
//        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
        this.responsavel = obj.getResponsavel();
//        addPerfis(Perfil.SERVICO);
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

//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }

//    public Set<Perfil> getPerfis()  {
//        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
//    }
//
//    public void addPerfis(Perfil perfil) {
//        this.perfis.add(perfil.getCodigo());
//    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Cliente getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Cliente responsavel) {
        this.responsavel = responsavel;
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
