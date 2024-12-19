package br.com.enfatiza7.servico_coleta.services;

import br.com.enfatiza7.servico_coleta.event.PesquisaRespondidaEvent;
import br.com.enfatiza7.servico_coleta.web.dtos.PesquisaRespondidaDto;

public interface GeradorDeEventoDePesquisaRespondidaService {
    PesquisaRespondidaEvent gerar(PesquisaRespondidaDto resposta);
}
