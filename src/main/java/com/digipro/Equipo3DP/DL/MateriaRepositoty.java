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

    @Query(nativeQuery = true, value = "{call UpdateMateriaSP(:p_id_materia, :p_nombre, :p_costo)}")
    void updateMateriaSP(
            @Param("p_id_materia") Long idMateria,
            @Param("p_nombre") String nombre,
            @Param("p_costo") Double costo
    );

    @Query(nativeQuery = true, value = "{call DeleteMateriaSP(:p_id_materia)}")
    void deleteMateriaSP(@Param("p_id_materia") Long idMateria);

    @Query(nativeQuery = true, value = "{call GetAllMateriaSP(:p_cursor)}")
    List<Materia> getAllMateriasSP(List<Object[]> p_cursor);

    @Query(nativeQuery = true, value = "{call GetByIdMateriaSP(:p_id_materia, :p_cursor)}")
    List<Materia> getByIdMateriaSP(
            @Param("p_id_materia") Long idMateria,
            @Param("p_cursor") List<Object[]> p_cursor
    );
}
