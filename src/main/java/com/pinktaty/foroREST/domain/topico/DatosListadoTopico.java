package com.pinktaty.foroREST.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, Estado estado,
                                 String autor, String curso){

    public DatosListadoTopico(Topico topico, String curso){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getEstado(),
                topico.getAutor(), curso);
    }
}
