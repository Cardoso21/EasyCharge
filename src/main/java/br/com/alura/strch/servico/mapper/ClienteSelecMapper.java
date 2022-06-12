package br.com.alura.strch.servico.mapper;

import br.com.alura.strch.dominio.Cliente;
import br.com.alura.strch.servico.DTO.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ClienteSelecMapper extends EntityMepper<SelectDTO, Cliente>{

    SelectDTO toDTO (Cliente cliente);

    @InheritInverseConfiguration
    Cliente toEntity (SelectDTO select);
}
