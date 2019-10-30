package br.com.tcc.api.componentes;

import br.com.tcc.api.excecoes.GrupoException;
import br.com.tcc.api.model.Grupo;
import br.com.tcc.api.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GrupoRegraImpl implements GrupoRegra {

    private static final String NOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS = "Nome do grupo existente em nossa base de dados !";

    @Autowired
    private GrupoRepository repository;

    @Override
    public void validarSalvar(Grupo grupo) throws GrupoException {
        if(grupo.getNome() == null ||
                grupo.getNome().length() == 0){
            throw new GrupoException("Nome do grupo é obrigatório !");
        }
        if(grupo.getId() == null){
            antesInserir(grupo);
        } else {
            antesAlterar(grupo);
        }
    }

    private void antesAlterar(Grupo grupo) throws GrupoException {
        Grupo u = repository.findByNome(grupo.getNome());
        if(u != null){
            throw new GrupoException(NOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS);
        }
    }

    private void antesInserir(Grupo grupo) throws GrupoException {
        if(repository.buscarGruposNomeDiferentesAlterando(grupo)){
            throw new GrupoException(NOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS);
        }
    }
}
