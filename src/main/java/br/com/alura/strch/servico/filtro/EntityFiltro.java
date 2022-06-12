package br.com.alura.strch.servico.filtro;

import org.springframework.data.jpa.domain.Specification;

public interface EntityFiltro <T>{

    Specification<T> filter();
}
