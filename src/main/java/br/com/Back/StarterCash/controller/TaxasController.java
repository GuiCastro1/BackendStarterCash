package br.com.Back.StarterCash.controller;

import br.com.Back.StarterCash.model.Taxas;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://127.0.0.1:5501", allowCredentials = "true")
@RestController
@RequestMapping("/taxas")
public class TaxasController {

    @GetMapping
    public List<Map<String, Object>> listarTaxas() {

        List<Map<String, Object>> lista = new ArrayList<>();

        for (Taxas taxa : Taxas.values()) {
            Map<String, Object> item = new HashMap<>();
            item.put("codigo", taxa.name());
            item.put("nome", taxa.getNome());
            item.put("taxa", taxa.getTaxa());
            item.put("descricao", taxa.getDescricao());

            lista.add(item);
        }

        return lista;
    }
}
