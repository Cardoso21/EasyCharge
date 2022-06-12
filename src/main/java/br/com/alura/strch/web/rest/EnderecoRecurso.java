package br.com.alura.strch.web.rest;

import br.com.alura.strch.servico.DTO.EnderecoDTO;
import br.com.alura.strch.servico.DTO.SelectDTO;
import br.com.alura.strch.servico.EnderecoServico;
import br.com.alura.strch.servico.filtro.EnderecoFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/enderecos")
public class EnderecoRecurso {

    private final EnderecoServico enderecoServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity <EnderecoDTO> buscarPorId(@PathVariable Long id){
        EnderecoDTO enderecoDTO = enderecoServico.buscarPorId(id);
        return ResponseEntity.ok(enderecoDTO);
    }
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> buscarTodos(){
        List<EnderecoDTO> enderecoList = enderecoServico.busrcarTodos();
        return ResponseEntity.ok(enderecoList);
    }

    @GetMapping(value = "/select")
    public ResponseEntity <List <SelectDTO>> buscarPorSelect(){
        List<SelectDTO> selectList = enderecoServico.buscarPorSelect();
        return ResponseEntity.ok(selectList);
    }
    @PostMapping
    public ResponseEntity <EnderecoDTO> salvar (@RequestBody EnderecoDTO enderecoDTO){
       return ResponseEntity.ok(enderecoServico.salvar(enderecoDTO));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity <EnderecoDTO> editar(@RequestBody EnderecoDTO enderecoDTO, @PathVariable Long id){
        enderecoDTO.setId(id);
        enderecoDTO = enderecoServico.editar(enderecoDTO);
        return ResponseEntity.ok(enderecoDTO);
    }
    @GetMapping(value = "filtro")
    public ResponseEntity <List<EnderecoDTO>> buscarPorFiltro(EnderecoFiltro enderecoFiltro){
        return ResponseEntity.ok(enderecoServico.buscarPorFiltro(enderecoFiltro));
    }

}
