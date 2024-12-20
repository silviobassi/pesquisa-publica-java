package br.com.enfatiza7.servico_coleta.services;

import br.com.enfatiza7.servico_coleta.event.PesquisaRespondidaEvent;
import br.com.enfatiza7.servico_coleta.event.Respondedor;
import br.com.enfatiza7.servico_coleta.event.Resposta;
import br.com.enfatiza7.servico_coleta.infrastructure.producers.EventBus;
import br.com.enfatiza7.servico_coleta.web.assemblers.AssemblerRespondedorDto;
import br.com.enfatiza7.servico_coleta.web.assemblers.AssemblerRespostaDto;
import br.com.enfatiza7.servico_coleta.web.dtos.PesquisaRespondidaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoDeColetaImpl implements ServicoDeColeta {

    final EventBus eventBus;

    final AssemblerRespondedorDto assemblerRespondedorDto;
    final AssemblerRespostaDto assemblerRespostaDto;

    public ServicoDeColetaImpl(EventBus eventBus, AssemblerRespondedorDto assemblerRespondedorDto, AssemblerRespostaDto assemblerRespostaDto) {
        this.eventBus = eventBus;
        this.assemblerRespondedorDto = assemblerRespondedorDto;
        this.assemblerRespostaDto = assemblerRespostaDto;
    }

    public void processar(PesquisaRespondidaDto pesquisaRespondidaDto) {
        Respondedor respondedor = assemblerRespondedorDto.toRespondedor(pesquisaRespondidaDto.respondedor());
        List<Resposta> listaRespostas = assemblerRespostaDto.toListaRespostas(pesquisaRespondidaDto.respostas());

        PesquisaRespondidaEvent pesquisaRespondidaEvent = new PesquisaRespondidaEvent(
                pesquisaRespondidaDto.idPesquisa(), respondedor, listaRespostas);

        eventBus.publish(pesquisaRespondidaEvent);
    }
}
