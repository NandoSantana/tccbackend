package br.com.tcc.api.regras;

import br.com.tcc.api.excecoes.GrupoException;
import br.com.tcc.api.model.Grupo;

public interface GrupoRegra {

    void validarSalvar(Grupo grupo) throws GrupoException;
}
