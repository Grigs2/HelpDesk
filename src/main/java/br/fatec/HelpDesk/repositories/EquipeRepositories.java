package br.fatec.HelpDesk.repositories;

import br.fatec.HelpDesk.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepositories extends JpaRepository<Equipe, Long> {
}
