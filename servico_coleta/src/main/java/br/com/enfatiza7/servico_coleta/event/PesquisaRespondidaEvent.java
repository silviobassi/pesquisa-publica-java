package br.com.enfatiza7.servico_coleta.event;

import java.util.List;

public record PesquisaRespondidaEvent(int idPesquisa, Respondedor respondedor, List<Resposta> respostas) {
}
