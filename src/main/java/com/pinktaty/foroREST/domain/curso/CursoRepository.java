package com.pinktaty.foroREST.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query(value = "SELECT nombre FROM cursos WHERE curso_id = :cursoId", nativeQuery = true)
    String obtenerNombreCurso(@Param("cursoId") Long cursoId);

}