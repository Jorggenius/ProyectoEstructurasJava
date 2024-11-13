/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import modelo.Caseta;
import modelo.Cliente;
import modelo.Reserva;
import modelo.Tiquete;
import singleton.Singleton;

/**
 *
 * @author JORGE
 */
public class ControlValidarReservas {
    ControlLogin controlL;
    Caseta caseta;

    public ControlValidarReservas(Caseta caseta) {
        controlL = new ControlLogin();
        this.caseta = caseta;
    }

    public Caseta getCaseta() {
        return caseta;
    }

    public void setCaseta(Caseta caseta) {
        this.caseta = caseta;
    }
    
    public Reserva obtenerReserva(int id){
        for (int i = 0; i < caseta.getEmpresa().getReservas().size(); i++) {
            if(caseta.getEmpresa().getReservas().get(i).getId() == id){
                return caseta.getEmpresa().getReservas().get(i);
            }
        }
        return null;
    }
    public void EliminarReserva(int id){
        for (int i = 0; i < caseta.getEmpresa().getReservas().size(); i++) {
            if(caseta.getEmpresa().getReservas().get(i).getId() == id){
                caseta.getEmpresa().getReservas().remove(i);
                return;
            }
        }
    }
    
       public void guardarTiquete(Tiquete tiquete) throws RuntimeException {
        Tiquete aux = buscarTiquete(tiquete.getId());
        if (aux == null) {
            caseta.getEmpresa().getTiquetes().add(tiquete);
            Singleton.getINSTANCIA().escribirCasetas();
            return;
        }
        throw new RuntimeException("El id ya esta en uso");
    }

    public Tiquete buscarTiquete(int id) {
        for (int i = 0; i < caseta.getEmpresa().getTiquetes().size(); i++) {
            if (caseta.getEmpresa().getTiquetes().get(i).getId() == (id)) {
                return caseta.getEmpresa().getTiquetes().get(i);
            }
        }
        return null;
    }
    
    public void asignarPuntos(int puntos, Cliente cliente) {
        controlL.asignarPuntos(puntos, cliente);
    }
}
