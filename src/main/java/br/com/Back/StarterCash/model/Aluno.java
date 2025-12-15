package br.com.Back.StarterCash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
//import br.com.Back.StarterCash.model.TipoAcesso;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 80, nullable = false, unique = true)
    private String email;

    @Column(length = 5, nullable = false)
    private int idade;

    @Column(length = 100, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @Column(length = 50, nullable = false)
    private int coins = 50;

    @Column(length = 50, nullable = false)
    private  int xp = 50;
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private TipoAcesso  passe = TipoAcesso.BASICO;

    @OneToMany(mappedBy = "aluno")
    private List<Simulacao> simulacoes;

    @OneToMany(mappedBy = "aluno")
    @JsonIgnore
    private List<Matriculas> matriculas;

    public List<Matriculas> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matriculas> matriculas) {
        this.matriculas = matriculas;
    }

    public List<Simulacao> getSimulacoes() {
        return simulacoes;
    }

    public void setSimulacoes(List<Simulacao> simulacoes) {
        this.simulacoes = simulacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public TipoAcesso getPasse() {
        return passe;
    }

    public void setPasse(TipoAcesso passe) {
        this.passe = passe;
    }
}

