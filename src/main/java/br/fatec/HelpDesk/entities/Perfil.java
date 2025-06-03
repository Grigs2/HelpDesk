package br.fatec.HelpDesk.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data //Implementação implicita dos getters e setters, constructor contendo todas e nenhuma variavel
@Entity //Identifica um Entitade do banco de dados
@Table(name = "perfil", schema = "public") //Identifica que a classe é uma tabela no banco de dados
public class Perfil implements Serializable {

    @Serial
    private static final long serialVersionUID = 112312312312312L; //serial para segurança da classe

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_perfil", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    private Long id; //Longo = classe long | long = Tipo primitivo long (Long aceita null, long não aceita)

    @Column(name = "perfil", nullable = false, length = 50)
    private String perfil;

    public Perfil(Long id, String perfil) {
        this.id = id;
        this.perfil = perfil.toUpperCase();
    }
    public Perfil(String perfil) {
        this.perfil = perfil.toUpperCase();
    }

    public Perfil() {}

    public void setPerfil(String nomePerfil) {this.perfil = nomePerfil.toUpperCase();}

}
