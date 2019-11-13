package br.com.tcc.api.querys;

import br.com.tcc.api.model.Grupo;

import java.util.List;

public interface GrupoQuery {

    Boolean buscarGruposNomeDiferentesAlterando(Grupo grupo);

    List<Grupo> buscarGruposPorNome(Grupo grupo);
}
