/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import modelo.Caseta;
import modelo.Cliente;
import modelo.Devolucion;
import singleton.Singleton;
import util.Lista;

/**
 *
 * @author JORGE
 */
public class ControlHistorialDevoluciones {
    Caseta[][] casetas;
    Cliente cliente;

    public ControlHistorialDevoluciones(Cliente cliente) {
        casetas = Singleton.getINSTANCIA().getCasetas();
        this.cliente = cliente;
    }

    public Caseta[][] getCasetas() {
        return casetas;
    }

    public void setCasetas(Caseta[][] casetas) {
        this.casetas = casetas;
    }
    
    public Lista<Devolucion> obtenerDevoluciones(Cliente cliente){
        Lista<Devolucion> aux = new Lista<Devolucion>();
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                for (int k = 0; k < casetas[i][j].getEmpresa().getDevoluciones().size(); k++) {
                    if(casetas[i][j].getEmpresa().getDevoluciones().get(k).getCliente().getId() == cliente.getId()){
                        aux.add(casetas[i][j].getEmpresa().getDevoluciones().get(k));
                    }
                }
            }
        }
        return aux;
    }
}
