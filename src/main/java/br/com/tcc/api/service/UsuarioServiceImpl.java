package br.com.tcc.api.service;

import br.com.tcc.api.excecoes.UsuarioException;
import br.com.tcc.api.model.Grupo;
import br.com.tcc.api.model.Usuario;
import br.com.tcc.api.regras.UsuarioRegra;
import br.com.tcc.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private UsuarioRegra regra;

    public List<Usuario> buscarTodos(){
        return repository.findAll();
    }

    public Usuario inserir (Usuario usuario) throws UsuarioException {
        return salvar(usuario);
    }

    public Usuario alterar (Usuario usuario) throws UsuarioException {
        return salvar(usuario);
    }

    public void deletar(Usuario usuario){
        repository.delete(usuario);
    }

    public Usuario buscarPeloId(Long id){
        Optional<Usuario> byId = repository.findById(id);
        return byId.get();
    }

    private Usuario salvar(Usuario usuario) throws UsuarioException {
        regra.validarSalvar(usuario);
        return repository.save(usuario);
    }
}
