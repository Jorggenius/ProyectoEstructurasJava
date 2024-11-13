/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.List;
import util.IList;
import util.Lista;

/**
 *
 * @author JORGE
 */
public class Cliente extends Usuario{
    private int puntos;
    private int puntosRedimidos;
    private IList<Notificacion> notificaciones;

    public Cliente(String nombre, int id, String contraseña, int edad, String correo, String telefono, String direccion) {
        super(nombre, id, contraseña, edad, correo, telefono, direccion);
        this.puntos = 0;
        this.puntosRedimidos = 0;
        this.notificaciones = new Lista<>();
    }

    public int getPuntosRedimidos() {
        return puntosRedimidos;
    }

    public void setPuntosRedimidos(int puntosRedimidos) {
        this.puntosRedimidos = puntosRedimidos;
    }
    
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public IList<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(IList<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
    
    
}
