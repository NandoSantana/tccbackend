package br.com.tcc.api.service;

import br.com.tcc.api.model.Grupo;
import br.com.tcc.api.model.Usuario;
import br.com.tcc.api.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository repository;

    public List<Grupo> buscarTodos(){
        return repository.findAll();
    }

    public Grupo inserir (Grupo grupo){
        return salvar(grupo);
    }

    public Grupo alterar (Grupo grupo){
        return salvar(grupo);
    }

    public void deletar(Grupo grupo){
        repository.delete(grupo);
    }

    public Grupo buscarPeloId(Long id){
        Optional<Grupo> byId = repository.findById(id);
        return byId.get();
    }

    private Grupo salvar(Grupo grupo){
        return repository.save(grupo);
    }
}
