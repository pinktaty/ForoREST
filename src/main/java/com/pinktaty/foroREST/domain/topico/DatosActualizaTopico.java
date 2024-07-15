package com.pinktaty.foroREST.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizaTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        Long cursoId
) {
}
