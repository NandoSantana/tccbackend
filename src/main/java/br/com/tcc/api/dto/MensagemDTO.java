package br.com.tcc.api.dto;

public class MensagemDTO {

    private String tipo;
    private String sumario;
    private String mensagem;

    public String getTipo() {
        return tipo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
