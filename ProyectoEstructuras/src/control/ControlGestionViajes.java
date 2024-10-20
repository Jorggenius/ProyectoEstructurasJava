/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import modelo.Caseta;
import modelo.Viaje;
import singleton.Singleton;

/**
 *
 * @author JORGE
 */
public class ControlGestionViajes {

    Caseta caseta;

    public ControlGestionViajes(Caseta caseta) {
        this.caseta = caseta;
    }

    public Caseta getCaseta() {
        return caseta;
    }

    public void setCaseta(Caseta caseta) {
        this.caseta = caseta;
    }

    public void guardarViaje(Viaje viaje) throws RuntimeException {
        Viaje aux = buscarViaje(viaje.getId());
        if (aux == null) {
            caseta.getViajes().add(viaje);
            Singleton.getINSTANCIA().escribirCasetas();
            return;
        }
        throw new RuntimeException("El id ya esta en uso");
    }

    public Viaje buscarViaje(int id) {
        for (int i = 0; i < caseta.getViajes().size(); i++) {
            if (caseta.getViajes().get(i).getId() == (id)) {
                return caseta.getViajes().get(i);
            }
        }
        return null;
    }

    public void editarViaje(Viaje viaje) throws RuntimeException {
        Viaje aux = buscarViaje(viaje.getId());
        if (aux != null) {
//            aux.setNombre(viaje.getNombre());
            return;
        }
        throw new RuntimeException("No se encuentra el Viaje que desea editar");
    }

    public void eliminarViaje(int id) throws RuntimeException {
        for (int i = 0; i < caseta.getViajes().size(); i++) {
            if (caseta.getViajes().get(i).getId() == (id)) {
                caseta.getViajes().remove(i);
                return;
            }
        }
        throw new RuntimeException("No se encuentra el Viaje que desea eliminar");
    }
}
