package br.com.Back.StarterCash.repository;

import br.com.Back.StarterCash.model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursosRepository extends JpaRepository<Cursos, Long> {

    List<Cursos> findByAtivoTrue();
}
