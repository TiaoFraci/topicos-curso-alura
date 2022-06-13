package Test;


import br.com.alura.forum.Repository.TopicoRepository;
import br.com.alura.forum.controller.Service.TopicosServices;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Topico;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class Test {

    @InjectMocks
    private TopicosServices topicosServices;

    @Mock
    private TopicoRepository topicoRepository;

    @org.junit.Test
    public void testeBuscaPorNomeCurso(){
        List<Topico> topicos = topicoRepository.findAll();

        Mockito.when(topicosServices.buscaPorNomeCursoOuLista(null)).thenReturn(TopicoDto.converter(topicos));


    }



}
