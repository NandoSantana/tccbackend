package br.com.tcc.api.querys;

import br.com.tcc.api.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class UsuarioQueryImpl implements UsuarioQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Boolean buscarUsuariosNomeDiferentesAlterando(Usuario usuario) {
        String queryString = "SELECT u FROM " + Usuario.class.getName() + " u " +
                "FROM u.nome = :nome " +
                "AND u.id <> :id ";
        Query query = manager.createQuery(queryString);
        query.setParameter("nome", usuario.getNome());
        query.setParameter("id", usuario.getId());
        return query.getResultList().isEmpty();
    }

    @Override
    public Boolean buscarUsuariosNomeSobreNomeDiferentesAlterando(Usuario usuario) {
        String queryString = "SELECT u FROM " + Usuario.class.getName() + " u " +
                "FROM u.nome = :nome " +
                "AND u.sobrenome = :sobrenome" +
                "AND u.id <> :id ";
        Query query = manager.createQuery(queryString);
        query.setParameter("nome", usuario.getNome());
        query.setParameter("id", usuario.getId());
        query.setParameter("sobrenome", usuario.getSobrenome());
        return query.getResultList().isEmpty();
    }
}
