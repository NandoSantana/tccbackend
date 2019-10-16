package br.com.tcc.api.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_GRUPO", uniqueConstraints = {@UniqueConstraint(columnNames = {"DS_NOME"},
        name = "U_TB_GRUPO_1")}, indexes = {
        @Index(columnList = "DS_NOME", name = "I1_TB_GRUPO")})
public class Grupo extends SuperGrupo {

    @Column(name = "DS_NOME", nullable = false, length = 20)
    private String nome;
}
