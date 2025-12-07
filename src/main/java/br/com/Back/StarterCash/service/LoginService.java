package br.com.Back.StarterCash.service;

import br.com.Back.StarterCash.model.Aluno;
import br.com.Back.StarterCash.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AlunoRepository repository;
    @Autowired
    private PasswordService passwordService;

    public Aluno logarAluno(String email, String senha) {
        if (email == null || email.isBlank() || senha == null || senha.isBlank()) {
            return null; // entrada inválida
        }

        Aluno aluno = repository.findByEmail(email);
        if (aluno == null) {
            return null; // não existe usuário com esse email
        }

        String hashArmazenado = aluno.getSenha(); // campo que armazena o hash
        if (passwordService.verify(senha, hashArmazenado)) {
            // sucesso: retornar aluno (mas controller deve garantir não enviar a senha ao cliente)
            return aluno;
        } else {
            return null; // senha inválida
        }
    }
}
