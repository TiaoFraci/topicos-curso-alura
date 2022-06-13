package br.com.alura.forum.controller.form;

import br.com.alura.forum.Repository.CursoRepository;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TopicoForm {

    @NotNull
    @NotEmpty
    private String titulo;
    @NotNull
    @NotEmpty
    private String mensagem;
    @NotNull
    @NotEmpty
    private String nomeCurso;

    public TopicoForm(String titulo, String mensagem, String nomeCurso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeCurso = nomeCurso;
    }

    public Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo,mensagem,curso);
    }
}
