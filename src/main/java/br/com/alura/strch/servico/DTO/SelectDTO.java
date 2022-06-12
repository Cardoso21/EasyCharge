package br.com.alura.strch.servico.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SelectDTO implements Serializable {


    private Long value;
    private String label;
}
