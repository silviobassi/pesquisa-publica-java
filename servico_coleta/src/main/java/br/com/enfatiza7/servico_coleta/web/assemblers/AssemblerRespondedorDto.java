package br.com.enfatiza7.servico_coleta.web.assemblers;

import br.com.enfatiza7.servico_coleta.event.Respondedor;
import br.com.enfatiza7.servico_coleta.web.dtos.RespondedorDto;
import org.springframework.stereotype.Service;

@Service
public class AssemblerRespondedorDto {

    public Respondedor toRespondedor(RespondedorDto respondedorDto) {
        return new Respondedor(respondedorDto.nome(), respondedorDto.email(), respondedorDto.idade());
    }
}
