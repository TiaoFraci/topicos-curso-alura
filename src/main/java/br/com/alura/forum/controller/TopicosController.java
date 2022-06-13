package br.com.alura.forum.controller;

import br.com.alura.forum.Repository.CursoRepository;
import br.com.alura.forum.Repository.TopicoRepository;
import br.com.alura.forum.controller.Service.TopicosServices;
import br.com.alura.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;


    @Autowired
    private TopicosServices topicosServices;



        /*
    http STATUS de response
    200 a 299 OK sucesso
    400 a 499 Erros cometidos por quem está cahamdo a aplicação  O CLIENTE
    500  erros internos do servidor da aplicação*/






    /*
    BUSCA
    Metodo Get busca todos os tópicos*/
    @GetMapping
    public List<TopicoDto> lista(String nomeCurso) {
        return topicosServices.buscaPorNomeCursoOuLista(nomeCurso);


    }

    /* Verbo Http  SALVAR
    faz envio de requisisao, Salvando no banco de dados*/
    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        return topicosServices.enviaTopico(form, uriBuilder);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable Long id) {
        return topicosServices.mostraDetalhesDoTopico(id);
    }

    /*FAZ A ALTERAÇÃO COMPLETA DE UM RECURSO*/
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizr(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
        Topico topico = form.atualizar(id, topicoRepository);

        return ResponseEntity.ok(new TopicoDto(topico));

    }

        /*
        @PetMapping FAZ A ALTERAÇÃO PARCIAL DE UM RECURSO*/


        /*DELETA UM RECURSO*/
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id){
        return topicosServices.deletaTopico(id);

    }




}
