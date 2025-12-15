package br.com.Back.StarterCash.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "simulacoes")
public class Simulacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ===============================
    // RELAÇÃO COM ALUNO
    // ===============================
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    // ===============================
    // DADOS DO INVESTIMENTO
    // ===============================
    @Column(nullable = false, length = 30)
    private String tipoInvestimento; // BTC, CDB, POUPANCA...

    @Column(nullable = false)
    private double taxaAplicada; // taxa usada naquele momento

    @Column(nullable = false)
    private double valorInvestido;

    @Column(nullable = false)
    private double valorAtual;

    // ===============================
    // CONTROLE DE TEMPO
    // ===============================
    @Column(nullable = false)
    private LocalDateTime dataInicio;

    private LocalDateTime ultimaAtualizacao;

    // ===============================
    // STATUS
    // ===============================
    @Column(nullable = false)
    private boolean ativo = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public double getTaxaAplicada() {
        return taxaAplicada;
    }

    public void setTaxaAplicada(double taxaAplicada) {
        this.taxaAplicada = taxaAplicada;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
