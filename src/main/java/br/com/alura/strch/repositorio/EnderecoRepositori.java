package br.com.alura.strch.repositorio;

import br.com.alura.strch.dominio.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepositori extends JpaRepository <Endereco, Long>, JpaSpecificationExecutor<Endereco> {


}
