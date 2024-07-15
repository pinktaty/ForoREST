package com.pinktaty.foroREST.domain.topico;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String fechaCreacion,
        String estado,
        String curso
) { }
