package br.com.tcc.api.componentes;

import br.com.tcc.api.dto.GrupoDTO;
import br.com.tcc.api.model.Grupo;

public interface ConverterGrupo {

    GrupoDTO converteEntidadeDTO(Grupo grupo);

    Grupo converteDTOEntidade(GrupoDTO dto);
}
