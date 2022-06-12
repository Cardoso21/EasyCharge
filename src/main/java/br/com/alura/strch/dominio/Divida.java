package br.com.alura.strch.dominio;

import br.com.alura.strch.dominio.enuns.StatusDivida;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "dividas")
public class Divida implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataQuitacao;
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private StatusDivida statusDivida;

    @OneToMany(mappedBy = "divida", cascade = CascadeType.ALL)
    private final List<Cobranca> cobrancas = new ArrayList<>();


    public Divida() {
    }

    public Divida(Long id, BigDecimal valor, LocalDate dataAbertura, LocalDate dataQuitacao, String descricao, Cliente cliente, StatusDivida statusDivida) {
        this.id = id;
        this.valor = valor;
        this.dataAbertura = dataAbertura;
        this.dataQuitacao = dataQuitacao;
        this.descricao = descricao;
        this.cliente = cliente;
        this.statusDivida = statusDivida;
    }
}
