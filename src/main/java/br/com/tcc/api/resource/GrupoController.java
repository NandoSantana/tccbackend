package br.com.tcc.api.resource;

import br.com.tcc.api.dto.GrupoDTO;
import br.com.tcc.api.dto.ListaGrupoDTO;
import br.com.tcc.api.excecoes.GrupoException;
import br.com.tcc.api.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoService service;

    @PostMapping(value = "/listar")
    public ResponseEntity<?> listar(@Valid @RequestBody ListaGrupoDTO grupo) {
        try {
            return ResponseEntity.status(OK).body(service.buscarTodos());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping(value = "/listarPorNome")
    public ResponseEntity<?> listarPorNome(@Valid @RequestBody ListaGrupoDTO grupo) {
        try {
            return ResponseEntity.status(OK).body(service.buscarPorNome(grupo));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(value = "/alterar/{id}")
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
        try {
            ListaGrupoDTO grupo = service.buscarPeloId(id);
            service.deletar(grupo);
            return ResponseEntity.status(OK).body(grupo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping(value = "/inserir")
    public ResponseEntity<?> inserir(@Valid @RequestBody ListaGrupoDTO grupo) {
        GrupoDTO grupoDto = service.inserir(grupo);
        return ResponseEntity.status(OK).body(grupoDto);
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<?> alterar(@Valid @RequestBody ListaGrupoDTO grupo) {
        GrupoDTO grupoDto = service.alterar(grupo);
        return ResponseEntity.status(OK).body(grupoDto);
    }
}
