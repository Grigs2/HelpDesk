package br.fatec.HelpDesk.enums;

public enum TipoStatus {

    AGUARDANDO_ATENDIMENTO("Aguardando Atendimento"),
    INICIADO("Iniciado"),
    ENCAMINHADO("Encaminhado"),
    DEVOLVIDO("Devolvido"),
    CONCLUIDO("Concluído");

    private final String descricao;

    TipoStatus(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

}
