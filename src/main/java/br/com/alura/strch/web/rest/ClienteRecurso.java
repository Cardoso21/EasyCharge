package br.com.alura.strch.web.rest;

import br.com.alura.strch.servico.ClienteServico;
import br.com.alura.strch.servico.DTO.ClienteDTO;
import br.com.alura.strch.servico.DTO.SelectDTO;
import br.com.alura.strch.servico.filtro.ClienteFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/clientes")
public class ClienteRecurso {

    private final ClienteServico clienteServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity <ClienteDTO> buscarPorId(@PathVariable long id){
        ClienteDTO clienteDTO = clienteServico.encontrarPorId(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping
    public ResponseEntity <List <ClienteDTO>> buscarTodos(){
        List<ClienteDTO> clienteList = clienteServico.buscarTodos();
        return ResponseEntity.ok(clienteList);
    }

    @GetMapping(value = "/select")
    public ResponseEntity <List <SelectDTO>> buscarPorSelect(){
        List<SelectDTO> selectList = clienteServico.buscarTodosSelect();
        return ResponseEntity.ok(selectList);
    }

    @PostMapping
    public ResponseEntity <ClienteDTO> salvar(@RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(clienteServico.salvar(clienteDTO));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity <ClienteDTO> editar(@RequestBody ClienteDTO clienteDTO,@PathVariable Long id){
        clienteDTO.setId(id);
        clienteDTO = clienteServico.editar(clienteDTO);
        return ResponseEntity.ok(clienteDTO);
    }

    @GetMapping(value = "filtro")
    public ResponseEntity <List <ClienteDTO>> encontrarPorFiltro(ClienteFiltro clienteFiltro){
        return ResponseEntity.ok(clienteServico.buscarTodosFiltro(clienteFiltro));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> deletar(@PathVariable Long id){
        clienteServico.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
