/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digipro.Equipo3DP.DL;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author digis
 */
public interface MateriaRepository extends JpaRepository<Materia, Integer>{
    @Procedure(name = "AddMateriaSP")
    void addMateriaSP(
            @Param("p_nombre") String nombre,
            @Param("p_costo") Double costo
    );

    @Procedure(name = "UpdateMateriaSP")
    void updateMateriaSP(
            @Param("p_id_materia") int idMateria,
            @Param("p_nombre") String nombre,
            @Param("p_costo") Double costo
    );

    @Procedure(name = "DeleteMateriaSP")
    void deleteMateriaSP(@Param("p_id_materia") int idMateria);

    @Procedure(name = "GetAllMateriaSP", outputParameterName = "p_cursor")
    void getAllMateriaSP();

    @Procedure(name = "GetByIdMateriaSP", outputParameterName = "p_cursor")
    void getByIdMateriaSP(@Param("p_id_materia") int idMateria);
}
