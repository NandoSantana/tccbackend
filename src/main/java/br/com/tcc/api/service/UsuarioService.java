package br.com.tcc.api.service;

import br.com.tcc.api.excecoes.UsuarioException;
import br.com.tcc.api.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> buscarTodos();

    Usuario inserir (Usuario usuario) throws UsuarioException;

    Usuario alterar (Usuario usuario) throws UsuarioException;

    void deletar(Usuario usuario);

    Usuario buscarPeloId(Long id);
}
