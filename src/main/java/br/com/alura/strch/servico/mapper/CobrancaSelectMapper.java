package br.com.alura.strch.servico.mapper;

import br.com.alura.strch.dominio.Cobranca;
import br.com.alura.strch.servico.DTO.SelectDTO;
import org.hibernate.sql.Select;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CobrancaSelectMapper extends EntityMepper<SelectDTO, Cobranca>{

   SelectDTO toDTO (Cobranca cobranca);

   @InheritInverseConfiguration
    Cobranca toEntity (SelectDTO select);
}
