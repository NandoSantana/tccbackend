package br.com.tcc.api.querys;

import br.com.tcc.api.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UsuarioQueryImpl implements UsuarioQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Usuario> buscarUsuariosNomeDiferentesAlterando(Usuario usuario) {
        String queryString = "SELECT usu FROM " + Usuario.class.getName() + " usu " +
                "WHERE usu.nome = :nome " +
                "AND usu.id <> :id ";
        Query query = manager.createQuery(queryString);
        query.setParameter("nome", usuario.getNome());
        query.setParameter("id", usuario.getId());
        return query.getResultList();
    }
}
