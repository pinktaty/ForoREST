package com.pinktaty.foroREST.controller;

import com.pinktaty.foroREST.domain.curso.CursoService;
import com.pinktaty.foroREST.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/topicos")
@RestController
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosTopico, UriComponentsBuilder uriBuilder) {

        Topico topico = topicoService.registrarTopico(new Topico(datosTopico));
        String curso = cursoService.obtenerNombreCurso(topico.getCursoId());

        DatosRespuestaTopico topicoRespuesta = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getFechaCreacion().toString(),
                topico.getEstado().toString(),
                curso
        );

        URI url = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(topicoRespuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerTopico(@PathVariable Long id) {

        Topico topico = topicoService.buscarTopico(id);

        if(topico == null){
            return ResponseEntity.notFound().build();
        }

        String curso = cursoService.obtenerNombreCurso(topico.getId());

        DatosRespuestaTopico topicoRespuesta = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                topico.getFechaCreacion().toString(), topico.getEstado().toString(), curso);

        return ResponseEntity.ok(topicoRespuesta);
    }

    @GetMapping
    public ResponseEntity<List<DatosListadoTopico>> listarTopicosActivos(Pageable pageable) {

        List<Topico> topicos = topicoService.listarTopicosActivos(pageable);

        List<DatosListadoTopico> datosListadoTopicos = topicos.stream().map(topico -> {
                    String cursoNombre = cursoService.obtenerNombreCurso(topico.getCursoId());

                    return new DatosListadoTopico(topico, cursoNombre);
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(datosListadoTopicos);
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<DatosListadoTopico>> listarTodosTopicos(Pageable pageable) {

        Page<Topico> topicos = topicoService.listarTodosTopicos(pageable);

        Page<DatosListadoTopico> datosListadoTopicos = topicos.map(topico -> {
            String cursoNombre = cursoService.obtenerNombreCurso(topico.getCursoId());

            return new DatosListadoTopico(topico, cursoNombre);
        });

        return ResponseEntity.ok(datosListadoTopicos);
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<Page<DatosListadoTopico>> obtenerTopicosCurso(Pageable pageable, @PathVariable Long cursoId) {

        if(cursoService.obtenerNombreCurso(cursoId) == null){
            return ResponseEntity.notFound().build();
        }

        Page<Topico> topicos = topicoService.buscarTopicosCurso(pageable, cursoId);

        String cursoNombre = cursoService.obtenerNombreCurso(cursoId);

        Page<DatosListadoTopico> datosListadoTopicos = topicos.map(topico -> {

            return new DatosListadoTopico(topico, cursoNombre);
        });

        return ResponseEntity.ok(datosListadoTopicos);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizaTopico(@RequestBody @Valid DatosActualizaTopico datosActualizaTopico){

        Topico topico = topicoService.obtenerReferenciaTopico(datosActualizaTopico.id());

        if(topico == null){
            return ResponseEntity.notFound().build();
        }

        topico.actualizaDatos(datosActualizaTopico);

        String cursoNombre = cursoService.obtenerNombreCurso(topico.getCursoId());

        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getEstado().toString(),
                cursoNombre
                ));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminaTopico(@PathVariable Long id){

        Topico topico = topicoService.obtenerReferenciaTopico(id);

        if(topico == null){
            return ResponseEntity.notFound().build();
        }

        topico.eliminaTopico();

        return ResponseEntity.ok().build();
    }
}
