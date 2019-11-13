package br.com.tcc.api.dto;

public class PrincipalDTO {

    private MensagemDTO tipoMensagem;

    public MensagemDTO getTipoMensagem() {
        return tipoMensagem;
    }

    public void setTipoMensagem(MensagemDTO tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }
}
