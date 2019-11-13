package br.com.tcc.api.service;

import br.com.tcc.api.componentes.ConverterUsuario;
import br.com.tcc.api.dto.ListaUsuarioDTO;
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
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private UsuarioRegra regra;
    @Autowired
    private ConverterUsuario converter;

    public List<ListaUsuarioDTO> buscarTodos(){
        List<ListaUsuarioDTO> usuarioDTOS = new ArrayList<>();
        List<Usuario> usuarios = repository.findAll();
        for(Usuario usuario: usuarios){
            usuarioDTOS.add(converter.converteEntidadeDTO(usuario));
        }
        return usuarioDTOS;
    }

    public ListaUsuarioDTO inserir (ListaUsuarioDTO usuario) throws UsuarioException {
        return converter.converteEntidadeDTO(salvar(usuario));
    }

    public ListaUsuarioDTO alterar (ListaUsuarioDTO usuario) throws UsuarioException {
        return converter.converteEntidadeDTO(salvar(usuario));
    }

    public void deletar(ListaUsuarioDTO dto){
        repository.delete(converter.converteDTOEntidade(dto));
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
