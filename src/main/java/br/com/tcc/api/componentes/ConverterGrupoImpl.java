package br.com.tcc.api.componentes;

import br.com.tcc.api.dto.ListaGrupoDTO;
import br.com.tcc.api.model.Grupo;
import org.springframework.stereotype.Component;

import static br.com.tcc.api.utils.DataUtils.formataData;

@Component
public class ConverterGrupoImpl implements ConverterGrupo {

    @Override
    public ListaGrupoDTO converteEntidadeDTO(Grupo grupo) {
        ListaGrupoDTO dto = new ListaGrupoDTO();
        dto.setNome(grupo.getNome());
        dto.setId(grupo.getId());
        dto.setDataCadastro(formataData(grupo.getDataCadastro()));
        return dto;
    }

    @Override
    public Grupo converteDTOEntidade(ListaGrupoDTO dto)  {
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
