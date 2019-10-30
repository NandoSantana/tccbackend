package br.com.tcc.api.resource;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

import br.com.tcc.api.dto.UsuarioDTO;
import br.com.tcc.api.excecoes.UsuarioException;
import br.com.tcc.api.model.Usuario;
import br.com.tcc.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/listar")
    public ResponseEntity<?> listar() {
        try {
            return ResponseEntity.status(OK).body(service.buscarTodos());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(value = "/buscarPeloId/{id}")
    public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(OK).body(service.buscarPeloId(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            UsuarioDTO usuario = service.buscarPeloId(id);
            service.deletar(usuario);
            return ResponseEntity.status(OK).body(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping(value = "/inserir")
    public ResponseEntity<?> inserir(@Valid @RequestBody UsuarioDTO usuario) {
        try {
            usuario = service.inserir(usuario);
            return ResponseEntity.status(OK).body(usuario);
        } catch (UsuarioException e) {
            e.printStackTrace();
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<?> alterar(@Valid @RequestBody UsuarioDTO usuario) {
        try {
            usuario = service.alterar(usuario);
            return ResponseEntity.status(OK).body(usuario);
        } catch (UsuarioException e) {
            e.printStackTrace();
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        }
    }
}
