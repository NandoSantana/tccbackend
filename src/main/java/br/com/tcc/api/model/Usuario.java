package br.com.tcc.api.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "TB_USUARIO", uniqueConstraints = {@UniqueConstraint(columnNames = {"DS_NOME"},
        name = "U_TB_USUARIO_1")}, indexes = {
        @Index(columnList = "FK_GRUPO", name = "I1_TB_GRUPO"),
        @Index(columnList = "DS_NOME", name = "I2_TB_GRUPO")})
public class Usuario extends SuperGrupo {

    @ManyToOne(targetEntity = Grupo.class, fetch = EAGER)
    @JoinColumn(name = "FK_GRUPO", nullable = false)
    private Grupo grupo;
    @Column(name = "DS_NOME", nullable = false, length = 100)
    private String nome;
    @Column(name = "DS_SOBRENOME", nullable = false, length = 100)
    private String sobrenome;
    @Temporal(DATE)
    @Column(name = "TS_DATA_ANIVERSARIO", nullable = false)
    private Date dataAniversario;

    public Grupo getGrupo() {
        return grupo;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
}
