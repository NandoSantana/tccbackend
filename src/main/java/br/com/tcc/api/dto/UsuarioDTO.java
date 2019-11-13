package br.com.tcc.api.dto;

import java.util.List;

public class UsuarioDTO extends PrincipalDTO {

    private List<ListaUsuarioDTO> lista;
    private ListaUsuarioDTO usuarioRetorno;

    public List<ListaUsuarioDTO> getLista() {
        return lista;
    }

    public void setLista(List<ListaUsuarioDTO> lista) {
        this.lista = lista;
    }

    public ListaUsuarioDTO getUsuarioRetorno() {
        return usuarioRetorno;
    }

    public void setUsuarioRetorno(ListaUsuarioDTO usuarioRetorno) {
        this.usuarioRetorno = usuarioRetorno;
    }
}
