package br.com.alura.strch.dominio;


import br.com.alura.strch.dominio.enuns.StatusCliente;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_endereco", referencedColumnName = "id")
  private Endereco endereco;

  public Cliente() {
  }

  public Cliente(String nome, String cpf, String telefone, String email, String profissao, BigDecimal renda, StatusCliente status, Endereco endereco) {
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
