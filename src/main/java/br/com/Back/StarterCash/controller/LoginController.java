package br.com.Back.StarterCash.controller;

import br.com.Back.StarterCash.dto.LoginRequest;
import br.com.Back.StarterCash.model.Aluno;
import br.com.Back.StarterCash.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5501", allowCredentials = "true")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> logarAluno(@RequestBody LoginRequest req) {
        if (req == null || req.getEmail() == null || req.getSenha() == null) {
            return ResponseEntity.badRequest().body("email e senha são obrigatórios");
        }

        Aluno aluno = loginService.logarAluno(req.getEmail(), req.getSenha());
        if (aluno == null) {
            // credenciais inválidas — 401
            return ResponseEntity.status(401).body("credenciais inválidas");
        }

        // sucesso — retorna o aluno (sem o campo senha por causa do JsonProperty)
        return ResponseEntity.ok(aluno);
    }
}
