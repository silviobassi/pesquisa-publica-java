package br.com.enfatiza7.servico_processamento.domain;

import java.util.Set;

public record Pergunta(long id, String titulo, Set<Resposta> respostas) {}