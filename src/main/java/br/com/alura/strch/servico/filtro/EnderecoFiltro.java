package br.com.alura.strch.servico.filtro;

import br.com.alura.strch.dominio.Endereco;
import br.com.alura.strch.dominio.Endereco_;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EnderecoFiltro implements EntityFiltro<Endereco> {

    private Long id;
    private String estado;
    private String bairro;
    private String cidade;

    @Override
    public Specification<Endereco> filter(){
        return (root, query, criteriaBuilder) -> criteriaBuilder.and(getPredicates(root,query,criteriaBuilder).toArray(new Predicate[0]));
    }
    private List<Predicate> getPredicates(Root<Endereco>root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder){

        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Endereco_.ID)));

        if (id != null) {
            predicates.add(criteriaBuilder.equal(root.get(Endereco_.ID),id));
        }
        if(estado != null){
            predicates.add(criteriaBuilder.like(root.get(Endereco_.ESTADO),"%"+ estado + "%"));
        }
        if(bairro != null){
            predicates.add(criteriaBuilder.like(root.get(Endereco_.BAIRRO),"%" + bairro + "%"));
        }
        if(cidade != null){
            predicates.add(criteriaBuilder.like(root.get(Endereco_.CIDADE),"%"+ cidade+ "%"));
        }




        return predicates;
    }

}
