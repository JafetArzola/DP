/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digipro.Equipo3DP.DL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author digis
 */
@Entity
public class alumnomateria implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idalumnomateria;
    
    @JoinColumn(name = "idalumno")
    @ManyToOne
    private Alumno idalumno;
    
    @JoinColumn(name = "idmateria")
    @ManyToOne
    private Materia idmateria;
    
    
    
     public alumnomateria(){
        
    }

    public Alumno getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Alumno idalumno) {
        this.idalumno = idalumno;
    }

    public Materia getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Materia idmateria) {
        this.idmateria = idmateria;
    }

    public int getIdalumnomateria() {
        return idalumnomateria;
    }

    public void setIdalumnomateria(int idalumnomateria) {
        this.idalumnomateria = idalumnomateria;
    }

   

}
