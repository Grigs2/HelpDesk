package br.fatec.HelpDesk.entities;

import br.fatec.HelpDesk.dtos.PerfilDTO;
import br.fatec.HelpDesk.dtos.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "usuario", schema = "public")
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 112312312312312L;

    @Id
    @SequenceGenerator(name="SEQ_Usuario", sequenceName="public.seq_usuario", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_Usuario")
    private Long id;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "cargo", length = 80)
    private String cargo;

    @Column(name = "telefone", length = 30)
    private String telefone;

    @ManyToOne(fetch = FetchType.LAZY)// Lazy=So busca perfil quando precisa (erro quando memoria esta cheia), Eager=sempre puxa
    @JoinColumn(name = "id_perfil", referencedColumnName = "id", insertable = true, updatable = true,foreignKey =
    @ForeignKey(name="fk_usuario_perfil"))
    private Perfil perfil;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<UsuarioEquipe> Usuarioequipes = new ArrayList<>();

    public List<Equipe> getEquipe() {
        //modificada na P1 para apenas equipes ativas
        return Usuarioequipes.stream().filter(UsuarioEquipe -> UsuarioEquipe.getAtivo())
                                      .map(UsuarioEquipe::getEquipe).toList();
        //Lista de classe UsuarioEquipes
        //usa o getEquipe em todos os UsuarioEquipes da lista e armazena na lista Equipes
    }


}
