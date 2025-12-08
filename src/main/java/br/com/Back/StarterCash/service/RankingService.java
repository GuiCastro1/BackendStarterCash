//package br.com.Back.StarterCash.service;
//
//public class RankingService {
//}
package br.com.Back.StarterCash.service;

import br.com.Back.StarterCash.dto.RankingDto;
import br.com.Back.StarterCash.model.Aluno;
import br.com.Back.StarterCash.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public RankingService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

//    @Transactional(readOnly = true)
//    public List<RankingDto> getRanking(Integer limit) {
//        // Ordena por "xp" decrescente. Ajuste o nome do campo se na entidade for diferente.
//        List<Aluno> alunos = alunoRepository.findAll(Sort.by(Sort.Direction.DESC, "xp"));
//
//        // Converte para DTO e aplica limit se fornecido
//        return alunos.stream()
//                .map(a -> new RankingDto(a.getNome(), a.getXp()))
//                .limit(limit == null || limit <= 0 ? Long.MAX_VALUE : limit)
//                .collect(Collectors.toList());
//    }


    @Transactional(readOnly = true)
    public List<RankingDto> getRanking(Integer limit) {
        List<Aluno> alunos = alunoRepository.findAll(Sort.by(Sort.Direction.DESC, "xp"));

        long lim = (limit != null && limit > 0) ? limit.longValue() : Long.MAX_VALUE;

//        return alunos.stream()
//                .map(a -> new RankingDto(a.getNome(), a.getXp()))
//                .limit(lim)
//                .collect(Collectors.toList());

        // RankingService.java (trecho)
        return alunos.stream()
                .map(RankingDto::new) // passa o Aluno inteiro para o construtor RankingDto(Aluno)
                .limit(lim)
                .collect(Collectors.toList());

    }
}
