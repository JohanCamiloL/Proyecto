/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jonnhi
 */
public class Estudiante implements Serializable{

    private Integer codigo;
    private List<Grupo> cursando;

    public Estudiante() {
    }

    public Estudiante(Integer codigo, List<Grupo> cursando) {
        this.codigo = codigo;
        this.cursando = cursando;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<Grupo> getCursando() {
        return cursando;
    }

    public void setCursando(List<Grupo> cursando) {
        this.cursando = cursando;
    }

    
    
}
