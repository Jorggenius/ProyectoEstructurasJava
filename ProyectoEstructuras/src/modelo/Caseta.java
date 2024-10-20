/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import util.IList;
import util.Lista;

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
    private IList<Bus> buses;
    private IList<Viaje> viajes;
    private IList<Tiquete> tiquetes;

    public Caseta(AdmiFlota admiFlota, Empresa empresa, double arrendamiento, int plazas) {
        this.admiFlota = admiFlota;
        this.empresa = empresa;
        this.arrendamiento = arrendamiento;
        this.plazas = plazas;
        this.enUso = false;
        this.buses = new Lista<>();
        this.viajes = new Lista<>();
        this.tiquetes = new Lista<>();
    }

    public IList<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(IList<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }

    public IList<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(IList<Viaje> viajes) {
        this.viajes = viajes;
    }

    public IList<Bus> getBuses() {
        return buses;
    }

    public void setBuses(IList<Bus> buses) {
        this.buses = buses;
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
