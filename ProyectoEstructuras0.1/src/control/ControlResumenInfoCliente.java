/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import modelo.Cliente;
import modelo.Tiquete;
import modelo.Viaje;
import util.Lista;

/**
 *
 * @author JORGE
 */
public class ControlResumenInfoCliente {
    Cliente cliente;
    ControlVistaTerminal controlVT;

    public ControlResumenInfoCliente(Cliente cliente) {
        this.cliente = cliente;
        controlVT = new ControlVistaTerminal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Lista<Tiquete> obtenerTiquetes(Cliente cliente){
        return controlVT.obtenerTiquetes(cliente);
    }
    
    public Lista<Viaje> obtenerViajes(){
        Lista<Viaje> viajesCliente = new Lista<>();
        for (int i = 0; i < obtenerTiquetes(cliente).size(); i++) {
            viajesCliente.add(obtenerTiquetes(cliente).get(i).getViaje());
        }
        return viajesCliente;
    }
}
