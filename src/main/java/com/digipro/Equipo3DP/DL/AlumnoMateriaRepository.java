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
    
    @Query(nativeQuery = true, value = "{call UpdateAlumnoMateriaSP(:p_id_alumno_materia, :p_id_alumno, :p_id_materia)}")
    void updateAlumnoMateriaSP(
        @Param("p_id_alumno_materia") Long idAlumnoMateria,
        @Param("p_id_alumno") Long idAlumno,
        @Param("p_id_materia") Long idMateria
    );
    
    @Query(nativeQuery = true, value = "{call DeleteAlumnoMateriaSP(:p_id_alumno_materia)}")
    void deleteAlumnoMateriaSP(@Param("p_id_alumno_materia") Long idAlumnoMateria);
}
