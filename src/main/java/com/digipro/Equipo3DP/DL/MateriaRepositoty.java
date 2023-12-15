package com.digipro.Equipo3DP.DL;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface MateriaRepositoty extends JpaRepository<Materia, Integer> {

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
