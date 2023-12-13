/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digipro.Equipo3DP.DL;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author digis
 */
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
@Procedure(name = "AddAlumnoSP")
    void addAlumnoSP(
            @Param("p_nombre") String nombre,
            @Param("p_apellido_paterno") String apellidoPaterno,
            @Param("p_apellido_materno") String apellidoMaterno
    );
    
     @Procedure(name = "UpdateAlumnoSP")
    void updateAlumnoSP(
        @Param("p_id_alumno") Long idAlumno,
        @Param("p_nombre") String nombre,
        @Param("p_apellido_paterno") String apellidoPaterno,
        @Param("p_apellido_materno") String apellidoMaterno
    );
    
    @Procedure(name = "DeleteAlumnoSP")
    void deleteAlumnoSP(@Param("p_id_alumno") Long idAlumno);
    
    @Query(nativeQuery = true, value = "{call GetAllAlumnoSP(:p_cursor)}")
    List<Alumno> getAllAlumnosSP(@Param("p_cursor") List<Object[]> p_cursor);
    
    @Query(nativeQuery = true, value = "{call GetByIdAlumnoSP(:p_id_alumno, :p_cursor)}")
    List<Alumno> getByIdAlumnoSP(
        @Param("p_id_alumno") Long idAlumno,
        @Param("p_cursor") List<Object[]> p_cursor
    );

  
}


