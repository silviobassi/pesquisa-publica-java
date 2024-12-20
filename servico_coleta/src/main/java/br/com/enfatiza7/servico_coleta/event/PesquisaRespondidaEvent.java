package br.com.enfatiza7.servico_coleta.event;

import java.util.List;

public class PesquisaRespondidaEvent extends IntegrationEvent {
    public final int idPesquisa;
    public final Respondedor respondedor;
    public final List<Resposta> respostas;

    public PesquisaRespondidaEvent(int idPesquisa, Respondedor respondedor, List<Resposta> respostas) {
        this.idPesquisa = idPesquisa;
        this.respondedor = respondedor;
        this.respostas = respostas;
    }
}
