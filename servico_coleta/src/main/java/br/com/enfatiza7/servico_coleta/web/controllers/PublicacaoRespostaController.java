package br.com.enfatiza7.servico_coleta.web.controllers;

import br.com.enfatiza7.servico_coleta.infrastructure.producers.RabbitMQProducer;
import br.com.enfatiza7.servico_coleta.infrastructure.producers.MessageBus;
import br.com.enfatiza7.servico_coleta.web.dtos.PesquisaRespondidaDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respostas")
public class PublicacaoRespostaController {

    final MessageBus publicadorDeRespostaService;

    public PublicacaoRespostaController(RabbitMQProducer publicadorDeRespostaService) {
        this.publicadorDeRespostaService = publicadorDeRespostaService;
    }

    @PostMapping()
    public void postResposta(@RequestBody PesquisaRespondidaDto resposta) {
        publicadorDeRespostaService.enviar(resposta);
    }

}
