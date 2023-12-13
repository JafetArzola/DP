/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digipro.Equipo3DP.SL;

import com.digipro.Equipo3DP.DL.Alumno;
import com.digipro.Equipo3DP.DL.AlumnoRepository;
import com.digipro.Equipo3DP.DL.Materia;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/DPAPI")
public class MainRestController {

    private AlumnoRepository alumnoRepository;
    private EntityManager entityManager;
    
    public MainRestController(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }
    

    //Servicio Get All
    @GetMapping("/getAllAlumnos")
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }
    
    //Servicio para guardar alumnos con 'id' iguales a 0
    @PostMapping("/addAlumno")
    public void addAlumno(@RequestBody Alumno alumno){
        alumnoRepository.save(alumno);
    }
    
    //Servicio para guardar alumnos con 'id' distinto de 0
    @PostMapping("/updateAlumno")
    public void updateAlumno(@RequestBody Alumno alumno){
        alumnoRepository.save(alumno);
    }

    

}
