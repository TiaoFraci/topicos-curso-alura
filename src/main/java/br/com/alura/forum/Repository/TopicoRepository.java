package br.com.alura.forum.Repository;

import br.com.alura.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TopicoRepository extends JpaRepository<Topico,Long> {

    /*Filtra Curso por nome  */
    List<Topico> findByCursoNome(String nomeCurso);
}
