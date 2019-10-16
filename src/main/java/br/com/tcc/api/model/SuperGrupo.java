package br.com.tcc.api.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
public class SuperGrupo {

    @Id
    @Column(name = "PK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TIMESTAMP)
    @Column(name = "TS_DATA_HORA_CADASTRO", nullable = false)
    private Date dataCadastro;

    public Long getId() {
        return id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
