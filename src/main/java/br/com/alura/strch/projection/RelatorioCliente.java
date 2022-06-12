package br.com.alura.strch.projection;

import java.math.BigDecimal;

public interface RelatorioCliente {

    String getNome();
    BigDecimal getTotalDivida();
    Integer getCobranca();
}
