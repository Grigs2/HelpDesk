package br.fatec.HelpDesk.repositories;

import br.fatec.HelpDesk.entities.Status;
import br.fatec.HelpDesk.enums.TipoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepositories extends JpaRepository<Status, TipoStatus> {
}
