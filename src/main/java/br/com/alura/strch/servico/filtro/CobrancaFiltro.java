package br.com.alura.strch.servico.filtro;

import br.com.alura.strch.dominio.Cobranca;
import br.com.alura.strch.dominio.Cobranca_;
import br.com.alura.strch.dominio.Divida;
import br.com.alura.strch.dominio.enuns.FormaDeCobraca;
import br.com.alura.strch.dominio.enuns.TipoDeAcordo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CobrancaFiltro implements EntityFiltro<Cobranca>{

    private LocalDate dataDaCobranca;
    private FormaDeCobraca formaDeCobraca;
    private String agente;
    private TipoDeAcordo tipoDeAcordo;
    private Divida divida;

    @Override
    public Specification<Cobranca> filter(){
        return (root, query, criteriaBuilder) -> criteriaBuilder.and(getPredicates(root,query,criteriaBuilder).toArray(new Predicate[0]));
    }
    private List<Predicate> getPredicates(Root<Cobranca>root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder){

        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Cobranca_.ID)));

        if(dataDaCobranca != null){
            predicates.add(criteriaBuilder.equal(root.get(Cobranca_.DATA_DA_COBRANCA),"%" + dataDaCobranca + "%"));
        }
        if(agente != null){
            predicates.add(criteriaBuilder.like(root.get(Cobranca_.AGENTE),"%" + agente + "%"));
        }
        if(formaDeCobraca != null){
            predicates.add(criteriaBuilder.like(root.get(Cobranca_.FORMA_DE_COBRACA),"%" + formaDeCobraca + "%"));
        }
        if(tipoDeAcordo != null){
            predicates.add(criteriaBuilder.like(root.get(Cobranca_.TIPO_DE_ACORDO),"%" + tipoDeAcordo + "%"));
        }
        if (divida != null){
            predicates.add(criteriaBuilder.like(root.get(Cobranca_.DIVIDA),"%" + divida + "%"));
        }

        return predicates;
    }
}
