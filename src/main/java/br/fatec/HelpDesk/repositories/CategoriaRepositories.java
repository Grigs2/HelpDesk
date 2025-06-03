package br.fatec.HelpDesk.repositories;

import br.fatec.HelpDesk.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositories extends JpaRepository<Categoria, Long> {
}
