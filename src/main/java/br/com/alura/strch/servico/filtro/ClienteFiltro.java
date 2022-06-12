package br.com.alura.strch.servico.filtro;

import br.com.alura.strch.dominio.Cliente;
import br.com.alura.strch.dominio.Cliente_;

import br.com.alura.strch.dominio.enuns.StatusCliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class ClienteFiltro implements  EntityFiltro<Cliente>{

    private long id;
    private String nome;
    private StatusCliente statusCliente;
    private String cpf;
    private BigDecimal renda;

    @Override
    public Specification<Cliente> filter(){
        return (root, query, criteriaBuilder) -> criteriaBuilder.and(getPredicates(root,query,criteriaBuilder).toArray(new Predicate[0]));
    }
    private List<Predicate> getPredicates(Root<Cliente> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder){

        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Cliente_.ID)));

        if (nome != null){
            predicates.add(criteriaBuilder.like(root.get(Cliente_.NOME),"%" + nome + "%"));
        }
        if(cpf != null){
            predicates.add(criteriaBuilder.like(root.get(Cliente_.CPF),"%" + cpf + "%"));
        }
        if (statusCliente != null){
            predicates.add(criteriaBuilder.like(root.get(Cliente_.STATUS),"%" + statusCliente + "%"));
        }
        if (renda != null){
            predicates.add(criteriaBuilder.like(root.get(Cliente_.RENDA),"%"+ renda + "%"));
        }

        return predicates;
    }
}
