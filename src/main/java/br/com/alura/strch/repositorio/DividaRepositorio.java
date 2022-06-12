package br.com.alura.strch.repositorio;

import br.com.alura.strch.dominio.Cliente;
import br.com.alura.strch.dominio.Divida;
import br.com.alura.strch.dominio.enuns.StatusDivida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DividaRepositorio extends JpaRepository <Divida, Long>, JpaSpecificationExecutor<Divida> {
    boolean existsById(long id);
    boolean existsByDataAbertura(LocalDate data);
    boolean existsByCliente(Cliente cliente);


    List <Divida> getAllByCliente(Cliente cliente);



}
