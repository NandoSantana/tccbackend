package br.com.tcc.api.componentes;

import br.com.tcc.api.excecoes.UsuarioException;
import br.com.tcc.api.model.Usuario;

public interface UsuarioRegra {

    void validarSalvar(Usuario usuario) throws UsuarioException;
}
