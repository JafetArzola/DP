/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digipro.Equipo3DP.DL;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import java.io.Serializable;

/**
 *
 * @author digis
 */
@NamedStoredProcedureQuery(name = "pruebaGetAll", procedureName = "pruebaGetAll", resultClasses = Alumno.class,
                               parameters = @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class, name = "result_cursor"))
@Entity
public class Alumno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idalumno;
    
    @Basic
    private String nombre;
    
    @Basic
    private String apellidopaterno;
    
    @Basic
    private String apellidomaterno;

    
    public Alumno(){
        
    }

    public Alumno(int idalumno, String nombre, String apellidopaterno, String apellidomaterno) {
        this.idalumno = idalumno;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
    }
    
    
    
    public Alumno(String nombre, String apellidopaterno, String apellidomaterno){
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
    }
    
    public Alumno(String nombre, String apellidopaterno){
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
    }
    
    public Alumno(int idalumno){
        this.idalumno = idalumno;
    }
    
    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }
    
    
    
}
