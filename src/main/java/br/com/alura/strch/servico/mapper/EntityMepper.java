package br.com.alura.strch.servico.mapper;

import java.util.List;

public interface EntityMepper <D,E>{

    E toEntity (D dto);

    D toDTO (E emtity);

    List <E> toEntity (List <D> DTOList);

    List <D> toDTO (List <E> entityList);

}
