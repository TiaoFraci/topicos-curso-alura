package br.com.alura.forum.modelo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity
public class Topico {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
    @ManyToOne
	private Usuario autor;
    @ManyToOne
	private Curso curso;
    @ManyToMany( fetch=FetchType.EAGER, mappedBy = "topico")
	private List<Resposta> respostas = new ArrayList<>();

	public Topico(String titulo, String mensagem, Curso curso) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.curso =curso;
	}
}
