package br.fatec.HelpDesk.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "equipe", schema = "public")
public class Equipe implements Serializable {

    @Serial
    private static final long serialVersionUID = 11231231256756712L;

    @Id
    @SequenceGenerator(name="SEQ_Equipe", sequenceName="public.seq_equipe", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_Equipe")
    private Long id;

    @Column(name = "equipe", nullable = false, length = 50)
    private String equipe;

    public Equipe(Long id, String equipe) {
        this.equipe = equipe.toUpperCase();
        this.id = id;
    }
    public Equipe(String equipe) {
        this.equipe = equipe.toUpperCase();
    }
    public Equipe() {}
}
