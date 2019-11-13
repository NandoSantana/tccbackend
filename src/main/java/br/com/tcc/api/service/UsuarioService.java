package br.com.tcc.api.service;

import br.com.tcc.api.dto.ListaUsuarioDTO;
import br.com.tcc.api.dto.UsuarioDTO;

public interface UsuarioService {

    UsuarioDTO buscarTodos();

    UsuarioDTO inserir (ListaUsuarioDTO usuario) ;

    UsuarioDTO alterar (ListaUsuarioDTO usuario) ;

    UsuarioDTO deletar(ListaUsuarioDTO usuario);

    ListaUsuarioDTO buscarPeloId(Long id);
}
