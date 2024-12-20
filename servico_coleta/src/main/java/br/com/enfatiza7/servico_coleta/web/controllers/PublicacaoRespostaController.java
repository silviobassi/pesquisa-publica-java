package br.com.enfatiza7.servico_coleta.web.controllers;

import br.com.enfatiza7.servico_coleta.services.ServicoDeColeta;
import br.com.enfatiza7.servico_coleta.web.dtos.PesquisaRespondidaDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respostas")
public class PublicacaoRespostaController {

    private final ServicoDeColeta servicoDeColeta;

    public PublicacaoRespostaController(ServicoDeColeta servicoDeColeta) {
        this.servicoDeColeta = servicoDeColeta;
    }

    @PostMapping()
    public void postResposta(@RequestBody PesquisaRespondidaDto resposta) {
        servicoDeColeta.processar(resposta);
    }
}
