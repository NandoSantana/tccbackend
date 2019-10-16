package br.com.tcc.api.resource;

import br.com.tcc.api.model.Grupo;
import br.com.tcc.api.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoService service;

    @GetMapping(value = "/listar")
    public List<Grupo> listar() {
        return service.buscarTodos();
    }

    @GetMapping(value = "/buscarPeloId/{id}")
    public Grupo buscarPeloId(@PathVariable Long id) {
        return service.buscarPeloId(id);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(service.buscarPeloId(id));
    }

    @PostMapping(value = "/inserir")
    public Grupo inserir(@Valid @RequestBody Grupo grupo) {
        return service.inserir(grupo);
    }

    @PutMapping(value = "/alterar")
    public Grupo alterar(@Valid @RequestBody Grupo grupo) {
        return service.alterar(grupo);
    }
}
