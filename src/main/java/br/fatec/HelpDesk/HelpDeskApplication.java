package br.fatec.HelpDesk;

import br.fatec.HelpDesk.entities.Perfil;
import br.fatec.HelpDesk.services.PerfilService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class HelpDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);


//		PerfilService perfilService = new PerfilService();
//		Perfil perfil = perfilService.cadastrar("Gerente");

		//System.out.println("Perfil1: " + perfil.getId() + " | " + perfil.getPerfil());

	}
}
