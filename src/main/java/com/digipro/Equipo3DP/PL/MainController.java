/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digipro.Equipo3DP.PL;

import com.digipro.Equipo3DP.DL.Alumno;
import com.digipro.Equipo3DP.DL.AlumnoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    private AlumnoRepository alumnoRepository;

    public MainController(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
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
    
    @GetMapping("/AlumnoMateria")
    public String AlumnoMateria(Model model) {
        return "alumnomateria";
    }
}
