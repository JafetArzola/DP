/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digipro.Equipo3DP.PL;

import com.digipro.Equipo3DP.DL.Alumno;
import com.digipro.Equipo3DP.DL.AlumnoDAOImplementation;
import com.digipro.Equipo3DP.DL.AlumnoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/DP")
public class MainController {

    private AlumnoDAOImplementation alumnoDAOImplementation;

    @Autowired
    public MainController(AlumnoDAOImplementation alumnoDAOImplementation) {
        this.alumnoDAOImplementation = alumnoDAOImplementation;
    }

    @GetMapping("/home")
    public String Home() {
        return "Bienvenida";
    }

    @GetMapping("/alumno")
    public String alumno(Model model) {
        return "alumno";
    }

    @GetMapping("/materia")
    public String materia(Model model) {
        return "materia";
    }

    @GetMapping("/AlumnoSP")
    @Transactional
    public String alumnoSP(Model model) {
        List<Alumno> alumnos = alumnoDAOImplementation.GetAllAlumnoSP();
        model.addAttribute("alumnos", alumnos);
        return "alumnoSP";
    }
    @GetMapping("/AlumnoSP{idalumno}")
    @Transactional
    public String Add(@PathVariable int idalumno, Model model) {
        if (idalumno == 0) {
            model.addAttribute("alumno", new Alumno());
            return "alumnoSP";
        } else {
            List<Alumno> alumno = alumnoDAOImplementation.getByIdAlumnoSP(idalumno);
            model.addAttribute("alumno", alumno);
            return "alumnoSP";
        }
    }
    @PostMapping("/AlumnoSP")
    @Transactional
    public String Update(@ModelAttribute("alumno") Alumno alumno, Model model) {
        int idalumno = alumnoDAOImplementation.addAlumnoSP(alumno, alumno.getNombre(), alumno.getApellidopaterno(), alumno.getApellidomaterno());
        if (idalumno > 0) {
            return "alumnoSP";
        } else {
            model.addAttribute("error");
            return "redirect:/DP/AlumnoSP";
        }
    }

    @GetMapping("/MateriaSP")
    public String MateriaSP() {
        return "MateriaSP";
    }

    @GetMapping("/AlumnoMateria")
    public String AlumnoMateria(Model model) {
        return "alumnomateria";
    }

    @GetMapping("/AlumnoMateriaSP")
    public String AlumnoMateriaSP() {
        return "AlumnoMateriaSP";
    }
}
