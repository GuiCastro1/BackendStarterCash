//package br.com.Back.StarterCash.dto;
//
//import br.com.Back.StarterCash.model.Aluno;
////import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
////@AllArgsConstructor
//@NoArgsConstructor
//public class RankingDto {
//    private String nome;
//    private int xp;
//    public RankingDto(Aluno aluno) {
//        this.nome = aluno.getNome();
//        this.xp = aluno.getXp();
//    }
//
//}
package br.com.Back.StarterCash.dto;

import br.com.Back.StarterCash.model.Aluno;

public class RankingDto {
    private String nome;
    private int xp;

    public RankingDto() {}

    public RankingDto(String nome, int xp) {
        this.nome = nome;
        this.xp = xp;
    }

    public RankingDto(Aluno aluno) {
        this.nome = aluno.getNome();
        this.xp = aluno.getXp();
    }

    // GETTERS (essenciais para o Jackson)
    public String getNome() {
        return nome;
    }

    public int getXp() {
        return xp;
    }

    // SETTERS (opcionais)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
