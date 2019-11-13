package br.com.tcc.api.dto;

import java.util.List;

public class GrupoDTO extends PrincipalDTO {

    private List<ListaGrupoDTO> lista;
    private ListaGrupoDTO grupoRetorno;

    public List<ListaGrupoDTO> getLista() {
        return lista;
    }

    public void setLista(List<ListaGrupoDTO> lista) {
        this.lista = lista;
    }

    public ListaGrupoDTO getGrupoRetorno() {
        return grupoRetorno;
    }

    public void setGrupoRetorno(ListaGrupoDTO grupoRetorno) {
        this.grupoRetorno = grupoRetorno;
    }
}
