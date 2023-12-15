/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digipro.Equipo3DP.PL;

import jakarta.persistence.Entity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/DP")
public class MainController {

    @GetMapping("/home")
    public String Home() {
        return "Bienvenida";
    }

    @GetMapping("/Materia")
    public String Materia() {
        return "Materia";
    }
    
    @GetMapping("/AlumnoMateria")
    public String AlumnoMateria() {
        return "AlumnoMateria";
    }
}
