package br.com.alura.strch.servico.mapper;

import br.com.alura.strch.dominio.Divida;
import br.com.alura.strch.servico.DTO.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface DividaSetcMapper  extends EntityMepper<SelectDTO, Divida>{

    SelectDTO toDTO (Divida divida);

    @InheritInverseConfiguration
    Divida toEntity (SelectDTO select);
}
