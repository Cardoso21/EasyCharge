package br.com.alura.strch.servico.mapper;

import br.com.alura.strch.dominio.Endereco;
import br.com.alura.strch.servico.DTO.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface EnderecoSelectMapper extends EntityMepper<SelectDTO, Endereco>{

    SelectDTO toDTO (Endereco endereco);

    @InheritInverseConfiguration
    Endereco toEntity (SelectDTO select);
}
