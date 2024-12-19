package br.com.enfatiza7.servico_coleta.infrastructure.producers;

import br.com.enfatiza7.servico_coleta.event.PesquisaRespondidaEvent;
import br.com.enfatiza7.servico_coleta.services.GeradorDeEventoDePesquisaRespondidaService;
import br.com.enfatiza7.servico_coleta.services.GeradorDeEventoDePesquisaRespondidaServiceImpl;
import br.com.enfatiza7.servico_coleta.web.dtos.PesquisaRespondidaDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer implements MessageBus {

    final GeradorDeEventoDePesquisaRespondidaService geradorDeEventoDePesquisaRespondidaService;
    final RabbitTemplate rabbitTemplate;

    @Value("${queue.name}")
    private String queueName;

    public RabbitMQProducer(
            GeradorDeEventoDePesquisaRespondidaServiceImpl geracaoDeRespostasService,
            RabbitTemplate rabbitTemplate) {

        this.geradorDeEventoDePesquisaRespondidaService = geracaoDeRespostasService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

    @CircuitBreaker(name = "enviarPesquisaRespondida", fallbackMethod = "fallbackEnviaPesquisaRespondida")
    public void enviar(PesquisaRespondidaDto pesquisaRespondidaDto) {

        //throw new RuntimeException("Erro ao enviar pesquisa respondida");

        PesquisaRespondidaEvent pesquisaRespondidaEvent = geradorDeEventoDePesquisaRespondidaService.gerar(pesquisaRespondidaDto);
        rabbitTemplate.convertAndSend(queueName, pesquisaRespondidaEvent);
    }

    public void fallbackEnviaPesquisaRespondida(PesquisaRespondidaDto pesquisaRespondidaDto, Throwable t) {
        System.out.println("❌ Falha ao enviar pesquisa respondida, ativando fallback: " + t.getMessage());
        // Aqui você pode implementar a lógica alternativa, como registrar o erro, tentar novamente, etc.
    }
}
