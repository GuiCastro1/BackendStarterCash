package br.com.Back.StarterCash.service;

import br.com.Back.StarterCash.model.Aluno;
import br.com.Back.StarterCash.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private PasswordService passwordService;

    public List<Aluno> listar() {
        return repository.findAll();
    }

    public Aluno cadastrar(Aluno aluno) {
        // pegar senha em claro e substituir por hash antes de salvar
        String plain = aluno.getSenha();
        if (plain != null && !plain.isBlank()) {
            String hashed = passwordService.hash(plain);
            aluno.setSenha(hashed);
        }
        return repository.save(aluno);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
