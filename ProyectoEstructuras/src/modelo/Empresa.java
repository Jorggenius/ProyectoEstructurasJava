/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author JORGE
 */
public class Empresa implements Serializable{
    private AdmiFlota admiFlota;
    private String Nombre;
    private int nit;

    public Empresa(String Nombre, int nit, AdmiFlota admiFlota) {
        this.Nombre = Nombre;
        this.nit = nit;
        this.admiFlota = admiFlota;
    }

    public AdmiFlota getAdmiFlota() {
        return admiFlota;
    }

    public void setAdmiFlota(AdmiFlota admiFlota) {
        this.admiFlota = admiFlota;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }
    
    
}
