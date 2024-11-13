/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import modelo.Cliente;
import modelo.Notificacion;

/**
 *
 * @author JORGE
 */
public class ControlNotificaciones {
    Cliente cliente;

    public ControlNotificaciones(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    public Notificacion conseguirNotif(int id){
        for (int i = 0; i < cliente.getNotificaciones().size(); i++) {
            if(cliente.getNotificaciones().get(i).getId() == id){
                return cliente.getNotificaciones().get(i);
            }
        }
        return null;
    }
}
