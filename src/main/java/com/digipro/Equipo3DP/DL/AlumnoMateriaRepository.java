package com.digipro.Equipo3DP.DL;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface AlumnoMateriaRepository extends JpaRepository<alumnomateria, Integer> {

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
        
    @Query("SELECT am FROM alumnomateria am WHERE idalumno.idalumno = :id")
    List<alumnomateria> getMateriaByIdAlumno(@Param("id") Integer id);
    
}
