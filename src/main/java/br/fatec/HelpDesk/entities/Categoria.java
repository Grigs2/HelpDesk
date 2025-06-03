package br.fatec.HelpDesk.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "categoria", schema = "public")
public class Categoria implements Serializable {

    @Serial
    private static final long serialVersionUID = 112312312312312L;

    @Id
    @SequenceGenerator(name="SEQ_Categoria", sequenceName="public.seq_categoria", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Categoria")
    private Long id;

    @Column(name = "servico", nullable = false, length = 50)
    private String servico;

    public Categoria(Long id, String servico) {
        this.id = id;
        this.servico = servico.toUpperCase();
    }

    public Categoria(String servico) {
        this.servico = servico.toUpperCase();
    }
    public Categoria() {}
}
