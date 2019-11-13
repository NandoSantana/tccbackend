package br.com.tcc.api.componentes;

import br.com.tcc.api.dto.ListaGrupoDTO;
import br.com.tcc.api.model.Grupo;

public interface ConverterGrupo {

    ListaGrupoDTO converteEntidadeDTO(Grupo grupo);

    Grupo converteDTOEntidade(ListaGrupoDTO dto);
}
