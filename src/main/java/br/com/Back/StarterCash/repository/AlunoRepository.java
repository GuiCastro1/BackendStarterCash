package br.com.Back.StarterCash.repository;


import br.com.Back.StarterCash.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
