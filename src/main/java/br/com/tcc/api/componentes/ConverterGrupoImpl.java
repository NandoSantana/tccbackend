package br.com.tcc.api.componentes;

import br.com.tcc.api.dto.GrupoDTO;
import br.com.tcc.api.model.Grupo;
import org.springframework.stereotype.Component;

import static br.com.tcc.api.utils.DataUtils.formataData;

@Component
public class ConverterGrupoImpl implements ConverterGrupo {

    @Override
    public GrupoDTO converteEntidadeDTO(Grupo grupo) {
        GrupoDTO dto = new GrupoDTO();
        dto.setNome(grupo.getNome());
        dto.setId(grupo.getId());
        dto.setDataCadastro(formataData(grupo.getDataCadastro()));
        return dto;
    }

    @Override
    public Grupo converteDTOEntidade(GrupoDTO dto)  {
        Grupo grupo = new Grupo();
        try {
            grupo.setNome(dto.getNome());
            grupo.setId(dto.getId());
            grupo.setDataCadastro(formataData(dto.getDataCadastro()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grupo;
    }
}
