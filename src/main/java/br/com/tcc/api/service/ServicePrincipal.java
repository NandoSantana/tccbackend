package br.com.tcc.api.service;

import br.com.tcc.api.dto.MensagemDTO;

class ServicePrincipal {

    MensagemDTO mensagemRetornoBusca(Boolean existeRegistro){
        MensagemDTO mensagem = new MensagemDTO();
        if(existeRegistro){
            mensagem.setMensagem("Pesquisa realizada com sucesso !");
            mensagem.setSumario("Sucesso");
            mensagem.setTipo("success");
        } else {
            mensagem.setMensagem("Não existem registros para esta pesquisa !");
            mensagem.setSumario("Error");
            mensagem.setTipo("error");
        }
        return mensagem;
    }

    MensagemDTO mensagemSalvar(){
        MensagemDTO mensagem = new MensagemDTO();
        mensagem.setMensagem("Registro salvo com sucesso !");
        mensagem.setSumario("Sucesso");
        mensagem.setTipo("success");
        return mensagem;
    }
}
