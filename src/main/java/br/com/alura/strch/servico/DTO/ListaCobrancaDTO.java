package br.com.alura.strch.servico.DTO;

import br.com.alura.strch.dominio.Divida;
import br.com.alura.strch.dominio.enuns.FormaDeCobraca;
import br.com.alura.strch.dominio.enuns.TipoDeAcordo;
import br.com.alura.strch.dominio.enuns.TipoDeAgente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ListaCobrancaDTO {

    private Long id;

    private LocalDate dataDaCobranca;

    private FormaDeCobraca formaDeCobraca;

    private String agente;

    private TipoDeAgente tipoDeAgente;

    private String comentarioAgente;

    private String descricaoDoAcordo;

    private TipoDeAcordo tipoDeAcordo;

    private LocalDate dataPromessaPagmento;

    private Integer numeroDeParcela;

    private Divida divida;

    public ListaCobrancaDTO() {
    }

    public ListaCobrancaDTO(Long id, LocalDate dataDaCobranca, FormaDeCobraca formaDeCobraca, String agente, TipoDeAgente tipoDeAgente, String comentarioAgente, String descricaoDoAcordo, TipoDeAcordo tipoDeAcordo, LocalDate dataPromessaPagmento, Integer numeroDeParcela, Divida divida) {
        this.id = id;
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
