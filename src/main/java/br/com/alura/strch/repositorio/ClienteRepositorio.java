package br.com.alura.strch.repositorio;

import br.com.alura.strch.dominio.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsByEndereco(String endereco);


}
