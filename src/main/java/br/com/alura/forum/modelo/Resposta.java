package br.com.alura.forum.modelo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    @ManyToOne
    private Topico topico;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @ManyToOne
    private Usuario autor;
    private Boolean solucao = false;


}
