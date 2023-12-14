package com.digipro.Equipo3DP.DL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface AlumnoMateriaRepository extends JpaRepository<Materia, Integer> {

    @Procedure(name = "AddAlumnoMateriaSP")
    void addAlumnoMateriaSP(
            @Param("p_id_alumno") Long idAlumno,
            @Param("p_id_materia") Long idMateria
    );

    @Procedure(name = "UpdateAlumnoMateriaSP")
    void updateAlumnoMateriaSP(
            @Param("p_id_alumno_materia") int idAlumnoMateria,
            @Param("p_id_alumno") int idAlumno,
            @Param("p_id_materia") int idMateria
    );

    @Procedure(name = "DeleteAlumnoMateriaSP")
    void deleteAlumnoMateriaSP(@Param("p_id_alumno_materia") int idAlumnoMateria);
}
