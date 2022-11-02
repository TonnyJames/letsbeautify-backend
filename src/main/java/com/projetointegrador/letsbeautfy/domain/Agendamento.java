package com.projetointegrador.letsbeautfy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetointegrador.letsbeautfy.domain.enums.Horarios;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Agendamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_criação")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAgendada;

    private Horarios horaAgendada;

//    private Prioridade prioridade;
//    private Status status;
    private String titulo;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    public Agendamento() {
        super();
    }

    public Agendamento(Integer id, String dataAgendada, Horarios horaAgendada, String titulo, String observacoes, Colaborador colaborador, Cliente cliente, Servico servico) {
        this.id = id;
        this.dataAgendada = LocalDate.parse(dataAgendada);
        this.horaAgendada = horaAgendada;
//        this.prioridade = prioridade;
//        this.status = status;
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.colaborador = colaborador;
        this.cliente = cliente;
        this.servico = servico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(LocalDate dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public Horarios getHoraAgendada() { return horaAgendada; }

    public void setHoraAgendada(Horarios horaAgendada) {
        this.horaAgendada = horaAgendada;
    }

//    public Prioridade getPrioridade() {
//        return prioridade;
//    }
//
//    public void setPrioridade(Prioridade prioridade) {
//        this.prioridade = prioridade;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
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

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
