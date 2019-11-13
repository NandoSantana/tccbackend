package br.com.tcc.api.service;

import br.com.tcc.api.componentes.ConverterGrupo;
import br.com.tcc.api.dto.GrupoDTO;
import br.com.tcc.api.dto.ListaGrupoDTO;
import br.com.tcc.api.dto.MensagemDTO;
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
public class GrupoServiceImpl extends ServicePrincipal implements GrupoService {

    @Autowired
    private GrupoRepository repository;
    @Autowired
    private GrupoRegra regra;
    @Autowired
    private ConverterGrupo converter;

    public GrupoDTO buscarTodos(ListaGrupoDTO grupo) {
        List<ListaGrupoDTO> grupoDTOS = new ArrayList<>();
        List<Grupo> grupos = repository.findAll();
        for (Grupo grupoResultado: grupos){
            grupoDTOS.add(converter.converteEntidadeDTO(grupoResultado));
        }
        GrupoDTO dto = new GrupoDTO();
        dto.setLista(grupoDTOS);
        dto.setTipoMensagem(mensagemRetornoBusca(grupoDTOS.size() > 0));
        return dto;
    }

    public GrupoDTO inserir(ListaGrupoDTO dto)  {
        GrupoDTO grupo = new GrupoDTO();
        try {
            dto = converter.converteEntidadeDTO(salvar(dto));
            grupo.setTipoMensagem(mensagemSalvar());
            grupo.setGrupoRetorno(dto);
        } catch (GrupoException e) {
            e.printStackTrace();
            MensagemDTO mensagem = new MensagemDTO();
            mensagem.setSumario("Error");
            mensagem.setTipo("error");
            mensagem.setMensagem(e.getMensagem());
            grupo.setTipoMensagem(mensagem);
        }
        return grupo;
    }

    public GrupoDTO alterar(ListaGrupoDTO dto)  {
        GrupoDTO grupo = new GrupoDTO();
        try {
            dto = converter.converteEntidadeDTO(salvar(dto));
            grupo.setTipoMensagem(mensagemSalvar());
            grupo.setGrupoRetorno(dto);
        } catch (GrupoException e) {
            e.printStackTrace();
            MensagemDTO mensagem = new MensagemDTO();
            mensagem.setSumario("Error");
            mensagem.setTipo("error");
            mensagem.setMensagem(e.getMensagem());
            grupo.setTipoMensagem(mensagem);
        }
        return grupo;
    }

    public void deletar(ListaGrupoDTO dto)  {
        repository.delete(converter.converteDTOEntidade(dto));
    }

    public ListaGrupoDTO buscarPeloId(Long id) {
        Optional<Grupo> byId = repository.findById(id);
        return converter.converteEntidadeDTO(byId.get());
    }

    private Grupo salvar(ListaGrupoDTO dto) throws GrupoException {
        Grupo grupo = converter.converteDTOEntidade(dto);
        regra.validarSalvar(grupo);
        return repository.save(grupo);
    }
}
