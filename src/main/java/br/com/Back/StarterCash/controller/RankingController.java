//package br.com.Back.StarterCash.controller;
//
//public class RankingController {
//}
package br.com.Back.StarterCash.controller;

import br.com.Back.StarterCash.dto.RankingDto;
import br.com.Back.StarterCash.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    private final RankingService rankingService;

    @Autowired
    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    // GET /api/ranking?limit=10
    @GetMapping
    public ResponseEntity<List<RankingDto>> getRanking(@RequestParam(required = false) Integer limit) {
        List<RankingDto> ranking = rankingService.getRanking(limit);
        return ResponseEntity.ok(ranking);
    }
}
