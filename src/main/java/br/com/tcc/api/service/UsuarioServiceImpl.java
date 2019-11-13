package br.com.tcc.api.service;

import br.com.tcc.api.componentes.ConverterUsuario;
import br.com.tcc.api.dto.ListaUsuarioDTO;
import br.com.tcc.api.dto.MensagemDTO;
import br.com.tcc.api.dto.UsuarioDTO;
import br.com.tcc.api.excecoes.UsuarioException;
import br.com.tcc.api.model.Usuario;
import br.com.tcc.api.componentes.UsuarioRegra;
import br.com.tcc.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl extends ServicePrincipal implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private UsuarioRegra regra;
    @Autowired
    private ConverterUsuario converter;

    public UsuarioDTO buscarTodos(){
        List<ListaUsuarioDTO> usuarioDTOS = new ArrayList<>();
        List<Usuario> usuarios = repository.findAll();
        for(Usuario usuario: usuarios){
            usuarioDTOS.add(converter.converteEntidadeDTO(usuario));
        }
        UsuarioDTO dto = new UsuarioDTO();
        dto.setLista(usuarioDTOS);
        dto.setTipoMensagem(mensagemRetornoBusca(usuarioDTOS.size() > 0));
        return dto;
    }

    public UsuarioDTO inserir (ListaUsuarioDTO usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        try {
            usuario = converter.converteEntidadeDTO(salvar(usuario));
            dto.setTipoMensagem(mensagemSalvar());
            dto.setUsuarioRetorno(usuario);
        } catch (UsuarioException e) {
            e.printStackTrace();
            MensagemDTO mensagem = new MensagemDTO();
            mensagem.setSumario("Error");
            mensagem.setTipo("error");
            mensagem.setMensagem(e.getMensagem());
            dto.setTipoMensagem(mensagem);
        }
        return dto;
    }

    public UsuarioDTO alterar (ListaUsuarioDTO usuario)  {
        UsuarioDTO dto = new UsuarioDTO();
        try {
            usuario = converter.converteEntidadeDTO(salvar(usuario));
            dto.setTipoMensagem(mensagemSalvar());
            dto.setUsuarioRetorno(usuario);
        } catch (UsuarioException e) {
            e.printStackTrace();
            MensagemDTO mensagem = new MensagemDTO();
            mensagem.setSumario("Error");
            mensagem.setTipo("error");
            mensagem.setMensagem(e.getMensagem());
            dto.setTipoMensagem(mensagem);
        }
        return dto;
    }

    public UsuarioDTO deletar(ListaUsuarioDTO dtoDeletar){
        UsuarioDTO dto = new UsuarioDTO();
        try {
            repository.delete(converter.converteDTOEntidade(dtoDeletar));
            dto.setTipoMensagem(mensagemDeletarOK());
            dto.setUsuarioRetorno(dtoDeletar);
        } catch (Exception e) {
            e.printStackTrace();
            dto.setTipoMensagem(mensagemDeletarErro());
        }
        return dto;
    }

    public ListaUsuarioDTO buscarPeloId(Long id){
        Optional<Usuario> byId = repository.findById(id);
        return converter.converteEntidadeDTO(byId.get());
    }

    private Usuario salvar(ListaUsuarioDTO dto) throws UsuarioException {
        Usuario usuario = converter.converteDTOEntidade(dto);
        regra.validarSalvar(usuario);
        return repository.save(usuario);
    }
}
