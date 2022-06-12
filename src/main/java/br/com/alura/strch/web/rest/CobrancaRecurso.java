package br.com.alura.strch.web.rest;

import br.com.alura.strch.servico.CobrancaServico;
import br.com.alura.strch.servico.DTO.CobrancaDTO;
import br.com.alura.strch.servico.DTO.SelectDTO;
import br.com.alura.strch.servico.filtro.CobrancaFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/cobrancas")
public class CobrancaRecurso {

    private final CobrancaServico cobrancaServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity <CobrancaDTO> buscarPorId(@PathVariable Long id){
        CobrancaDTO ListaCobrancaDTO = cobrancaServico.encontrarPorId(id);
        return  ResponseEntity.ok(ListaCobrancaDTO);
    }

    @GetMapping
    public ResponseEntity <List<CobrancaDTO>> buscarTodos(){
        List<CobrancaDTO> cobrancaList = cobrancaServico.buscarTodos();
        return ResponseEntity.ok(cobrancaList);
    }
    @GetMapping(value = "/filtro")
    public ResponseEntity <List<CobrancaDTO>> encontrarPorFiltro(CobrancaFiltro cobrancaFiltro){
        return ResponseEntity.ok(cobrancaServico.buscarTodosFiltro(cobrancaFiltro));
    }

    @GetMapping(value = "/select")
    public ResponseEntity <List<SelectDTO>> buscarPorSelect(){
        List<SelectDTO> selectList = cobrancaServico.BuscarTodosSelec();
        return ResponseEntity.ok(selectList);
    }

    @PostMapping
    public ResponseEntity <CobrancaDTO> salvar(@RequestBody CobrancaDTO cobrancaDTO){
        return ResponseEntity.ok(cobrancaServico.salvar(cobrancaDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity <CobrancaDTO> atualizar(@RequestBody CobrancaDTO cobrancaDTO, Long id){
        cobrancaDTO.setId(id);
        cobrancaDTO = cobrancaServico.editar(cobrancaDTO);
        return ResponseEntity.ok(cobrancaDTO);
    }

}
