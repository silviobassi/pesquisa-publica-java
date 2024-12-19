package br.com.enfatiza7.servico_processamento.domain;

import java.util.Set;

public record Resposta(int id, String titulo, Set<Respondedor> respondedores) {
}