package br.com.enfatiza7.servico_coleta.web.dtos;

import java.util.List;

public record PesquisaRespondidaDto(
        int idPesquisa,
        RespondedorDto respondedor,
        List<RespostaDto> respostas
) {
}


