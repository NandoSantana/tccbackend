package br.com.tcc.api.service;

import br.com.tcc.api.componentes.ConverterGrupo;
import br.com.tcc.api.dto.GrupoDTO;
import br.com.tcc.api.excecoes.GrupoException;
import br.com.tcc.api.model.Grupo;
import br.com.tcc.api.componentes.GrupoRegra;
import br.com.tcc.api.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    private GrupoRepository repository;
    @Autowired
    private GrupoRegra regra;
    @Autowired
    private ConverterGrupo converter;

    public List<GrupoDTO> buscarTodos(GrupoDTO grupo) {
        List<GrupoDTO> grupoDTOS = new ArrayList<>();
        List<Grupo> grupos = repository.findAll();
        for (Grupo grupoResultado: grupos){
            grupoDTOS.add(converter.converteEntidadeDTO(grupoResultado));
        }
        return grupoDTOS;
    }

    public GrupoDTO inserir(GrupoDTO dto) throws GrupoException {
        return converter.converteEntidadeDTO(salvar(dto));
    }

    public GrupoDTO alterar(GrupoDTO dto) throws GrupoException {
        return converter.converteEntidadeDTO(salvar(dto));
    }

    public void deletar(GrupoDTO dto)  {
        repository.delete(converter.converteDTOEntidade(dto));
    }

    public GrupoDTO buscarPeloId(Long id) {
        Optional<Grupo> byId = repository.findById(id);
        return converter.converteEntidadeDTO(byId.get());
    }

    private Grupo salvar(GrupoDTO dto) throws GrupoException {
        Grupo grupo = converter.converteDTOEntidade(dto);
        regra.validarSalvar(grupo);
        return repository.save(grupo);
    }
}
