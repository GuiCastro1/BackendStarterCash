package br.com.Back.StarterCash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "cursos")
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_curso", length = 100, nullable = false)
    private String nomeCurso;

    // Carga horária do curso (ex: 40 horas)
    @Column(nullable = false)
    private int horas;

    // Descrição detalhada
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;

    // Ex: INICIANTE, INTERMEDIARIO, AVANCADO
    @Column(length = 30, nullable = false)
    private String nivel;

    // Controle se o curso está disponível
    @Column(nullable = false)
    private boolean ativo = true;

    // Data de criação
    @Column(nullable = false, updatable = false)
    private LocalDateTime criadoEm;

    @OneToMany(mappedBy = "curso")
    @JsonIgnore
    private List<Matriculas> matriculas;

    @PrePersist
    public void prePersist() {
        this.criadoEm = LocalDateTime.now();
    }
}
