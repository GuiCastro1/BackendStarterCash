package br.com.Back.StarterCash.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "matriculas")
public class Matriculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muitos registros de matrícula para um aluno
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    // Muitos registros de matrícula para um curso
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Cursos curso;

    // Data da matrícula
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataMatricula;

    // ATIVA | CONCLUIDA | CANCELADA
    @Column(length = 20, nullable = false)
    private String status;

    // Progresso do curso (0 a 100)
    @Column(nullable = false)
    private int progresso = 0;

    // Data de conclusão (opcional)
    private LocalDateTime dataConclusao;

    @PrePersist
    public void prePersist() {
        this.dataMatricula = LocalDateTime.now();
        this.status = "ATIVA";
    }

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

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public LocalDateTime getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDateTime dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}
