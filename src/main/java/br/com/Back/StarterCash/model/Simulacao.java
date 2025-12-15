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
}
