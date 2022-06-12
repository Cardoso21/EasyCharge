package br.com.alura.strch.servico;

import br.com.alura.strch.dominio.Cliente;
import br.com.alura.strch.dominio.Divida;
import br.com.alura.strch.repositorio.DividaRepositorio;
import br.com.alura.strch.servico.DTO.ClienteDTO;
import br.com.alura.strch.servico.DTO.DividaDTO;
import br.com.alura.strch.servico.DTO.SelectDTO;
import br.com.alura.strch.servico.excecao.ObjectnotFoundException;
import br.com.alura.strch.servico.filtro.ClienteFiltro;
import br.com.alura.strch.servico.filtro.DividaFiltro;
import br.com.alura.strch.servico.mapper.DividaMapper;
import br.com.alura.strch.servico.mapper.DividaSetcMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class DividaServico implements Serializable {

    private final DividaRepositorio dividaRepositorio;
    private final DividaMapper dividaMapper;
    private final DividaSetcMapper dividaSetcMapper;

    public DividaDTO encontrarPorId(Long id){
        Divida divida = dividaRepositorio.findById(id).orElseThrow(ObjectnotFoundException::new);
        return dividaMapper.toDTO(divida);
    }

    public List <DividaDTO> buscaTodos(){
        return dividaMapper.toDTO(dividaRepositorio.findAll());
    }
    public List<SelectDTO> BuscarTodosSelect(){
        return dividaSetcMapper.toDTO(dividaRepositorio.findAll());
    }

    public DividaDTO salvar(DividaDTO dividaDTO){
        Divida divida = dividaMapper.toEntity(dividaDTO);
        Divida dividaSalvar = dividaRepositorio.save(divida);
        return dividaMapper.toDTO(dividaSalvar);
    }

    public DividaDTO editar(DividaDTO dividaDTO){
        Divida divida = dividaMapper.toEntity(dividaDTO);
        Divida dividaAtualizar = dividaRepositorio.save(divida);
        return dividaMapper.toDTO(dividaAtualizar);
    }
    public List<DividaDTO> buscarTodosFiltro(DividaFiltro dividaFiltro) {
        return dividaMapper.toDTO(dividaRepositorio.findAll(dividaFiltro.filter()));
    }

    public void excluirDivida(long id){
        dividaRepositorio.deleteById(id);
    }

    public void analisarCliente(Cliente cliente){
        List <Divida> list = dividaRepositorio.getAllByCliente(cliente);
        List <Cliente> listCliente = new ArrayList<>();
        for(Divida e: list){
            listCliente = (List<Cliente>) e.getCliente();
            if (listCliente.toArray().length==1){
                dividaRepositorio.delete(e);
            }else {
                listCliente.remove(cliente);
                e.setCliente((Cliente) listCliente);
                dividaRepositorio.save(e);
            }
        }
    }


}
