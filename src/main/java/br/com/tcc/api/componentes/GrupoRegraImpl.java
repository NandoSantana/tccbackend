package br.com.tcc.api.componentes;

import br.com.tcc.api.excecoes.GrupoException;
import br.com.tcc.api.model.Grupo;
import br.com.tcc.api.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static br.com.tcc.api.utils.StringUtils.isNuloVazio;

@Component
public class GrupoRegraImpl implements GrupoRegra {

    private static final String NOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS = "Nome do grupo existente em nossa base de dados !";
    private static final String NOME_OBRIGATORIO = "Nome do grupo é obrigatório !";

    @Autowired
    private GrupoRepository repository;

    @Override
    public void validarSalvar(Grupo grupo) throws GrupoException {
        if(isNuloVazio(grupo.getNome())){
            throw new GrupoException(NOME_OBRIGATORIO);
        }
        if(grupo.getId() == null){
            antesInserir(grupo);
            grupo.setDataCadastro(new Date());
        } else {
            antesAlterar(grupo);
        }
    }

    private void antesAlterar(Grupo grupo) throws GrupoException {
        Boolean retorno = repository.buscarGruposNomeDiferentesAlterando(grupo);
        if(!retorno){
            throw new GrupoException(NOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS);
        }
    }

    private void antesInserir(Grupo grupo) throws GrupoException {
        Grupo grupoBuscar = repository.findByNome(grupo.getNome());
        if(grupoBuscar == null){
            throw new GrupoException(NOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS);
        }
    }
}
