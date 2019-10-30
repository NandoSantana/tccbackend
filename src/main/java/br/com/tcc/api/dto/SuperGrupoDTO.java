package br.com.tcc.api.dto;

public class SuperGrupoDTO {

    private Long id;
    private String dataCadastro;

    public Long getId() {
        return id;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
