package br.fatec.HelpDesk.dtos;

import br.fatec.HelpDesk.entities.Categoria;

import java.io.Serial;
import java.io.Serializable;

public record CategoriaDTO(Long id, String serico) implements Serializable {

    @Serial
    public static final long serialVersionUID = 1112312312312L;

    public static CategoriaDTO valueOf(Categoria categoria) {
        if (categoria != null) return new CategoriaDTO(categoria.getId(), categoria.getServico());
        else return null;
    }
    public static Categoria toCategoria(CategoriaDTO dto) {
        if (dto != null) return new Categoria(dto.id, dto.serico);
        else return null;
    }
}
