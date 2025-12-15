package br.com.Back.StarterCash.repository;

import br.com.Back.StarterCash.model.Matriculas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MatriculasRepository extends JpaRepository<Matriculas, Long> {

    // Listar cursos de um aluno
    List<Matriculas> findByAlunoId(Long alunoId);

    // Evitar matrícula duplicada
    Optional<Matriculas> findByAlunoIdAndCursoId(Long alunoId, Long cursoId);
}

