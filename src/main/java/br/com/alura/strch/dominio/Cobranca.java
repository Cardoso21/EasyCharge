package br.com.alura.strch.dominio;

import br.com.alura.strch.dominio.enuns.FormaDeCobraca;
import br.com.alura.strch.dominio.enuns.TipoDeAcordo;
import br.com.alura.strch.dominio.enuns.TipoDeAgente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cobrancas")
public class Cobranca implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataDaCobranca;

    @Enumerated(EnumType.STRING)
    private FormaDeCobraca formaDeCobraca;

    private String agente;

    @Enumerated(EnumType.STRING)
    private TipoDeAgente tipoDeAgente;

    private String comentarioAgente;

    private String descricaoDoAcordo;

    private TipoDeAcordo tipoDeAcordo;

    private LocalDate dataPromessaPagmento;

    private Integer numeroDeParcela;

    @Enumerated(EnumType.STRING)
    @ManyToOne(fetch = FetchType.LAZY)
    private Divida divida;

    public Cobranca() {
    }

    public Cobranca(LocalDate dataDaCobranca, FormaDeCobraca formaDeCobraca, String agente, TipoDeAgente tipoDeAgente, String comentarioAgente, String descricaoDoAcordo, TipoDeAcordo tipoDeAcordo, LocalDate dataPromessaPagmento, Integer numeroDeParcela, Divida divida) {
        this.dataDaCobranca = dataDaCobranca;
        this.formaDeCobraca = formaDeCobraca;
        this.agente = agente;
        this.tipoDeAgente = tipoDeAgente;
        this.comentarioAgente = comentarioAgente;
        this.descricaoDoAcordo = descricaoDoAcordo;
        this.tipoDeAcordo = tipoDeAcordo;
        this.dataPromessaPagmento = dataPromessaPagmento;
        this.numeroDeParcela = numeroDeParcela;
        this.divida = divida;
    }

}
