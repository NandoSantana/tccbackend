package br.com.tcc.api.querys;

import br.com.tcc.api.model.Grupo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class GrupoQueryImpl implements GrupoQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Boolean buscarGruposNomeDiferentesAlterando(Grupo grupo) {
        String queryString = "SELECT g FROM " + Grupo.class.getName() + " g " +
                "WHERE g.nome = :nome " +
                "AND g.id = :id ";
        Query query = manager.createQuery(queryString);
        query.setParameter("nome", grupo.getNome());
        query.setParameter("id", grupo.getId());
        return query.getResultList().isEmpty();
    }

    @Override
    public List<Grupo> buscarGruposPorNome(Grupo grupo) {
        String queryString = "SELECT g FROM " + Grupo.class.getName() + " g " +
                "WHERE UPPER(g.nome) LIKE :nome ";
        Query query = manager.createQuery(queryString);
        query.setParameter("nome", "%" + grupo.getNome().toUpperCase() + "%");
        return query.getResultList();
    }
}
