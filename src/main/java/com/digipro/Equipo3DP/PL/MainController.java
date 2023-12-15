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

    @RequestMapping("/home")
    public String Home() {
        return "Bienvenida";
    }

    @RequestMapping("/alumno")
    public String home(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        String apiURL = "http://localhost:8080/DPAPI/getAllAlumnos";

        ResponseEntity<List<Alumno>> response = restTemplate.exchange(
                apiURL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Alumno>>() {
        });
        List<Alumno> alumnos = response.getBody();
        model.addAttribute("alumnos", alumnos);

        return "alumno";
    }

    @GetMapping("/alumno/{idalumno}")
    private String Form(@PathVariable int idalumno, Model model) {
        if (idalumno == 0) {
            model.addAttribute("alumno", new Alumno());
            return "alumno";
        } else {
            Optional<Alumno> alumno = alumnoRepository.findById(idalumno);
            if (alumno != null) {
                model.addAttribute("alumno", alumno);
            } else {
                model.addAttribute("No existe el alumno");
            }
        }
        return "alumno";
    }

    @PostMapping("alumno")
    public String Form(@ModelAttribute("alumno") Alumno alumno, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (alumno.getIdalumno() > 0) {
            String apiURL = "http://localhost:8080/DPAPI/updateAlumno" + alumno.getIdalumno();
            HttpEntity<Alumno> request = new HttpEntity<>(alumno, headers);
            ResponseEntity<Alumno> response = restTemplate.exchange(
                    apiURL,
                    HttpMethod.PUT,
                    request,
                    new ParameterizedTypeReference<Alumno>() {

            });
        } else {
            String apiURL = "http://localhost:8080/DPAPI/addAlumno";
            ResponseEntity<Alumno> response = restTemplate.exchange(
                    apiURL,
                    HttpMethod.POST,
                    new HttpEntity<>(alumno, headers),
                    new ParameterizedTypeReference<Alumno>() {
            });
        }

        List<Alumno> alumnos = alumnoRepository.findAll();
        model.addAttribute("alumnos", alumnos);

        return "redirect:/DP/alumno";
    }

    @GetMapping("/delete/{idalumno}")
    public String eliminar(@PathVariable int idalumno) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String apiURL = "http://localhost:8080/DPAPI/deleteAlumno/" + idalumno;
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<Void> response = restTemplate.exchange(
                apiURL,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<Void>() {
        });
        return "redirect:/DP/alumno";
    }

    @RequestMapping("/materia")
    public String materia(Model model) {
        return "materia";
    }

    @RequestMapping("/am")
    public String login(Model model) {
        return "alumnomateria";
    }

}
