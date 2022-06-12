package br.com.alura.strch.servico;

import br.com.alura.strch.dominio.Endereco;
import br.com.alura.strch.repositorio.EnderecoRepositori;
import br.com.alura.strch.servico.DTO.EnderecoDTO;
import br.com.alura.strch.servico.DTO.SelectDTO;
import br.com.alura.strch.servico.excecao.ObjectnotFoundException;
import br.com.alura.strch.servico.filtro.EnderecoFiltro;
import br.com.alura.strch.servico.mapper.EnderecoMapper;
import br.com.alura.strch.servico.mapper.EnderecoSelectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class EnderecoServico implements Serializable {

    private final EnderecoRepositori enderecoRepositori;
    private final EnderecoMapper enderecoMapper;
    private final EnderecoSelectMapper enderecoSelectMapper;

    public EnderecoDTO buscarPorId(Long id){
        Endereco endereco = enderecoRepositori.findById(id).orElseThrow(()-> new ObjectnotFoundException("Endereço não encontrado" + id));
        return enderecoMapper.toDTO(endereco);
    }
    public List<EnderecoDTO> busrcarTodos(){
        return enderecoMapper.toDTO(enderecoRepositori.findAll());
    }

    public List<SelectDTO> buscarPorSelect(){
        return enderecoSelectMapper.toDTO(enderecoRepositori.findAll());
    }

    public EnderecoDTO salvar (EnderecoDTO enderecoDTO){
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        Endereco enderecoSalvar = enderecoRepositori.save(endereco);
        return enderecoMapper.toDTO(enderecoSalvar);
    }
    public EnderecoDTO editar(EnderecoDTO enderecoDTO){
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        Endereco enderecoAtualizar = enderecoRepositori.save(endereco);
        return enderecoMapper.toDTO(enderecoAtualizar);
    }
    public void excluir(Long id){
        enderecoRepositori.deleteById(id);
    }
    public List <EnderecoDTO> buscarPorFiltro(EnderecoFiltro enderecoFiltro){
        return enderecoMapper.toDTO(enderecoRepositori.findAll(enderecoFiltro.filter()));
    }
}
