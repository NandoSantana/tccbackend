package br.com.tcc.api.resource;

import br.com.tcc.api.dto.GrupoDTO;
import br.com.tcc.api.dto.ListaGrupoDTO;
import br.com.tcc.api.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoService service;

    @GetMapping(value = "/todos")
    public ResponseEntity<?> todos() {
        GrupoDTO grupoDto = service.buscarTodos();
        return ResponseEntity.status(
                grupoDto.getTipoMensagem().getTipo().equals("error") ? BAD_REQUEST :
                        OK).body(grupoDto);
    }

    @PostMapping(value = "/listar")
    public ResponseEntity<?> listar(@Valid @RequestBody ListaGrupoDTO grupo) {
        GrupoDTO grupoDto = service.buscarTodos();
        return ResponseEntity.status(
                grupoDto.getTipoMensagem().getTipo().equals("error") ? BAD_REQUEST :
                        OK).body(grupoDto);
    }

    @PostMapping(value = "/listarPorNome")
    public ResponseEntity<?> listarPorNome(@Valid @RequestBody ListaGrupoDTO grupo) {
        GrupoDTO grupoDto = service.buscarPorNome(grupo);
        return ResponseEntity.status(
                grupoDto.getTipoMensagem().getTipo().equals("error") ? BAD_REQUEST :
                        OK).body(grupoDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id) {
        try {
            return ResponseEntity.status(OK).body(service.buscarPeloId(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        ListaGrupoDTO grupo = service.buscarPeloId(id);
        GrupoDTO deletar = service.deletar(grupo);
        return ResponseEntity.status(
                deletar.getTipoMensagem().getTipo().equals("error") ? BAD_REQUEST :
                        OK).body(deletar);
    }

    @PostMapping(value = "/inserir")
    public ResponseEntity<?> inserir(@Valid @RequestBody ListaGrupoDTO grupo) {
        GrupoDTO grupoDto = service.inserir(grupo);
        return ResponseEntity.status(
                grupoDto.getTipoMensagem().getTipo().equals("error") ? BAD_REQUEST :
                        OK).body(grupoDto);
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<?> alterar(@Valid @RequestBody ListaGrupoDTO grupo) {
        GrupoDTO grupoDto = service.alterar(grupo);
        return ResponseEntity.status(
                grupoDto.getTipoMensagem().getTipo().equals("error") ? BAD_REQUEST :
                        OK).body(grupoDto);
    }
}
