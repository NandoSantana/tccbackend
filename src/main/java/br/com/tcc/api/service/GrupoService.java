package br.com.tcc.api.service;

import br.com.tcc.api.dto.GrupoDTO;
import br.com.tcc.api.excecoes.GrupoException;

import java.util.List;

public interface GrupoService {

    List<GrupoDTO> buscarTodos();

    GrupoDTO inserir (GrupoDTO dto) throws GrupoException;

    GrupoDTO alterar (GrupoDTO dto) throws GrupoException;

    void deletar(GrupoDTO dto) throws Exception;

    GrupoDTO buscarPeloId(Long id);
}
