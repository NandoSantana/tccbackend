package br.com.tcc.api.querys;

import br.com.tcc.api.model.Usuario;

import java.util.List;

public interface UsuarioQuery {

    List<Usuario> buscarUsuariosNomeDiferentesAlterando(Usuario usuario);
}
