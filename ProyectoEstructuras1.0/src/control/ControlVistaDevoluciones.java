/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import modelo.Caseta;
import modelo.Cliente;
import modelo.Devolucion;
import modelo.Notificacion;
import modelo.Reserva;
import modelo.Tiquete;
import modelo.Viaje;
import singleton.Singleton;

/**
 *
 * @author JORGE
 */
public class ControlVistaDevoluciones {

    ControlLogin controlL;
    Caseta caseta;

    public ControlVistaDevoluciones(Caseta caseta) {
        controlL = new ControlLogin();
        this.caseta = caseta;
    }

    public Caseta getCaseta() {
        return caseta;
    }

    public void setCaseta(Caseta caseta) {
        this.caseta = caseta;
    }

    public Tiquete obtenerTiquete(int id) {
        for (int i = 0; i < caseta.getEmpresa().getTiquetes().size(); i++) {
            if (caseta.getEmpresa().getTiquetes().get(i).getId() == id) {
                return caseta.getEmpresa().getTiquetes().get(i);
            }
        }
        return null;
    }

    public void guardarDevolucion(Devolucion devolucion) throws RuntimeException {
        Devolucion aux = buscarDevolucion(devolucion.getId());
        if (aux == null) {
            caseta.getEmpresa().getDevoluciones().add(devolucion);
            Singleton.getINSTANCIA().escribirCasetas();
            return;
        }
        throw new RuntimeException("El id ya esta en uso");
    }

    public Devolucion buscarDevolucion(int id) {
        for (int i = 0; i < caseta.getEmpresa().getDevoluciones().size(); i++) {
            if (caseta.getEmpresa().getDevoluciones().get(i).getId() == (id)) {
                return caseta.getEmpresa().getDevoluciones().get(i);
            }
        }
        return null;
    }
    
        public void eliminarTiquete(int id) throws RuntimeException {
        for (int i = 0; i < caseta.getEmpresa().getTiquetes().size(); i++) {
            if (caseta.getEmpresa().getTiquetes().get(i).getId() == (id)) {
                caseta.getEmpresa().getTiquetes().remove(i);
                Singleton.getINSTANCIA().escribirCasetas();
                return;
            }
        }
        throw new RuntimeException("No se encuentra el Viaje que desea eliminar");
    }
    
        public void eliminarPuntos(int idTiquete) {
        Cliente cliente = new Cliente("", 0, "", 0, "", "", "");
        Viaje viaje = new Viaje("", "", null,
                null, null, null, null,
                null, 0, 0);
        int cantidad = 0;
        for (int i = 0; i < caseta.getEmpresa().getTiquetes().size(); i++) {
            if (caseta.getEmpresa().getTiquetes().get(i).getId() == idTiquete) {
                cliente = caseta.getEmpresa().getTiquetes().get(i).getCliente();
                viaje = caseta.getEmpresa().getTiquetes().get(i).getViaje();
                cantidad = caseta.getEmpresa().getTiquetes().get(i).getCantidad();

            }
        }
        int puntos = (int) ((viaje.getValorUnidad()) / 10000) * 3;
        controlL.eliminarPuntos(puntos, cliente);
    }
        
    public void guardarNotifs(Notificacion notif){
        caseta.getEmpresa().getNotificaciones().add(notif);
        controlL.guardarNotifs(notif);
    }
}
