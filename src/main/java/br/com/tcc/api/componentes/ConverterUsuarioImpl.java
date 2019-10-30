package br.com.tcc.api.componentes;

import br.com.tcc.api.dto.UsuarioDTO;
import br.com.tcc.api.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.com.tcc.api.utils.DataUtils.formataData;

@Component
public class ConverterUsuarioImpl implements ConverterUsuario{

    @Autowired
    private ConverterGrupo converter;

    @Override
    public UsuarioDTO converteEntidadeDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setDataAniversario(formataData(usuario.getDataAniversario()));
        dto.setGrupo(converter.converteEntidadeDTO(usuario.getGrupo()));
        dto.setNome(usuario.getNome());
        dto.setSobrenome(usuario.getSobrenome());
        dto.setDataCadastro(formataData(usuario.getDataCadastro()));
        dto.setId(usuario.getId());
        return dto;
    }

    @Override
    public Usuario converteDTOEntidade(UsuarioDTO dto) {
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