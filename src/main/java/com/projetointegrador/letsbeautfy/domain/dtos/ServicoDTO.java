package com.projetointegrador.letsbeautfy.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetointegrador.letsbeautfy.domain.Cliente;
import com.projetointegrador.letsbeautfy.domain.Servico;
import com.projetointegrador.letsbeautfy.domain.enums.Categoria;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class ServicoDTO implements Serializable {

    private static final Long serialVersionUID = 1l;

    protected Integer id;

    @NotNull(message = "O campo CATEGORIA é requerido")
    protected Categoria categoria;

    @NotNull(message = "O campo NOME é requerido")
    protected String nmNegocio;

    @NotNull(message = "O campo NÚMERO DE INSCRIÇÃO é requerido")
    protected String nrInsc; //cpf ou cnpj

    @NotNull(message = "O campo TELEFONE é requerido")
    protected String telefone;

    @NotNull(message = "O campo EMAIL é requerido")
    protected String email;

//    @NotNull(message = "O campo SENHA é requerido")
//    protected String senha;
//
//    protected Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    @NotNull(message = "O campo NOME é requerido")
    protected Cliente responsavel;

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
//
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
}
