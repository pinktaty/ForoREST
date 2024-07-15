CREATE TABLE cursos (
    curso_id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    categoria ENUM('Programación', 'Matematicas', 'Reposteria', 'Historia', 'Literatura', 'Ciencias Sociales') NOT NULL,

    PRIMARY KEY (curso_id)
);