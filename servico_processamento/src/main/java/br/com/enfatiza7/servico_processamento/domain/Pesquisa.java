package br.com.enfatiza7.servico_processamento.domain;

import java.time.LocalDateTime;
import java.util.Set;

public record Pesquisa(
        int id,
        String code,
        LocalDateTime periodo,
        Set<Respondedor> respondedores,
        Set<Pergunta> perguntas
        ) {
}