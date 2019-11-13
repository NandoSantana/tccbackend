package br.com.tcc.api.service;

import br.com.tcc.api.dto.GrupoDTO;
import br.com.tcc.api.dto.ListaGrupoDTO;
import br.com.tcc.api.excecoes.GrupoException;

public interface GrupoService {

    GrupoDTO buscarTodos(ListaGrupoDTO grupo);

    GrupoDTO inserir (ListaGrupoDTO dto) ;

    GrupoDTO alterar (ListaGrupoDTO dto) ;

    void deletar(ListaGrupoDTO dto) throws Exception;

    ListaGrupoDTO buscarPeloId(Long id);
}
