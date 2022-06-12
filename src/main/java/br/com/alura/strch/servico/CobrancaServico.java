package br.com.alura.strch.servico;

import br.com.alura.strch.dominio.Cobranca;
import br.com.alura.strch.dominio.Divida;
import br.com.alura.strch.repositorio.CobrancaRepositori;
import br.com.alura.strch.servico.DTO.CobrancaDTO;
import br.com.alura.strch.servico.DTO.DividaDTO;
import br.com.alura.strch.servico.DTO.SelectDTO;
import br.com.alura.strch.servico.excecao.ObjectnotFoundException;
import br.com.alura.strch.servico.filtro.CobrancaFiltro;
import br.com.alura.strch.servico.filtro.DividaFiltro;
import br.com.alura.strch.servico.mapper.CobrancaMapper;
import br.com.alura.strch.servico.mapper.CobrancaSelectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.ArrayUtils.toArray;

@RequiredArgsConstructor
@Transactional
@Service
public class CobrancaServico implements Serializable {

    private final CobrancaMapper cobrancaMapper;
    private final CobrancaRepositori cobrancaRepositori;
    private final CobrancaSelectMapper cobrancaSelectMapper;

    public CobrancaDTO encontrarPorId(Long id){
        Cobranca cobranca = cobrancaRepositori.findById(id).orElseThrow(ObjectnotFoundException ::new);
        return cobrancaMapper.toDTO(cobranca);
    }

    public List<CobrancaDTO> buscarTodos(){
        return cobrancaMapper.toDTO(cobrancaRepositori.findAll());
    }
    public List<SelectDTO> BuscarTodosSelec(){
        return cobrancaSelectMapper.toDTO(cobrancaRepositori.findAll());
    }

    public CobrancaDTO salvar(CobrancaDTO cobrancaDTO){
        Cobranca cobranca = cobrancaMapper.toEntity(cobrancaDTO);
        Cobranca cobrancaSalvar = cobrancaRepositori.save(cobranca);
        return cobrancaMapper.toDTO(cobrancaSalvar);
    }

    public CobrancaDTO editar(CobrancaDTO cobrancaDTO){
        Cobranca cobranca = cobrancaMapper.toEntity(cobrancaDTO);
        Cobranca cobrancaAtualizar = cobrancaRepositori.save(cobranca);
        return cobrancaMapper.toDTO(cobrancaAtualizar);
    }
    public List<CobrancaDTO> buscarTodosFiltro(CobrancaFiltro cobrancaFiltro) {
        return cobrancaMapper.toDTO(cobrancaRepositori.findAll((Sort) cobrancaFiltro.filter()));
    }

    public void excluirCobranca(Long id){
        cobrancaRepositori.deleteById(id);
    }

    public void analiserDivida(Divida divida) {
        List<Cobranca> list = cobrancaRepositori.getAllByDivida(divida);
        List<Divida> listDivida = new ArrayList<>();
        for (Cobranca e : list) {
            listDivida = (List<Divida>) e.getDivida();
            if (listDivida.toArray().length == 1) {
                cobrancaRepositori.delete(e);
            } else {
                listDivida.remove(divida);
                e.setDivida((Divida) listDivida);
                cobrancaRepositori.save(e);
            }
        }
    }
}
