/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.time.LocalDate;
import java.util.List;
import modelo.Caseta;
import modelo.Cliente;
import modelo.Tiquete;
import modelo.Viaje;
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
                Singleton.getINSTANCIA().escribirCasetas();
                return;
            }
        }
        throw new RuntimeException("No se encuentra el Viaje que desea eliminar");
    }
    //////////////////////////////////////////////////////////////////////////////   

    public boolean validarCantidad(Viaje viaje, int cantidad) {
        int countTiquetes = 0;
        for (int i = 0; i < caseta.getTiquetes().size(); i++) {
            if (caseta.getTiquetes().get(i).getViaje().getId() == viaje.getId()) {
                countTiquetes += caseta.getTiquetes().get(i).getCantidad();
            }
        }
        if (cantidad <= viaje.getBus().getPuesto() - countTiquetes) {
            return true;
        }
        return false;
    }

    public int cuposDisponibles(Viaje viaje) {
        int countTiquetes = 0;
        for (int i = 0; i < caseta.getTiquetes().size(); i++) {
            if (caseta.getTiquetes().get(i).getViaje().getId() == viaje.getId()) {
                countTiquetes += caseta.getTiquetes().get(i).getCantidad();
            }
        }
        return viaje.getBus().getPuesto() - countTiquetes;
    }

    public boolean validarFecha(Viaje viaje, LocalDate fechaCompra) {
        for (int i = 0; i < caseta.getViajes().size(); i++) {
            if (caseta.getViajes().get(i).getId() == viaje.getId()) {
                if (caseta.getViajes().get(i).getFechaSalida().isAfter(fechaCompra)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void asignarPuntos(int puntos, Cliente cliente) {
        controlL.asignarPuntos(puntos, cliente);
    }

    public void eliminarPuntos(int idTiquete) {
        Cliente cliente = new Cliente("", 0, "", 0, "", "", "");
        Viaje viaje = new Viaje("", "", null,
                null, null, null, null,
                null, 0, 0);
        int cantidad = 0;
        for (int i = 0; i < caseta.getTiquetes().size(); i++) {
            if (caseta.getTiquetes().get(i).getId() == idTiquete) {
                cliente = caseta.getTiquetes().get(i).getCliente();
                viaje = caseta.getTiquetes().get(i).getViaje();
                cantidad = caseta.getTiquetes().get(i).getCantidad();

            }
        }
        int puntos = (int) ((cantidad * viaje.getValorUnidad()) / 10000) * 3;
        controlL.eliminarPuntos(puntos, cliente);
    }
}
