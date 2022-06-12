package br.com.alura.strch.repositorio;

import br.com.alura.strch.dominio.Cobranca;
import br.com.alura.strch.dominio.Divida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CobrancaRepositori extends JpaRepository <Cobranca, Long> {

    boolean existsById(long id);

    List<Cobranca> getAllByDivida(Divida divida);
}
