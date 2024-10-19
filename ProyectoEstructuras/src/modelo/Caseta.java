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
public class Caseta implements Serializable{
    private AdmiFlota admiFlota;
    private Empresa empresa;
    private double arrendamiento;
    private int plazas;
    private boolean enUso;

    public Caseta(AdmiFlota admiFlota, Empresa empresa, double arrendamiento, int plazas) {
        this.admiFlota = admiFlota;
        this.empresa = empresa;
        this.arrendamiento = arrendamiento;
        this.plazas = plazas;
        this.enUso = false;
    }

    public boolean isEnUso() {
        return enUso;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }

    public AdmiFlota getAdmiFlota() {
        return admiFlota;
    }

    public void setAdmiFlota(AdmiFlota admiFlota) {
        this.admiFlota = admiFlota;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public double getArrendamiento() {
        return arrendamiento;
    }

    public void setArrendamiento(double arrendamiento) {
        this.arrendamiento = arrendamiento;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
    
}
