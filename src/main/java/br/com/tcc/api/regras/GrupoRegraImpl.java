package br.com.tcc.api.regras;

import br.com.tcc.api.excecoes.GrupoException;
import br.com.tcc.api.model.Grupo;
import br.com.tcc.api.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GrupoRegraImpl implements GrupoRegra {

    @Autowired
    private GrupoRepository repository;

    @Override
    public void validarSalvar(Grupo grupo) throws GrupoException {
        if(grupo.getNome() == null ||
                grupo.getNome().length() == 0){
            throw new GrupoException();
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
            throw new GrupoException();
        }
    }

    private void antesInserir(Grupo grupo) throws GrupoException {
        if(repository.buscarGruposNomeDiferentesAlterando(grupo)){
            throw new GrupoException();
        }
    }
}
