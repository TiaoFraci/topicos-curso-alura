package br.com.alura.forum.controller.form;

import br.com.alura.forum.Repository.TopicoRepository;
import br.com.alura.forum.modelo.Topico;



public class AtualizacaoTopicoForm extends Topico {

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getOne(id);
        topico.setTitulo(super.getTitulo());
        topico.setMensagem(super.getMensagem());
        return topico;




    }
}