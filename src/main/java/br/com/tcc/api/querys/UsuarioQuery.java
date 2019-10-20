package br.com.tcc.api.querys;

import br.com.tcc.api.model.Usuario;

public interface UsuarioQuery {

    Boolean buscarUsuariosNomeDiferentesAlterando(Usuario usuario);

    Boolean buscarUsuariosNomeSobreNomeDiferentesAlterando(Usuario usuario);
}
