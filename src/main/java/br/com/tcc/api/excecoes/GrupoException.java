package br.com.tcc.api.excecoes;

public class GrupoException extends Exception {

    private String mensagem;

    public GrupoException(String mensagem) {
        super();
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
