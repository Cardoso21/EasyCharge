package br.com.alura.strch.servico.DTO;


import br.com.alura.strch.dominio.Endereco;
import br.com.alura.strch.dominio.enuns.StatusCliente;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ClienteDTO implements Serializable {



    private Long id;

    @CsvBindByName
    private String nome;

    @CsvBindByName
    private String cpf;

    @CsvBindByName
    private String telefone;

    @CsvBindByName
    private String email;

    @CsvBindByName
    private String profissao;

    @CsvBindByName
    private BigDecimal renda;

    @Enumerated(EnumType.STRING)
    @CsvBindByName
    private StatusCliente status;

    private Endereco endereco;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, String cpf, String telefone, String email, String profissao, BigDecimal renda, StatusCliente status, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.profissao = profissao;
        this.renda = renda;
        this.status = status;
        this.endereco = endereco;
    }
}

