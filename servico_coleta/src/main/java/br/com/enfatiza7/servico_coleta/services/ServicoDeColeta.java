package br.com.enfatiza7.servico_coleta.services;

import br.com.enfatiza7.servico_coleta.web.dtos.PesquisaRespondidaDto;

public interface ServicoDeColeta {
    void processar(PesquisaRespondidaDto resposta);
}
