package br.com.tcc.api.resource;

import br.com.tcc.api.model.Usuario;
import br.com.tcc.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/listar")
    public List<Usuario> listar() {
        return service.buscarTodos();
    }

    @GetMapping(value = "/buscarPeloId/{id}")
    public Usuario buscarPeloId(@PathVariable Long id) {
        return service.buscarPeloId(id);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(service.buscarPeloId(id));
    }

    @PostMapping(value = "/inserir")
    public Usuario inserir(@Valid @RequestBody Usuario usuario) {
        return service.inserir(usuario);
    }

    @PutMapping(value = "/alterar")
    public Usuario alterar(@Valid @RequestBody Usuario usuario) {
        return service.alterar(usuario);
    }
}
