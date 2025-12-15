package br.com.Back.StarterCash.controller;

import br.com.Back.StarterCash.model.Aluno;
import br.com.Back.StarterCash.model.Simulacao;
import br.com.Back.StarterCash.model.Taxas;
import br.com.Back.StarterCash.repository.AlunoRepository;
import br.com.Back.StarterCash.repository.SimulacaoRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin(origins = "http://127.0.0.1:5501", allowCredentials = "true")
@RestController
@RequestMapping("/simulacoes")
public class SimulacaoController {

    private final AlunoRepository alunoRepository;
    private final SimulacaoRepository simulacaoRepository;

    public SimulacaoController(AlunoRepository alunoRepository,
                               SimulacaoRepository simulacaoRepository) {
        this.alunoRepository = alunoRepository;
        this.simulacaoRepository = simulacaoRepository;
    }

    @PostMapping
    public Map<String, Object> criarSimulacao(
            @RequestParam Long alunoId,
            @RequestParam String tipoInvestimento,
            @RequestParam double valorInvestido,
            @RequestParam int dias
    ) {

        Map<String, Object> response = new HashMap<>();

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        // ===============================
        // 1️⃣ Validação de coins
        // ===============================
        if (aluno.getCoins() < valorInvestido) {
            response.put("erro", "Coins insuficientes");
            return response;
        }

        // ===============================
        // 2️⃣ Taxa do investimento
        // ===============================
        Taxas taxa = Taxas.valueOf(tipoInvestimento);

        // ===============================
        // 3️⃣ Cálculo de datas
        // ===============================
        LocalDateTime dataInicio = LocalDateTime.now();
        LocalDateTime dataResgate = dataInicio.plusDays(dias);

        // ===============================
        // 4️⃣ Cálculo de rendimento simples
        // ===============================
        double rendimento = valorInvestido * taxa.getTaxa() * dias;
        double valorFinal = valorInvestido + rendimento;

        // ===============================
        // 5️⃣ XP (gamificação)
        // ===============================
        int xpGanho = (int) (valorInvestido * taxa.getTaxa() * 10);

        // ===============================
        // 6️⃣ Atualiza aluno
        // ===============================
        aluno.setCoins(aluno.getCoins() - (int) valorInvestido);
        aluno.setXp(aluno.getXp() + xpGanho);
        alunoRepository.save(aluno);

        // ===============================
        // 7️⃣ Registra simulação
        // ===============================
        Simulacao simulacao = new Simulacao();
        simulacao.setAluno(aluno);
        simulacao.setTipoInvestimento(taxa.name());
        simulacao.setTaxaAplicada(taxa.getTaxa());
        simulacao.setValorInvestido(valorInvestido);
        simulacao.setValorAtual(valorFinal);
        simulacao.setDataInicio(dataInicio);
        simulacao.setUltimaAtualizacao(dataResgate);
        simulacao.setAtivo(true);

        simulacaoRepository.save(simulacao);

        // ===============================
        // 8️⃣ Response
        // ===============================
        response.put("investimento", taxa.getNome());
        response.put("valorInvestido", valorInvestido);
        response.put("valorFinal", valorFinal);
        response.put("xpGanho", xpGanho);
        response.put("dataResgate", dataResgate);
        response.put("coinsRestantes", aluno.getCoins());

        return response;
    }
}
