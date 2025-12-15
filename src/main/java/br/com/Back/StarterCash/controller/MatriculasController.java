package br.com.Back.StarterCash.controller;

import br.com.Back.StarterCash.model.Aluno;
import br.com.Back.StarterCash.model.Cursos;
import br.com.Back.StarterCash.model.Matriculas;
import br.com.Back.StarterCash.repository.AlunoRepository;
import br.com.Back.StarterCash.repository.CursosRepository;
import br.com.Back.StarterCash.repository.MatriculasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
@CrossOrigin(origins = "*")
public class MatriculasController {

    private final MatriculasRepository matriculasRepository;
    private final AlunoRepository alunosRepository;
    private final CursosRepository cursosRepository;

    public MatriculasController(
            MatriculasRepository matriculasRepository,
            AlunoRepository alunosRepository,
            CursosRepository cursosRepository
    ) {
        this.matriculasRepository = matriculasRepository;
        this.alunosRepository = alunosRepository;
        this.cursosRepository = cursosRepository;
    }

    // ======================================
    // POST - REALIZAR MATRÍCULA
    // ======================================
    @PostMapping
    public ResponseEntity<?> matricular(
            @RequestParam Long alunoId,
            @RequestParam Long cursoId
    ) {

        // 1️⃣ valida aluno
        Aluno aluno = alunosRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        // 2️⃣ valida curso
        Cursos curso = cursosRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        // 3️⃣ evita matrícula duplicada
        if (matriculasRepository.findByAlunoIdAndCursoId(alunoId, cursoId).isPresent()) {
            return ResponseEntity.badRequest().body("Aluno já matriculado neste curso");
        }

        // 4️⃣ cria matrícula
        Matriculas matricula = new Matriculas();
        matricula.setAluno(aluno);
        matricula.setCurso(curso);

        matriculasRepository.save(matricula);

        return ResponseEntity.ok("Matrícula realizada com sucesso");
    }

    // ======================================
    // GET - CURSOS DO ALUNO
    // ======================================
    @GetMapping("/aluno/{id}")
    public ResponseEntity<List<Matriculas>> listarCursosDoAluno(@PathVariable Long id) {
        return ResponseEntity.ok(matriculasRepository.findByAlunoId(id));
    }
}

