package br.com.tcc.api.componentes;

import br.com.tcc.api.dto.ListaUsuarioDTO;
import br.com.tcc.api.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.com.tcc.api.utils.DataUtils.formataData;
import static br.com.tcc.api.utils.DataUtils.formataDataHora;

@Component
public class ConverterUsuarioImpl implements ConverterUsuario{

    @Autowired
    private ConverterGrupo converter;

    @Override
    public ListaUsuarioDTO converteEntidadeDTO(Usuario usuario) {
        ListaUsuarioDTO dto = new ListaUsuarioDTO();
        dto.setDataAniversario(formataData(usuario.getDataAniversario()));
        dto.setGrupo(converter.converteEntidadeDTO(usuario.getGrupo()));
        dto.setNome(usuario.getNome());
        dto.setSobrenome(usuario.getSobrenome());
        dto.setDataCadastro(formataDataHora(usuario.getDataCadastro()));
        dto.setId(usuario.getId());
        return dto;
    }

    @Override
    public Usuario converteDTOEntidade(ListaUsuarioDTO dto) {
        Usuario usuario = new Usuario();
        try {
            usuario.setDataAniversario(formataData(dto.getDataAniversario()));
            usuario.setGrupo(converter.converteDTOEntidade(dto.getGrupo()));
            usuario.setNome(dto.getNome());
            usuario.setSobrenome(dto.getSobrenome());
            usuario.setDataCadastro(formataData(dto.getDataCadastro()));
            usuario.setId(dto.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
