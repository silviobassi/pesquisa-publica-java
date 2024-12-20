package br.com.enfatiza7.servico_coleta.infrastructure.producers;

import br.com.enfatiza7.servico_coleta.event.IntegrationEvent;

public interface EventBus {
    <T extends IntegrationEvent> void publish(T event);

    <T extends IntegrationEvent> void fallbackEnviaPesquisaRespondida(T event, Throwable t);
}
