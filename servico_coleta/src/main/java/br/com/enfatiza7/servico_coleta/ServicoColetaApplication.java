package br.com.enfatiza7.servico_coleta;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class ServicoColetaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicoColetaApplication.class, args);
    }

}
