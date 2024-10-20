/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import modelo.Caseta;
import modelo.Cliente;
import modelo.Tiquete;
import singleton.Singleton;
import util.Lista;

/**
 *
 * @author JORGE
 */
public class ControlVentaTiquetes {

    Caseta caseta;
    ControlLogin controlL;

    public ControlVentaTiquetes(Caseta caseta) {
        this.caseta = caseta;
        controlL = new ControlLogin();
    }

    public Caseta getCaseta() {
        return caseta;
    }

    public void setCaseta(Caseta caseta) {
        this.caseta = caseta;
    }

    public Lista<Cliente> obtenerClientes() {
        return controlL.obtenerClientes();
    }

    public void guardarTiquete(Tiquete tiquete) throws RuntimeException {
        Tiquete aux = buscarTiquete(tiquete.getId());
        if (aux == null) {
            caseta.getTiquetes().add(tiquete);
            Singleton.getINSTANCIA().escribirCasetas();
            return;
        }
        throw new RuntimeException("El id ya esta en uso");
    }

    public Tiquete buscarTiquete(int id) {
        for (int i = 0; i < caseta.getTiquetes().size(); i++) {
            if (caseta.getTiquetes().get(i).getId() == (id)) {
                return caseta.getTiquetes().get(i);
            }
        }
        return null;
    }

    public void editarViaje(Tiquete tiquete) throws RuntimeException {
        Tiquete aux = buscarTiquete(tiquete.getId());
        if (aux != null) {
//            aux.setNombre(viaje.getNombre());
            return;
        }
        throw new RuntimeException("No se encuentra el Tiquete que desea editar");
    }

    public void eliminarTiquete(int id) throws RuntimeException {
        for (int i = 0; i < caseta.getTiquetes().size(); i++) {
            if (caseta.getTiquetes().get(i).getId() == (id)) {
                caseta.getTiquetes().remove(i);
                return;
            }
        }
        throw new RuntimeException("No se encuentra el Viaje que desea eliminar");
    }
}
