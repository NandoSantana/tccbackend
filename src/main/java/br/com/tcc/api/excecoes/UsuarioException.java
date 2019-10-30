package br.com.tcc.api.excecoes;

public class UsuarioException extends Exception {

    private String mensagem;

    public UsuarioException(String mensagem) {
        super();
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
