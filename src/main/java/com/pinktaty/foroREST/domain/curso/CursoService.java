package com.pinktaty.foroREST.domain.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public String obtenerNombreCurso(Long cursoId) {
        return cursoRepository.obtenerNombreCurso(cursoId);
    }

    public Page<Curso> listarCursos(@PageableDefault(size = 2) Pageable pageable){
        return cursoRepository.findAll(pageable);
    }

}

