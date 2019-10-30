package br.com.tcc.api.service;

import br.com.tcc.api.dto.UsuarioDTO;
import br.com.tcc.api.excecoes.UsuarioException;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> buscarTodos();

    UsuarioDTO inserir (UsuarioDTO usuario) throws UsuarioException;

    UsuarioDTO alterar (UsuarioDTO usuario) throws UsuarioException;

    void deletar(UsuarioDTO usuario);

    UsuarioDTO buscarPeloId(Long id);
}
