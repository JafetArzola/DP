/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digipro.Equipo3DP.SL;

import com.digipro.Equipo3DP.DL.Alumno;
import com.digipro.Equipo3DP.DL.AlumnoRepository;
import com.digipro.Equipo3DP.DL.Materia;
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

    public MainRestController(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @GetMapping("/getAllAlumnos")
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }
    
    @PostMapping("/updateAlumno")
    public void updateAlumno(@RequestBody Alumno alumno){
        alumnoRepository.save(alumno);
    }

    

}
