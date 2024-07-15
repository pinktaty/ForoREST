package com.pinktaty.foroREST.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findAllByCursoId(Long cursoId, Pageable pageable);

    @Query(value = "SELECT * FROM topicos WHERE estado IN (:estado1, :estado2)", nativeQuery = true)
    List<Topico> findByEstado(@Param("estado1") String estado1, @Param("estado2") String estado2, Pageable pageable);
}
