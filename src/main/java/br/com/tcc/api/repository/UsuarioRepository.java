package br.com.tcc.api.repository;

import br.com.tcc.api.model.Usuario;
import br.com.tcc.api.querys.UsuarioQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioQuery {

    public Usuario findByNome(String nome);

    public Usuario findByNomeAndSobrenome(String nome, String sobrenome);
}
