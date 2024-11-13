/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import modelo.Caseta;
import modelo.Cliente;
import modelo.Redencion;
import singleton.Singleton;
import util.Lista;

/**
 *
 * @author JORGE
 */
public class ControlHistorialRedenciones {
    ControlVistaTerminal controlT;
    Cliente cliente;
    Caseta[][] casetas;
    
    public ControlHistorialRedenciones(Cliente cliente) {
        this.cliente = cliente;
        casetas = Singleton.getINSTANCIA().getCasetas();
        controlT = new ControlVistaTerminal();
    }

    public Caseta[][] getCasetas() {
        return casetas;
    }

    public void setCasetas(Caseta[][] casetas) {
        this.casetas = casetas;
    }
    
    public Lista<Redencion> obtenerRedenciones(Cliente cliente){
        return controlT.obtenerRedenciones(cliente);
    }
    
}
