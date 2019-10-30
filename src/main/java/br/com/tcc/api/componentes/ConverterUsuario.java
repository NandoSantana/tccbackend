package br.com.tcc.api.componentes;

import br.com.tcc.api.dto.UsuarioDTO;
import br.com.tcc.api.model.Usuario;

public interface ConverterUsuario {

    UsuarioDTO converteEntidadeDTO(Usuario usuario);

    Usuario converteDTOEntidade(UsuarioDTO dto);
}
