package br.com.tcc.api.querys;

import br.com.tcc.api.model.Grupo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class GrupoQueryImpl implements GrupoQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Boolean buscarGruposNomeDiferentesAlterando(Grupo grupo) {
        String queryString = "SELECT g FROM " + Grupo.class.getName() + " g " +
                "FROM g.nome = :nome " +
                "AND g.id <> :id ";
        Query query = manager.createQuery(queryString);
        query.setParameter("nome", grupo.getNome());
        query.setParameter("id", grupo.getId());
        return query.getResultList().isEmpty();
    }
}
