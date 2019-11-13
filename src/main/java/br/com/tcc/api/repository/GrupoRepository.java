package br.com.tcc.api.repository;

import br.com.tcc.api.model.Grupo;
import br.com.tcc.api.querys.GrupoQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long>, GrupoQuery {

    public Grupo findByNome(String nome);
}
