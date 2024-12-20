package br.com.enfatiza7.servico_coleta.infrastructure.producers;

import br.com.enfatiza7.servico_coleta.event.IntegrationEvent;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer implements EventBus {

    private static Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    final RabbitTemplate rabbitTemplate;

    @Value("${queue.name}")
    private String queueName;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

    @CircuitBreaker(name = "enviaPesquisaRespondida", fallbackMethod = "fallbackEnviaPesquisaRespondida")
    @Override
    public <T extends IntegrationEvent> void publish(T event) {
        rabbitTemplate.convertAndSend(queueName, event);
        LOGGER.info("✅ Pesquisa respondida enviada com sucesso: eventId:  %s".formatted(event.eventId));
    }

    @Override
    public <T extends IntegrationEvent> void fallbackEnviaPesquisaRespondida(T event, Throwable t) {
        LOGGER.error("❌ Falha ao enviar pesquisa respondida, ativando fallback: " + t.getMessage());
        // Aqui você pode implementar a lógica alternativa, como registrar o erro, tentar novamente, etc.
    }
}
