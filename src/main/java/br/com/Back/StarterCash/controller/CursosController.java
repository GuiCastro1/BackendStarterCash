package br.com.Back.StarterCash.controller;

import br.com.Back.StarterCash.model.Cursos;
import br.com.Back.StarterCash.repository.CursosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*")
public class CursosController {

    private final CursosRepository cursosRepository;

    public CursosController(CursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;
    }

    // ============================
    // GET - LISTAR CURSOS ATIVOS
    // ============================
    @GetMapping
    public ResponseEntity<List<Cursos>> listarCursos() {
        List<Cursos> cursos = cursosRepository.findByAtivoTrue();
        return ResponseEntity.ok(cursos);
    }
}

