package br.com.tcc.api.componentes;

import br.com.tcc.api.excecoes.UsuarioException;
import br.com.tcc.api.model.Usuario;
import br.com.tcc.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static br.com.tcc.api.utils.StringUtils.isNuloVazio;

@Component
public class UsuarioRegraImpl implements UsuarioRegra {

    private static final String NOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS = "Nome existente em nossa base de dados !";
    private static final String NOME_E_SOBRENOME_EXISTENTE_EM_NOSSA_BASE_DE_DADOS = "Nome e sobrenome existente em nossa base de dados !";
    private static final String NOME_E_OBRIGATORIO = "Nome é obrigatório !";
    private static final String SOBRENOME_E_OBRIGATORIO = "Sobrenome é obrigatório !";
    private static final String DEVE_ESCOLHER_UM_GRUUPO = "Deve escolher um gruupo !";
    private static final String DEVE_ESCOLHER_UMA_DATA_DE_ANIVERSARIO = "Deve escolher uma data de aniversário !";

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validarSalvar(Usuario usuario) throws UsuarioException {
        if(isNuloVazio(usuario.getNome())){
            throw new UsuarioException(NOME_E_OBRIGATORIO);
        }
        if(isNuloVazio(usuario.getSobrenome())){
            throw new UsuarioException(SOBRENOME_E_OBRIGATORIO);
        }
        if(usuario.getGrupo() == null){
            throw new UsuarioException(DEVE_ESCOLHER_UM_GRUUPO);
        }
        if(usuario.getDataAniversario() == null){
            throw new UsuarioException(DEVE_ESCOLHER_UMA_DATA_DE_ANIVERSARIO);
        }
        if(usuario.getId() == null){
            antesInserir(usuario);
            usuario.setDataCadastro(new Date());
        } else {
            antesAlterar(usuario);
        }
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
