package com.pinktaty.foroREST.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizaTopico(
        @NotNull(message = "El ID no sebe ser nulo.") Long id,
        String titulo,
        String mensaje,
        Long cursoId
) {
}
