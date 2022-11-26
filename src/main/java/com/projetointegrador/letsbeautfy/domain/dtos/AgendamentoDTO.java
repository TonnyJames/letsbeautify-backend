package com.projetointegrador.letsbeautfy.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetointegrador.letsbeautfy.domain.Agendamento;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class AgendamentoDTO implements Serializable {

    private static final long serialVersionUID =1L;

    private Integer id;

    @NotNull(message = "O campo SERVIÇO é obrigatório")
    private Integer servico;

    private String nomeServico;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dataAgendada;
    @NotNull
    private Integer horaAgendada;

//    @NotNull(message = "O campo PRIORIDADE é obrigatório")
//    private Integer prioridade;
//    @NotNull(message = "O campo STATUS é obrigatório")
//    private Integer status;

    @NotNull(message = "O campo TÍTULO é obrigatório")
    private String titulo;

    private String observacoes;

//    private Integer colaborador;
    @NotNull(message = "O campo CLIENTE é obrigatório")
    private Integer cliente;

//    private String nomeColaborador;
    private String nomeCliente;

    public AgendamentoDTO() {
        super();
    }

    public AgendamentoDTO(Agendamento obj) {
        this.id = obj.getId();
        this.servico = obj.getServico().getId();
        this.nomeServico = obj.getServico().getNmNegocio();
        this.dataCriacao = obj.getDataCriacao();
        this.dataAgendada = obj.getDataAgendada().toString();
        this.horaAgendada = obj.getHoraAgendada().getCodigo();
//        this.prioridade = obj.getPrioridade().getCodigo();
//        this.status = obj.getStatus().getCodigo();
        this.titulo = obj.getTitulo();
        this.observacoes = obj.getObservacoes();
//        this.colaborador = obj.getColaborador().getId();
        this.cliente = obj.getCliente().getId();
        this.nomeCliente = obj.getCliente().getNome();
//        this.nomeColaborador = obj.getColaborador().getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServico() {
        return servico;
    }

    public void setServico(Integer servico) {
        this.servico = servico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(String dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public Integer getHoraAgendada() {
        return horaAgendada;
    }

    public void setHoraAgendada(Integer horaAgendada) {
        this.horaAgendada = horaAgendada;
    }

//    public Integer getPrioridade() {
//        return prioridade;
//    }
//
//    public void setPrioridade(Integer prioridade) {
//        this.prioridade = prioridade;
//    }
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

//    public Integer getColaborador() {
//        return colaborador;
//    }
//
//    public void setColaborador(Integer colaborador) {
//        this.colaborador = colaborador;
//    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

//    public String getNomeColaborador() {
//        return nomeColaborador;
//    }
//
//    public void setNomeColaborador(String nomeColaborador) {
//        this.nomeColaborador = nomeColaborador;
//    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
