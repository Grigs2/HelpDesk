package br.fatec.HelpDesk.repositories;

import br.fatec.HelpDesk.entities.Categoria;
import br.fatec.HelpDesk.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepositories extends JpaRepository<Usuario, Long> {

    //SQL
    @Query(value = "SELECT * from usuario WHERE email = :email", nativeQuery = true)
    public Optional<Usuario> findByEmailSQL(String email);

    //HQL - usa em todos bancos
    //Erro 12:00 HQL nao precisa de nativequery
    @Query (value = "SELECT usu FROM Usuario usu WHERE usu.email = :email")
    public Optional<Usuario> findByEmail(String email);

    //Campos que tenho na minha entidade eu posso buscar direto sem a @query

}
