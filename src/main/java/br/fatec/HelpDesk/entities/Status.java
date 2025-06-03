package br.fatec.HelpDesk.entities;

import br.fatec.HelpDesk.enums.TipoStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "status", schema = "public")
public class Status implements Serializable {

    @Serial
    private static final long serialVersionUID = 112312312312312L;


    @Id
    @Column(name="status", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private TipoStatus status;


}
