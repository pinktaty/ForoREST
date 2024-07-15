package com.pinktaty.foroREST.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private String autor;
    @Column(name = "curso_id")
    private Long cursoId;

    public Topico(DatosRegistroTopico datosRegistroTopico){
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.estado = Estado.ACTIVO;
        if(datosRegistroTopico.autor() != null){
            this.autor = datosRegistroTopico.autor();
        } else {
            this.autor = "Anónimo";
        }
        this.cursoId = datosRegistroTopico.cursoId();
    }

    public void actualizaDatos(DatosActualizaTopico datosActualizaTopico){

        this.estado = Estado.ACTUALIZADO;

        if(datosActualizaTopico.titulo() != null){
            this.titulo = datosActualizaTopico.titulo();
        }
        if(datosActualizaTopico.mensaje() != null){
            this.mensaje = datosActualizaTopico.mensaje();
        }
        if(datosActualizaTopico.cursoId() != null){
            this.cursoId = datosActualizaTopico.cursoId();
        }
    }

    public void eliminaTopico(){
        this.estado = Estado.INACTIVO;
    }
}