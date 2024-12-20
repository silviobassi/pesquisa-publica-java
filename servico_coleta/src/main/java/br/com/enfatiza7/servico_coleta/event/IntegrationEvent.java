package br.com.enfatiza7.servico_coleta.event;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class IntegrationEvent {
    public UUID eventId;
    public LocalDateTime creationDate;

    public IntegrationEvent() {
        this.eventId = UUID.randomUUID();
        this.creationDate = LocalDateTime.now();
    }
}
