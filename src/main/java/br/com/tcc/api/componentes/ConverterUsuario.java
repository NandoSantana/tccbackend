package br.com.tcc.api.componentes;

import br.com.tcc.api.dto.ListaUsuarioDTO;
import br.com.tcc.api.model.Usuario;

public interface ConverterUsuario {

    ListaUsuarioDTO converteEntidadeDTO(Usuario usuario);

    Usuario converteDTOEntidade(ListaUsuarioDTO dto);
}
