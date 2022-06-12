package br.com.alura.strch.servico;

import br.com.alura.strch.dominio.Cliente;
import br.com.alura.strch.repositorio.ClienteRepositorio;
import br.com.alura.strch.servico.DTO.ClienteDTO;
import br.com.alura.strch.servico.DTO.SelectDTO;
import br.com.alura.strch.servico.excecao.ObjectnotFoundException;
import br.com.alura.strch.servico.filtro.ClienteFiltro;
import br.com.alura.strch.servico.mapper.ClienteMapper;
import br.com.alura.strch.servico.mapper.ClienteSelecMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ClienteServico implements Serializable {

    private final ClienteRepositorio clienteRepositorio;
    private final ClienteMapper clienteMapper;
    private final ClienteSelecMapper clienteSelecMapper;

    public ClienteDTO encontrarPorId(Long id){
        Cliente cliente = clienteRepositorio.findById(id).orElseThrow(ObjectnotFoundException::new);
        return clienteMapper.toDTO(cliente);
    }

    public List <ClienteDTO> buscarTodos(){
        return clienteMapper.toDTO(clienteRepositorio.findAll());
    }

    public List<SelectDTO> buscarTodosSelect(){
        return clienteSelecMapper.toDTO(clienteRepositorio.findAll());
    }

    public boolean validarCPF(ClienteDTO clienteDTO){
        if(!clienteRepositorio.existsByCpf(clienteDTO.getCpf())){
            return true;
        }
        throw new ObjectnotFoundException("CPF já existe no banco" +clienteDTO.getCpf());
    }
    public boolean validarEmail (ClienteDTO clienteDTO){
        if(!clienteRepositorio.existsByEmail(clienteDTO.getEmail())){
            return true;
        }
        throw new ObjectnotFoundException("Email já Cadastrado" + clienteDTO.getEmail());
    }

    public ClienteDTO salvar (ClienteDTO clienteDTO){
//        if(validarCPF(clienteDTO) && validarEmail(clienteDTO)){
            Cliente cliente = clienteMapper.toEntity(clienteDTO);
            Cliente clienteSalvar = clienteRepositorio.save(cliente);
            return clienteMapper.toDTO(clienteSalvar);
        }
//       throw new ObjectnotFoundException("" + clienteDTO.getCpf());
//    }

    public ClienteDTO editar (ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        Cliente clienteAtualizar = clienteRepositorio.save(cliente);
        return clienteMapper.toDTO(clienteAtualizar);
    }

    public List<ClienteDTO> buscarTodosFiltro(ClienteFiltro clienteFiltro) {
        return clienteMapper.toDTO(clienteRepositorio.findAll(clienteFiltro.filter()));
    }
    public void deletar(Long id){
       clienteRepositorio.deleteById(id);
    }



}
