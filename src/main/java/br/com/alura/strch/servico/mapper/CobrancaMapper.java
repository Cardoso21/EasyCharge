package br.com.alura.strch.servico.mapper;

import br.com.alura.strch.dominio.Cobranca;
import br.com.alura.strch.servico.DTO.CobrancaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CobrancaMapper extends EntityMepper<CobrancaDTO, Cobranca>{
}
