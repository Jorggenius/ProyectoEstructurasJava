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
public class Empresa implements Serializable {

    private AdmiFlota admiFlota;
    private String Nombre;
    private int nit;
    private IList<Bus> buses;
    private IList<Viaje> viajes;
    private IList<Tiquete> tiquetes;
    private IList<Reserva> reservas;
    private IList<Devolucion> devoluciones;
    private IList<Notificacion> notificaciones;

    public Empresa(String Nombre, int nit, AdmiFlota admiFlota) {
        this.Nombre = Nombre;
        this.nit = nit;
        this.admiFlota = admiFlota;
        this.buses = new Lista<>();
        this.viajes = new Lista<>();
        this.tiquetes = new Lista<>();
        this.reservas = new Lista<>();
        this.devoluciones = new Lista<>();
        this.notificaciones = new Lista<>();
    }

    public IList<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(IList<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public IList<Devolucion> getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(IList<Devolucion> devoluciones) {
        this.devoluciones = devoluciones;
    }

    public IList<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(IList<Viaje> viajes) {
        this.viajes = viajes;
    }

    public IList<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(IList<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }

    public IList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(IList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public IList<Bus> getBuses() {
        return buses;
    }

    public void setBuses(IList<Bus> buses) {
        this.buses = buses;
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

    public String toString() {
        return Nombre;
    }
}
