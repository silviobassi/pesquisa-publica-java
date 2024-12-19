package br.com.enfatiza7.servico_processamento.domain;

import java.util.Set;

public record Respondedor(int id, String nome, String email, int idade, Set<Resposta> respostas) {
}
