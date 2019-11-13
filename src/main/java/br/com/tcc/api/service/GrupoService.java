package br.com.tcc.api.service;

import br.com.tcc.api.dto.GrupoDTO;
import br.com.tcc.api.dto.ListaGrupoDTO;

public interface GrupoService {

    GrupoDTO buscarTodos();

    GrupoDTO buscarPorNome(ListaGrupoDTO grupo);

    GrupoDTO inserir (ListaGrupoDTO dto) ;

    GrupoDTO alterar (ListaGrupoDTO dto) ;

    void deletar(ListaGrupoDTO dto) throws Exception;

    ListaGrupoDTO buscarPeloId(Long id);
}
