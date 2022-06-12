package br.com.alura.strch.web.rest;

import br.com.alura.strch.servico.DTO.DividaDTO;
import br.com.alura.strch.servico.DTO.ListaDividaDTO;
import br.com.alura.strch.servico.DTO.SelectDTO;
import br.com.alura.strch.servico.DividaServico;
import br.com.alura.strch.servico.filtro.DividaFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/dividas")
public class DividaRecurso {

    private final DividaServico dividaServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity <DividaDTO> buscarPorId(@PathVariable Long id){
        DividaDTO listaDividaDTO = dividaServico.encontrarPorId(id);
        return ResponseEntity.ok(listaDividaDTO);
    }

    @GetMapping
    public ResponseEntity <List<DividaDTO>> buscarTodos(){
        List<DividaDTO> dividaList = dividaServico.buscaTodos();
        return ResponseEntity.ok(dividaList);
    }

    @GetMapping(value = "/select")
    public ResponseEntity <List<SelectDTO>> BuscarPorSelect(){
        List<SelectDTO> selectList = dividaServico.BuscarTodosSelect();
        return ResponseEntity.ok(selectList);
    }

    @PostMapping
    public ResponseEntity <DividaDTO> salvar(@RequestBody DividaDTO dividaDTO){
        return ResponseEntity.ok(dividaServico.salvar(dividaDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity <DividaDTO> atualizar(@RequestBody DividaDTO dividaDTO, @PathVariable Long id){
        dividaDTO.setId(id);
        dividaDTO= dividaServico.editar(dividaDTO);
        return ResponseEntity.ok(dividaDTO);
    }
    @GetMapping(value = "filtro")
    public ResponseEntity <List<DividaDTO>> encontrarPorFiltro(DividaFiltro dividaFiltro){
        return ResponseEntity.ok(dividaServico.buscarTodosFiltro(dividaFiltro));
    }
}
