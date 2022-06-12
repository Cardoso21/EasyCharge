package br.com.alura.strch.servico.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ListaClienteDTO implements Serializable {


    private Long id;
    private String nome;
    private SelectDTO cargo;
    private boolean status;

    public ListaClienteDTO() {
    }

    public ListaClienteDTO(Long id, String nome, SelectDTO cargo, boolean status) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.status = status;
    }
}
