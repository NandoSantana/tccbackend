package br.com.tcc.api.resource;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

import br.com.tcc.api.dto.ListaUsuarioDTO;
import br.com.tcc.api.dto.UsuarioDTO;
import br.com.tcc.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping(value = "/listar")
    public ResponseEntity<?> listar(@Valid @RequestBody ListaUsuarioDTO usuario) {
        UsuarioDTO usuarioDdto = service.buscarTodos();
        return ResponseEntity.status(
                usuarioDdto.getTipoMensagem().getTipo().equals("error") ? BAD_REQUEST :
                        OK).body(usuarioDdto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> buscarPeloId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(OK).body(service.buscarPeloId(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        ListaUsuarioDTO usuario = service.buscarPeloId(id);
        UsuarioDTO usuarioDto = service.deletar(usuario);
        return ResponseEntity.status(
                usuarioDto.getTipoMensagem().getTipo().equals("error") ? BAD_REQUEST :
                        OK).body(usuarioDto);
    }

    @PostMapping(value = "/inserir")
    public ResponseEntity<?> inserir(@Valid @RequestBody ListaUsuarioDTO usuario) {
        UsuarioDTO usuarioDto = service.inserir(usuario);
        return ResponseEntity.status(
                usuarioDto.getTipoMensagem().getTipo().equals("error") ? BAD_REQUEST :
                        OK).body(usuarioDto);
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<?> alterar(@Valid @RequestBody ListaUsuarioDTO usuario) {
        UsuarioDTO usuarioDto = service.alterar(usuario);
        return ResponseEntity.status(
                usuarioDto.getTipoMensagem().getTipo().equals("error") ? BAD_REQUEST :
                        OK).body(usuarioDto);
    }
}
