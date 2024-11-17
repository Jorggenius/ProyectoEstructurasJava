/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author JORGE
 */
public class Devolucion implements Serializable{

    private Viaje viaje;
    private int cantidad;
    private Cliente cliente;
    private LocalDate fechaDevolucion;
    private int id;

    public Devolucion(Viaje viaje, int cantidad, Cliente cliente, LocalDate fechaDevolucion, int id) {
        this.viaje = viaje;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.fechaDevolucion = fechaDevolucion;
        this.id = id;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaCompra() {
        return fechaDevolucion;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaDevolucion = fechaCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
