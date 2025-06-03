package br.fatec.HelpDesk.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Data
@Setter
@Getter
@Entity
@Table(name = "usuario_equipe", schema = "public")
public class UsuarioEquipe implements Serializable {

    @Serial
    private static final long serialVersionUID = 112312312312312L;

    @Id
    @SequenceGenerator  (name="SEQ_USUARIO_EQUIPE",
                        sequenceName = "public.seq_usuario_equipe",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO_EQUIPE")
    private Long id;


    @ManyToOne
    @JoinColumn(name="id_usuario", referencedColumnName = "id")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_equipe", referencedColumnName = "id")
    private Equipe equipe;

    @Column(name = "ativo")
    private boolean ativo;

    public boolean getAtivo() {
        return ativo;
    }

}
