package br.com.tcc.api.service;

import br.com.tcc.api.dto.ListaUsuarioDTO;
import br.com.tcc.api.excecoes.UsuarioException;

import java.util.List;

public interface UsuarioService {

    List<ListaUsuarioDTO> buscarTodos();

    ListaUsuarioDTO inserir (ListaUsuarioDTO usuario) throws UsuarioException;

    ListaUsuarioDTO alterar (ListaUsuarioDTO usuario) throws UsuarioException;

    void deletar(ListaUsuarioDTO usuario);

    ListaUsuarioDTO buscarPeloId(Long id);
}
