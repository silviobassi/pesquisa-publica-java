package br.com.enfatiza7.servico_coleta.infrastructure.producers;

import br.com.enfatiza7.servico_coleta.web.dtos.PesquisaRespondidaDto;

public interface MessageBus {
    void enviar(PesquisaRespondidaDto pesquisaRespondidaDto);
}
