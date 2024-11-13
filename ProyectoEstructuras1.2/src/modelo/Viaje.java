/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import util.IQueve;
import util.Queve;

/**
 *
 * @author JORGE
 */
public class Viaje implements Serializable{
    private String origen;
    private String destino;
    private LocalDate fechaCreacion;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private LocalDate fechaLLegada;
    private LocalTime horaLlegada;
    private Bus bus;
    private double valorUnidad;
    private int id;
    private IQueve<Tiquete> colaTiquetes;

    public Viaje(String origen, String destino, LocalDate fechaCreacion,LocalDate fechaSalida, LocalTime horaSalida, LocalDate fechaLLegada, LocalTime horaLlegada, Bus bus, double valorUnidad,int id) {
        this.origen = origen;
        this.destino = destino;
        this.fechaCreacion = fechaCreacion;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.fechaLLegada = fechaLLegada;
        this.horaLlegada = horaLlegada;
        this.bus = bus;
        this.valorUnidad = valorUnidad;
        this.id = id;
        this.colaTiquetes = new Queve<>();
    }

    public IQueve<Tiquete> getColaTiquetes() {
        return colaTiquetes;
    }

    public void setColaTiquetes(IQueve<Tiquete> colaTiquetes) {
        this.colaTiquetes = colaTiquetes;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDate getFechaLLegada() {
        return fechaLLegada;
    }

    public void setFechaLLegada(LocalDate fechaLLegada) {
        this.fechaLLegada = fechaLLegada;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public double getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(double valorUnidad) {
        this.valorUnidad = valorUnidad;
    }
    
    public String toString(){
        return origen+" - "+destino+" / №Puestos: " + bus.getPuesto() +" / Salida: " + fechaSalida ;
    }
    
    
    
    
}
