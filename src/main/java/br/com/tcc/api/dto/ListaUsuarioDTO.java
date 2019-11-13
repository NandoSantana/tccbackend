package br.com.tcc.api.dto;

public class ListaUsuarioDTO extends SuperGrupoDTO {

    private ListaGrupoDTO grupo;
    private String nome;
    private String sobrenome;
    private String dataAniversario;

    public ListaGrupoDTO getGrupo() {
        return grupo;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setGrupo(ListaGrupoDTO grupo) {
        this.grupo = grupo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
}
