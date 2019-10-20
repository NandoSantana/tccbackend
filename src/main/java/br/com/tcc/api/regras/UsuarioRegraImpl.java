package br.com.tcc.api.regras;

import br.com.tcc.api.excecoes.UsuarioException;
import br.com.tcc.api.model.Usuario;
import br.com.tcc.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UsuarioRegraImpl implements UsuarioRegra {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validarSalvar(Usuario usuario) throws UsuarioException {
        if(usuario.getNome() == null ||
                usuario.getNome().length() == 0){
            throw new UsuarioException();
        }
        if(usuario.getSobrenome() == null ||
                usuario.getSobrenome().length() == 0){
            throw new UsuarioException();
        }
        if(usuario.getGrupo() == null){
            throw new UsuarioException();
        }
        if(usuario.getDataAniversario() == null){
            throw new UsuarioException();
        }
        if(usuario.getId() == null){
            antesInserir(usuario);
        } else {
            antesAlterar(usuario);
        }
        usuario.setDataCadastro(new Date());
    }

    private void antesInserir(Usuario usuario) throws UsuarioException {
        Usuario u = repository.findByNome(usuario.getNome());
        if(u != null){
            throw new UsuarioException();
        }
        u = repository.findByNomeAndSobrenome(usuario.getNome(), usuario.getSobrenome());
        if(u != null){
            throw new UsuarioException();
        }
    }

    private void antesAlterar(Usuario usuario) throws UsuarioException {
        if(repository.buscarUsuariosNomeDiferentesAlterando(usuario)){
            throw new UsuarioException();
        }
        if(repository.buscarUsuariosNomeSobreNomeDiferentesAlterando(usuario)){
            throw new UsuarioException();
        }
    }
}
