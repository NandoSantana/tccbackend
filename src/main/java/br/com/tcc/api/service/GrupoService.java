package br.com.tcc.api.service;

import br.com.tcc.api.excecoes.GrupoException;
import br.com.tcc.api.model.Grupo;

import java.util.List;

public interface GrupoService {

    List<Grupo> buscarTodos();

    Grupo inserir (Grupo grupo) throws GrupoException;

    Grupo alterar (Grupo grupo) throws GrupoException;

    void deletar(Grupo grupo);

    Grupo buscarPeloId(Long id);
}
