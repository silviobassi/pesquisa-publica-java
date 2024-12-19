package br.com.enfatiza7.servico_coleta.services;

import br.com.enfatiza7.servico_coleta.event.PesquisaRespondidaEvent;
import br.com.enfatiza7.servico_coleta.event.Resposta;
import br.com.enfatiza7.servico_coleta.event.Respondedor;
import br.com.enfatiza7.servico_coleta.web.assemblers.AssemblerRespostaDto;
import br.com.enfatiza7.servico_coleta.web.assemblers.AssemblerRespondedorDto;
import br.com.enfatiza7.servico_coleta.web.dtos.PesquisaRespondidaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeradorDeEventoDePesquisaRespondidaServiceImpl implements GeradorDeEventoDePesquisaRespondidaService {

    final AssemblerRespondedorDto assemblerRespondedorDto;
    final AssemblerRespostaDto assemblerRespostaDto;

    public GeradorDeEventoDePesquisaRespondidaServiceImpl(AssemblerRespondedorDto assemblerRespondedorDto, AssemblerRespostaDto assemblerRespostaDto) {
        this.assemblerRespondedorDto = assemblerRespondedorDto;
        this.assemblerRespostaDto = assemblerRespostaDto;
    }

    public PesquisaRespondidaEvent gerar(PesquisaRespondidaDto pesquisaRespondidaDto) {
        Respondedor respondedor = assemblerRespondedorDto.toRespondedor(pesquisaRespondidaDto.respondedor());
        List<Resposta> listaRespostas = assemblerRespostaDto.toListaRespostas(pesquisaRespondidaDto.respostas());

        return new PesquisaRespondidaEvent(pesquisaRespondidaDto.idPesquisa(), respondedor, listaRespostas);
    }
}
