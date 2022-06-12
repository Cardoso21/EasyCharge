package br.com.alura.strch.servico.mapper;

import br.com.alura.strch.dominio.Cliente;
import br.com.alura.strch.servico.DTO.ClienteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ClienteMapper extends EntityMepper<ClienteDTO, Cliente> {
}
