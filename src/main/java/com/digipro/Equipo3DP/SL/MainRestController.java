/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digipro.Equipo3DP.SL;

import com.digipro.Equipo3DP.DL.Alumno;
import com.digipro.Equipo3DP.DL.alumnomateria;
import com.digipro.Equipo3DP.DL.AlumnoMateriaRepository;
import com.digipro.Equipo3DP.DL.AlumnoRepository;
import com.digipro.Equipo3DP.DL.Materia;
import com.digipro.Equipo3DP.DL.MateriaDAOImplementation;
import com.digipro.Equipo3DP.DL.MateriaRepository;
import com.digipro.Equipo3DP.DL.alumnomateria;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private AlumnoMateriaRepository alumnoMateriaRepository;
    private MateriaDAOImplementation materiaDAOImplementation;

    public MainRestController(AlumnoRepository alumnoRepository, MateriaRepository materiaRepository, AlumnoMateriaRepository alumnoMateriaRepository, MateriaDAOImplementation materiaDAOImplementation) {
        this.alumnoRepository = alumnoRepository;
        this.materiaRepository = materiaRepository;
        this.alumnoMateriaRepository = alumnoMateriaRepository;
        this.materiaDAOImplementation = materiaDAOImplementation;
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
    public void addAlumno(@RequestBody Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    //Servicio para guardar alumnos con 'id' distinto de 0
    @PostMapping("/updateAlumno/{idalumno}")
    public ResponseEntity<String> updateAlumno(@PathVariable int idalumno, @RequestBody Alumno updatedAlumno) {
        try {
            Alumno existingAlumno = alumnoRepository.findById(idalumno)
                    .orElseThrow(() -> new RuntimeException("No se encontró el alumno con ID: " + idalumno));

            existingAlumno.setNombre(updatedAlumno.getNombre());
            existingAlumno.setApellidopaterno(updatedAlumno.getApellidopaterno());
            existingAlumno.setApellidomaterno(updatedAlumno.getApellidomaterno());
            alumnoRepository.save(existingAlumno);

            return ResponseEntity.ok("Alumno actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el alumno: " + e.getMessage());
        }
    }

    //Servicio para eliminar registro mediante id
    @DeleteMapping("/deleteAlumno/{idalumno}")
    public void deleteAlumno(@PathVariable int idalumno) {
        alumnoRepository.deleteById(idalumno);
    }

    @GetMapping("/getAlumno/{id}")
    public ResponseEntity<?> getalumno(@PathVariable int id) {
        try {
            Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);

            if (optionalAlumno.isPresent()) {
                Alumno alumno = optionalAlumno.get();
                return ResponseEntity.ok(alumno);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el alumno con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener el alumno: " + e.getMessage());
        }
    }

//-----------------------------------------------------------------
    //Servicios para Materia
    @GetMapping("/getAllMaterias")
    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    //Servicio para guardar alumnos con 'id' iguales a 0
    @PostMapping("/addMateria")
    public void addMateria(@RequestBody Materia materia) {
        materiaRepository.save(materia);
    }

    @PostMapping("/updateMateria/{idmateria}")
    public ResponseEntity<String> updateMateria(@PathVariable int idmateria, @RequestBody Materia updatedMateria) {
        try {
            Materia existingMateria = materiaRepository.findById(idmateria)
                    .orElseThrow(() -> new RuntimeException("No se encontró la materia con ID: " + idmateria));

            existingMateria.setNombre(updatedMateria.getNombre());
            existingMateria.setCosto(updatedMateria.getCosto());
            materiaRepository.save(existingMateria);

            return ResponseEntity.ok("Materia actualizada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar la materia: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteMateria/{idmateria}")
    public void deleteMateria(@PathVariable int idmateria) {
        materiaRepository.deleteById(idmateria);
    }

    @GetMapping("/getMateria/{id}")
    public ResponseEntity<?> getMateria(@PathVariable int id) {
        try {
            Optional<Materia> optionalMateria = materiaRepository.findById(id);

            if (optionalMateria.isPresent()) {
                Materia materia = optionalMateria.get();
                return ResponseEntity.ok(materia);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la materia con ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener la materia: " + e.getMessage());
        }
    }

    
    
    //Logica para consumir Get All  SP 
    @GetMapping("/obtenerMaterias")
    public ResponseEntity<List<Materia>> obtenerMaterias() {
        List<Materia> materias = materiaRepository.obtenerMaterias();
        return new ResponseEntity<>(materias, HttpStatus.OK);
    }
    
//-----------------------------------------------------------------
    //Servicios para alumnomateria
    //Servicio para obtener a un alumno junto con todas sus materias
    @PostMapping("/getAlumnoMateria")
    public List<alumnomateria> getAlumnoMateria(@RequestBody alumnomateria alumnomateria) {
        return alumnoMateriaRepository.getMateriaByIdAlumno(alumnomateria.getIdalumno().getIdalumno());
    }

    //Servicio para añadir una materia a un alumno; donde idAlumnoMateria sea igual a '0'
    @PostMapping("/addAlumnoMateria")
    public void addAlumnoMateria(@RequestBody alumnomateria alumnomateria) {
        alumnoMateriaRepository.save(alumnomateria);
    }

    //Servicio para editar una materia registrada por un alumno; donde idAlumnoMateria sea diferente de '0'
    @PostMapping("/updateAlumnoMateria")
    public void updateAlumnoMateria(@RequestBody alumnomateria alumnomateria) {
        alumnoMateriaRepository.save(alumnomateria);
    }

    //Servicio para eliminar una materia registrada por el alumno
    @PostMapping("/deleteAlumnoMateria")
    public void deleteAlumnoMateria(@RequestBody alumnomateria alumnomateria) {
        alumnoMateriaRepository.delete(alumnomateria);
    }

}
