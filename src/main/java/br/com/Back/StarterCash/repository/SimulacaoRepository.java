package br.com.Back.StarterCash.repository;

import br.com.Back.StarterCash.model.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimulacaoRepository extends JpaRepository<Simulacao, Long> {

    List<Simulacao> findByAlunoId(Long alunoId);

    List<Simulacao> findByAlunoIdAndAtivoTrue(Long alunoId);
}
