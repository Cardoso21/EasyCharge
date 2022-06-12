package br.com.alura.strch.servico.DTO;

import br.com.alura.strch.dominio.Cliente;
import br.com.alura.strch.dominio.enuns.StatusDivida;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ListaDividaDTO {

    private Long id;
    private BigDecimal valor;
    private LocalDate dataAbertura;
    private LocalDate dataQuitacao;
    private String descricao;
    private Cliente cliente;
    private StatusDivida statusDivida;

    public ListaDividaDTO() {
    }

    public ListaDividaDTO(Long id, BigDecimal valor, LocalDate dataAbertura, LocalDate dataQuitacao, String descricao, Cliente cliente, StatusDivida statusDivida) {
        this.id = id;
        this.valor = valor;
        this.dataAbertura = dataAbertura;
        this.dataQuitacao = dataQuitacao;
        this.descricao = descricao;
        this.cliente = cliente;
        this.statusDivida = statusDivida;
    }
}
