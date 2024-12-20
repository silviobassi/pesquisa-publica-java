package br.com.enfatiza7.servico_coleta.web.assemblers;

import br.com.enfatiza7.servico_coleta.event.Resposta;
import br.com.enfatiza7.servico_coleta.web.dtos.RespostaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssemblerRespostaDto {

    public List<Resposta> toListaRespostas(List<RespostaDto> respostasDto) {
        return respostasDto
                .stream()
                .map(respostaDto -> new Resposta(respostaDto.id())).toList();
    }
}
