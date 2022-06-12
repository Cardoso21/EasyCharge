package br.com.alura.strch.servico.filtro;

import br.com.alura.strch.dominio.*;
import br.com.alura.strch.dominio.enuns.StatusDivida;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DividaFiltro implements EntityFiltro<Divida>{

    private Long id;
    private BigDecimal valor;
    private LocalDate dataAbertura;
    private LocalDate dataQuitacao;
    private Cliente cliente;
    private StatusDivida statusDivida;



    @Override
    public Specification<Divida> filter(){
        return (root, query, criteriaBuilder) -> criteriaBuilder.and(getPredicates(root,query,criteriaBuilder).toArray(new Predicate[0]));
    }
    private List<Predicate> getPredicates(Root<Divida> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Divida_.ID)));

        if (id != null) {
            predicates.add(criteriaBuilder.equal(root.get(Divida_.ID),id));
        }
        if (valor != null){
            predicates.add(criteriaBuilder.like(root.get(Divida_.VALOR),"%" + valor +"%"));
        }
        if (dataAbertura != null){
            predicates.add(criteriaBuilder.equal(root.get(Divida_.DATA_ABERTURA),"%" + dataAbertura + "%"));
        }
        if (dataQuitacao != null){
            predicates.add(criteriaBuilder.equal(root.get(Divida_.DATA_QUITACAO),"%" + dataQuitacao + "%"));
        }
        if (cliente != null){
            predicates.add(criteriaBuilder.like(root.get(Divida_.CLIENTE),"%" + cliente + "%"));
        }
//        if (statusDivida != null){
//            predicates.add(criteriaBuilder.(Divida_.STATUS_DIVIDA),"%" + statusDivida + "%");
//        }


        return predicates;
    }

}
