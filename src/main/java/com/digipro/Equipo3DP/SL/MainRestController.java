/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digipro.Equipo3DP.SL;

import com.digipro.Equipo3DP.DL.Alumno;
import com.digipro.Equipo3DP.DL.AlumnoRepository;
import com.digipro.Equipo3DP.DL.Materia;
import com.digipro.Equipo3DP.DL.MateriaRepository;
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
    private MateriaRepository materiaRepository;
    
    public MainRestController(AlumnoRepository alumnoRepository, MateriaRepository materiaRepository) {
        this.alumnoRepository = alumnoRepository;
        this.materiaRepository = materiaRepository;
    }
    
//-----------------------------------------------------------------
    
    //Servicios para ALumno
    
    
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
    
    //Servicio para eliminar registro mediante id
    @PostMapping("/deleteAlumno")
    public void deleteAlumno(@RequestBody Alumno alumno){
        alumnoRepository.deleteById(alumno.getIdalumno());
    }
    
    
//-----------------------------------------------------------------
    
    //Servicios para Materia
    
    @GetMapping("/getAllMaterias")
    public List<Materia> getAllMaterias(){
        return materiaRepository.findAll();
    }
    
    //Servicio para guardar alumnos con 'id' iguales a 0
    @PostMapping("/addMateria")
    public void addMateria(@RequestBody Materia materia){
        materiaRepository.save(materia);
    }
    
    //Servicio para guardar alumnos con 'id' distinto de 0
    @PostMapping("/updateMateria")
    public void updateMateria(@RequestBody Materia materia){
        materiaRepository.save(materia);
    }
    
    //Servicio para eliminar registro mediante id
    @PostMapping("/deleteMateria")
    public void deleteMateria(@RequestBody Materia materia){
        materiaRepository.deleteById(materia.getIdmateria());
    }
    

}
