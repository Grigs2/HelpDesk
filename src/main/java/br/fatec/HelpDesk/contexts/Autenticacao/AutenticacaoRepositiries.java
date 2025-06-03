package br.fatec.HelpDesk.contexts.Autenticacao;

import br.fatec.HelpDesk.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AutenticacaoRepositiries extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT usu FROM Usuario usu " + "WHERE usu.email=:email AND usu.senha=:senha")
    Optional<Usuario> findByEmailAndSenha(String email, String  senha);
}
