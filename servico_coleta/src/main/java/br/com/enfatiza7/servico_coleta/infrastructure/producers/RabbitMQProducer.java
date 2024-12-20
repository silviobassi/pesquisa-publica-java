package br.com.enfatiza7.servico_coleta.infrastructure.producers;

import br.com.enfatiza7.servico_coleta.event.IntegrationEvent;
import br.com.enfatiza7.servico_coleta.web.dtos.PesquisaRespondidaDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer implements EventBus {

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
    }

    public void fallbackEnviaPesquisaRespondida(PesquisaRespondidaDto pesquisaRespondidaDto, Throwable t) {
        System.out.println("❌ Falha ao enviar pesquisa respondida, ativando fallback: " + t.getMessage());
        // Aqui você pode implementar a lógica alternativa, como registrar o erro, tentar novamente, etc.
    }
}
