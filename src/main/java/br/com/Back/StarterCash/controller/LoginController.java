package br.com.Back.StarterCash.controller;

import br.com.Back.StarterCash.dto.LoginRequest;
import br.com.Back.StarterCash.model.Aluno;
import br.com.Back.StarterCash.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://127.0.0.1:5501", allowCredentials = "true")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> logarAluno(@RequestBody LoginRequest req, HttpSession session) {
        if (req == null || req.getEmail() == null || req.getSenha() == null) {
            return ResponseEntity.badRequest().body("email e senha são obrigatórios");
        }

        Aluno aluno = loginService.logarAluno(req.getEmail(), req.getSenha());
        if (aluno == null) {
            // credenciais inválidas — 401
            return ResponseEntity.status(401).body("credenciais inválidas");
        }
        session.setAttribute("ALUNO_LOGADO", aluno.getId());
        session.setAttribute("ALUNO_ID", aluno.getId());
        session.setAttribute("ALUNO_NOME", aluno.getNome());
        session.setAttribute("ALUNO_XP", aluno.getXp());
        session.setAttribute("ALUNO_COINS", aluno.getCoins());
        session.setAttribute("TIPO_ACESSO", aluno.getPasse());

        // sucesso — retorna o aluno (sem o campo senha por causa do JsonProperty)
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/perfil")
    public ResponseEntity<?> perfil(HttpSession session) {

        Long alunoId = (Long) session.getAttribute("ALUNO_LOGADO");

        if (alunoId == null) {
            return ResponseEntity.status(401).body("não autenticado");
        }

        return ResponseEntity.ok("Aluno logado com ID: " + alunoId);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("logout realizado");
    }

}
