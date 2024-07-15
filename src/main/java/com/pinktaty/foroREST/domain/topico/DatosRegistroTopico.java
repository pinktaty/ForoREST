package com.pinktaty.foroREST.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank(message = "Título es obligatorio.") String titulo,
        @NotBlank(message = "Mensaje es obligatorio.") String mensaje,
        String autor,
        @NotNull(message = "Curso es obligatorio.") Long cursoId
) {
}
