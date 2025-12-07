//package br.com.Back.StarterCash.controller;
//
//import br.com.Back.StarterCash.model.Aluno;
//import br.com.Back.StarterCash.repository.AlunoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/cadastro")
//public class CadastroController {
//    @Autowired
//    private AlunoRepository repository;
//
//    @GetMapping
//    public List<Aluno> listarAlunos() {
//        return repository.findAll();
//    }
//
//    @PostMapping
//    public void cadastrarAluno(@RequestBody Aluno aluno) {
//        repository.save(aluno);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public void deletarAluno(@PathVariable Long id){
//        repository.deleteById(id);
//    }
//
//
//
//}
package br.com.Back.StarterCash.controller;

import br.com.Back.StarterCash.model.Aluno;
import br.com.Back.StarterCash.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cadastro")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @GetMapping
    public List<Aluno> listarAlunos() {
        return cadastroService.listar();
    }

    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return cadastroService.cadastrar(aluno);
    }

    @DeleteMapping(value = "/{id}")
    public void deletarAluno(@PathVariable Long id){
        cadastroService.deletar(id);
    }
}
