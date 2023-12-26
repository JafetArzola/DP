/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digipro.Equipo3DP.DL;

import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
//import jakarta.transaction.Transactional;
import java.sql.ResultSet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
@Procedure(name = "ADDALUMNOSP")
    int addAlumnoSP(
            Alumno alumno,
            @Param("p_nombre") String nombre,
            @Param("p_apellido_paterno") String apellidoPaterno,
            @Param("p_apellido_materno") String apellidoMaterno
    );

    @Procedure(name = "UpdateAlumnoSP")
    void updateAlumnoSP(
            @Param("p_id_alumno") int idAlumno,
            @Param("p_nombre") String nombre,
            @Param("p_apellido_paterno") String apellidoPaterno,
            @Param("p_apellido_materno") String apellidoMaterno
    );

    @Procedure(name = "DeleteAlumnoSP")
    void deleteAlumnoSP(@Param("p_id_alumno") Long idAlumno);

    @Procedure(name = "GetAllAlumnoSP", refCursor = true)
    List<Alumno> GetAllAlumnoSP();

    @Procedure(name = "GetByIdAlumnoSP")
    List<Alumno> getByIdAlumnoSP(@Param("p_id_alumno") int idAlumno);
}
