package br.com.Back.StarterCash.controller;

import br.com.Back.StarterCash.model.Aluno;
import br.com.Back.StarterCash.repository.AlunoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/atualizacao")
@CrossOrigin(origins = "*")
public class AtualizacaoController {

    private final AlunoRepository alunosRepository;

    public AtualizacaoController(AlunoRepository alunosRepository) {
        this.alunosRepository = alunosRepository;
    }

    // =====================================
    // PUT - SOMAR XP
    // =====================================
//    @PutMapping("/aluno/{id}/xp")
//    public ResponseEntity<?> somarXp(
//            @PathVariable Long id,
//            @RequestParam int xp
//    ) {
//
//        if (xp <= 0) {
//            return ResponseEntity.badRequest().body("XP deve ser maior que zero");
//        }
//
//        Aluno aluno = alunosRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
//
//        aluno.setXp(aluno.getXp() + xp);
//
//        alunosRepository.save(aluno);
//
//        return ResponseEntity.ok(aluno.getXp());
//    }
    @PutMapping("/aluno/{id}/xp")
    public ResponseEntity<?> somarXp(
            @PathVariable Long id,
            @RequestParam int xp,
            HttpSession session
    ) {

        if (xp <= 0) {
            return ResponseEntity.badRequest().body("XP deve ser maior que zero");
        }

        Aluno aluno = alunosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setXp(aluno.getXp() + xp);
        alunosRepository.save(aluno);

        // 🔥 ATUALIZA A SESSION
        if (id.equals(session.getAttribute("ALUNO_ID"))) {
            session.setAttribute("ALUNO_XP", aluno.getXp());
        }

        return ResponseEntity.ok(aluno.getXp());
    }


    // =====================================
    // PUT - ATUALIZAR COINS (VALOR FINAL)
    // =====================================
//    @PutMapping("/aluno/{id}/coins")
//    public ResponseEntity<?> atualizarCoins(
//            @PathVariable Long id,
//            @RequestParam int coins
//    ) {
//
//        if (coins < 0) {
//            return ResponseEntity.badRequest().body("Coins não podem ser negativas");
//        }
//
//        Aluno aluno = alunosRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
//
//        // Backend confia no valor final enviado pelo front
//        aluno.setCoins(coins);
//
//        alunosRepository.save(aluno);
//
//        return ResponseEntity.ok(aluno.getCoins());
//    }
    @PutMapping("/aluno/{id}/coins")
    public ResponseEntity<?> atualizarCoins(
            @PathVariable Long id,
            @RequestParam int coins,
            HttpSession session
    ) {

        if (coins < 0) {
            return ResponseEntity.badRequest().body("Coins não podem ser negativas");
        }

        Aluno aluno = alunosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setCoins(coins);
        alunosRepository.save(aluno);

        // 🔥 ATUALIZA A SESSION
        if (id.equals(session.getAttribute("ALUNO_ID"))) {
            session.setAttribute("ALUNO_COINS", aluno.getCoins());
        }

        return ResponseEntity.ok(aluno.getCoins());
    }

}
