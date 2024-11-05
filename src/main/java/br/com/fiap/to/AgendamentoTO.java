package br.com.fiap.to;

import java.time.LocalDate;

public class AgendamentoTO {

    private Long id;
    private String carro;
    private String cliente;
    private LocalDate dataAgendamento;
    private String descricaoProblema;

    public AgendamentoTO() {}

    public AgendamentoTO(Long id, String carro, String cliente, LocalDate dataAgendamento, String descricaoProblema) {
        this.id = id;
        this.carro = carro;
        this.cliente = cliente;
        this.dataAgendamento = dataAgendamento;
        this.descricaoProblema = descricaoProblema;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }
}
