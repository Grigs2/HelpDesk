package br.fatec.HelpDesk.repositories;

import br.fatec.HelpDesk.entities.Usuario;
import br.fatec.HelpDesk.entities.UsuarioEquipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioEquipeRepositories extends JpaRepository<UsuarioEquipe, Long> {

    List<UsuarioEquipe> findByUsuario(Usuario usuario);


}
