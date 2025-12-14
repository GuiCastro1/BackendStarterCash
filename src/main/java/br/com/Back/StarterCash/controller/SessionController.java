package br.com.Back.StarterCash.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5501", allowCredentials = "true")
@RestController
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/me")
    public ResponseEntity<?> me(HttpSession session) {

        Long id = (Long) session.getAttribute("ALUNO_ID");

        if (id == null) {
            return ResponseEntity.status(401).build();
        }

        Map<String, Object> dados = new HashMap<>();
        dados.put("id", id);
        dados.put("nome", session.getAttribute("ALUNO_NOME"));
        dados.put("xp", session.getAttribute("ALUNO_XP"));
        dados.put("coins", session.getAttribute("ALUNO_COINS"));
        dados.put("tipoAcesso", session.getAttribute("TIPO_ACESSO"));

        return ResponseEntity.ok(dados);
    }
}
