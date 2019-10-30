package br.com.tcc.api.componentes;

import br.com.tcc.api.excecoes.UsuarioException;
import br.com.tcc.api.model.Usuario;
import br.com.tcc.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UsuarioRegraImpl implements UsuarioRegra {

    private static final String NOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS = "Nome existente em nossa base de dados !";
    private static final String NOME_E_SOBRENOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS = "Nome e sobrenome existente em nossa base de dados !";

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validarSalvar(Usuario usuario) throws UsuarioException {
        if(usuario.getNome() == null ||
                usuario.getNome().length() == 0){
            throw new UsuarioException("Nome é obrigatório !");
        }
        if(usuario.getSobrenome() == null ||
                usuario.getSobrenome().length() == 0){
            throw new UsuarioException("Sobrenome é obrigatório !");
        }
        if(usuario.getGrupo() == null){
            throw new UsuarioException("Deve escolher um gruupo !");
        }
        if(usuario.getDataAniversario() == null){
            throw new UsuarioException("Deve escolher uma data de aniversário !");
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
            throw new UsuarioException(NOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS);
        }
        u = repository.findByNomeAndSobrenome(usuario.getNome(), usuario.getSobrenome());
        if(u != null){
            throw new UsuarioException(NOME_E_SOBRENOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS);
        }
    }

    private void antesAlterar(Usuario usuario) throws UsuarioException {
        if(repository.buscarUsuariosNomeDiferentesAlterando(usuario)){
            throw new UsuarioException(NOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS);
        }
        if(repository.buscarUsuariosNomeSobreNomeDiferentesAlterando(usuario)){
            throw new UsuarioException(NOME_E_SOBRENOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS);
        }
    }
}
