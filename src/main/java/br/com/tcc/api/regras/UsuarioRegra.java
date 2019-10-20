package br.com.tcc.api.regras;

import br.com.tcc.api.excecoes.UsuarioException;
import br.com.tcc.api.model.Usuario;

public interface UsuarioRegra {

    void validarSalvar(Usuario usuario) throws UsuarioException;
}
