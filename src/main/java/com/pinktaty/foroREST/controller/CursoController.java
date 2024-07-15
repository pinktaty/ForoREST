package com.pinktaty.foroREST.controller;

import com.pinktaty.foroREST.domain.curso.Curso;
import com.pinktaty.foroREST.domain.curso.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cursos")
@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<Page<Curso>> listarCursos(Pageable pageable){
        return ResponseEntity.ok(cursoService.listarCursos(pageable));
    }

}
