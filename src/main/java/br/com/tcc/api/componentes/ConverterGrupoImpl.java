package br.com.tcc.api.componentes;

import br.com.tcc.api.dto.ListaGrupoDTO;
import br.com.tcc.api.model.Grupo;
import br.com.tcc.api.repository.GrupoRepository;
import br.com.tcc.api.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

import static br.com.tcc.api.utils.DataUtils.formataData;
import static br.com.tcc.api.utils.DataUtils.formataDataHora;

@Component
public class ConverterGrupoImpl implements ConverterGrupo {

    @Autowired
    private GrupoRepository repository;

    @Override
    public ListaGrupoDTO converteEntidadeDTO(Grupo grupo) {
        ListaGrupoDTO dto = new ListaGrupoDTO();
        dto.setNome(grupo.getNome());
        dto.setId(grupo.getId());
        dto.setDataCadastro(formataDataHora(grupo.getDataCadastro()));
        return dto;
    }

    @Override
    public Grupo converteDTOEntidade(ListaGrupoDTO dto)  {
        Grupo grupo = new Grupo();
        try {
            grupo.setNome(dto.getNome());
            grupo.setId(dto.getId());
            if(dto.getId() == null){
                grupo.setDataCadastro(new Date());
            } else {
                Optional<Grupo> g = repository.findById(dto.getId());
                grupo.setDataCadastro(g.get().getDataCadastro());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grupo;
    }
}
