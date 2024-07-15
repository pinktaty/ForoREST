package com.pinktaty.foroREST.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico registrarTopico(Topico topico){
        topicoRepository.save(topico);
        return topico;
    }

    public Topico buscarTopico(Long id){
        return topicoRepository.findById(id).orElse(null);
    }

    public Page<Topico> listarTodosTopicos(@PageableDefault(size = 2) Pageable pageable){
        return topicoRepository.findAll(pageable);
    }

    public List<Topico> listarTopicosActivos(Pageable pageable){
        return topicoRepository.findByEstado("ACTIVO", "ACTUALIZADO", pageable);
    }

    public Page<Topico> buscarTopicosCurso(@PageableDefault(size = 2) Pageable pageable, Long cursoId){
        return topicoRepository.findAllByCursoId(cursoId, pageable);
    }

    public Topico obtenerReferenciaTopico(Long id) {
        if(buscarTopico(id) == null){
            return null;
        }
        return topicoRepository.getReferenceById(id);
    }
}
