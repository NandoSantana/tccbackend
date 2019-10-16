package br.com.tcc.api.service;

import br.com.tcc.api.model.Grupo;
import br.com.tcc.api.model.Usuario;
import br.com.tcc.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> buscarTodos(){
        return repository.findAll();
    }

    public Usuario inserir (Usuario usuario){
        return salvar(usuario);
    }

    public Usuario alterar (Usuario usuario){
        return salvar(usuario);
    }

    public void deletar(Usuario usuario){
        repository.delete(usuario);
    }

    public Usuario buscarPeloId(Long id){
        Optional<Usuario> byId = repository.findById(id);
        return byId.get();
    }

    private Usuario salvar(Usuario usuario){
        return repository.save(usuario);
    }
}
