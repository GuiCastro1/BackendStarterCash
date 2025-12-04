package br.com.Back.StarterCash.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Passe")
public class Passe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomePlano;

    private Double valor;

    private boolean statusPago; // true = pago

    @Enumerated(EnumType.STRING)
    private TipoAcesso acesso; // BASICO / INTERMEDIARIO / PREMIUM

    private LocalDate dataCompra;

    private LocalDate dataExpiracao;
}
