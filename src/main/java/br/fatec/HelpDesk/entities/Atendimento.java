package br.fatec.HelpDesk.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "atendimento", schema = "public")
public class Atendimento implements Serializable {

    @Serial
    private static final long serialVersionUID = 112312312312312L;


    @Id
    @SequenceGenerator(name="SEQ_Atendimento", sequenceName="public.seq_atendimento", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_Atendimento")
    private Long id;

    @ManyToOne
    @JoinColumn(name="status", referencedColumnName = "status", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name="id_usuario_equipe", referencedColumnName = "id", nullable = false)
    private UsuarioEquipe usuarioEquipe;

    @ManyToOne
    @JoinColumn(name="id_ticket", referencedColumnName = "id", nullable = false)
    private Ticket ticket;

    @Column(name="data_atendimento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataAtendimento;

    @Column(name="descricao_atendimento", nullable = false, columnDefinition = "TEXT", length = 500)
    private String descricaoAtendimento;
}
