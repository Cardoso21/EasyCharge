package br.com.alura.strch.servico.DTO;

import br.com.alura.strch.dominio.Cliente;
import br.com.alura.strch.dominio.enuns.StatusDivida;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class DividaDTO implements Serializable{


        private Long id;
        private BigDecimal valor;
        private LocalDate dataAbertura = LocalDate.now();
        private LocalDate dataQuitacao;
        private String descricao;

        @ManyToOne(fetch = FetchType.LAZY)
        private Cliente cliente;

        @Enumerated(EnumType.STRING)
        private StatusDivida statusDivida;

    public DividaDTO() {
    }
    public DividaDTO(BigDecimal valor, LocalDate dataAbertura, LocalDate dataQuitacao, String descricao, Cliente cliente, StatusDivida statusDivida) {
        this.valor = valor;
        this.dataAbertura = dataAbertura;
        this.dataQuitacao = dataQuitacao;
        this.descricao = descricao;
        this.cliente = cliente;
        this.statusDivida = statusDivida;
    }

}
