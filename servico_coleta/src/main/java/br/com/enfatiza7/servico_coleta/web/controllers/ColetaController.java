package br.com.enfatiza7.servico_coleta.web.controllers;

import br.com.enfatiza7.servico_coleta.services.ColetaService;
import br.com.enfatiza7.servico_coleta.web.dtos.PesquisaRespondidaDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respostas")
public class ColetaController {

    private final ColetaService coletaService;

    public ColetaController(ColetaService coletaService) {
        this.coletaService = coletaService;
    }

    @PostMapping()
    public void postResposta(@RequestBody PesquisaRespondidaDto resposta) {
        coletaService.processar(resposta);
    }
}
