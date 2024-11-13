/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import excepcion.IdExiste;
import java.time.LocalDate;
import java.util.List;
import modelo.Caseta;
import modelo.Cliente;
import modelo.Notificacion;
import modelo.Redencion;
import modelo.Reserva;
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

    public void guardarTiquete(Tiquete tiquete) throws IdExiste {
        Tiquete aux = buscarTiquete(tiquete.getId());
        if (aux == null) {
            caseta.getEmpresa().getTiquetes().add(tiquete);
            Singleton.getINSTANCIA().escribirCasetas();
            return;
        }
        throw new IdExiste();
    }

    public Tiquete buscarTiquete(int id) {
        for (int i = 0; i < caseta.getEmpresa().getTiquetes().size(); i++) {
            if (caseta.getEmpresa().getTiquetes().get(i).getId() == (id)) {
                return caseta.getEmpresa().getTiquetes().get(i);
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
        for (int i = 0; i < caseta.getEmpresa().getTiquetes().size(); i++) {
            if (caseta.getEmpresa().getTiquetes().get(i).getId() == (id)) {
                caseta.getEmpresa().getTiquetes().remove(i);
                Singleton.getINSTANCIA().escribirCasetas();
                return;
            }
        }
        throw new RuntimeException("No se encuentra el Viaje que desea eliminar");
    }
////////////////////////////////////////////////////////////////////////////////   

    public boolean validarCantidad(Viaje viaje, int cantidad) {
        int countTiquetes = 0;
        for (int i = 0; i < caseta.getEmpresa().getTiquetes().size(); i++) {
            if (caseta.getEmpresa().getTiquetes().get(i).getViaje().getId() == viaje.getId()) {
                countTiquetes++;
            }
        }
        for (int i = 0; i < caseta.getEmpresa().getReservas().size(); i++) {
            if (caseta.getEmpresa().getReservas().get(i).getViaje().getId() == viaje.getId()) {
                countTiquetes++;
            }
        }
        if (cantidad <= viaje.getBus().getPuesto() - countTiquetes) {
            return true;
        }
        return false;
    }

    public int cuposDisponibles(Viaje viaje) {
        int countTiquetes = 0;
        for (int i = 0; i < caseta.getEmpresa().getTiquetes().size(); i++) {
            if (caseta.getEmpresa().getTiquetes().get(i).getViaje().getId() == viaje.getId()) {
                countTiquetes++;
            }
        }
        for (int i = 0; i < caseta.getEmpresa().getReservas().size(); i++) {
            if (caseta.getEmpresa().getReservas().get(i).getViaje().getId() == viaje.getId()) {
                countTiquetes++;
            }
        }
        return viaje.getBus().getPuesto() - countTiquetes;
    }

    public boolean validarFecha(Viaje viaje, LocalDate fechaCompra) {
        for (int i = 0; i < caseta.getEmpresa().getViajes().size(); i++) {
            if (caseta.getEmpresa().getViajes().get(i).getId() == viaje.getId()) {
                if (caseta.getEmpresa().getViajes().get(i).getFechaSalida().isAfter(fechaCompra)) {
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

    public void guardarNotifs(Notificacion notif) {
        caseta.getEmpresa().getNotificaciones().add(notif);
        controlL.guardarNotifs(notif);
    }

    public void guardarRedencion(Tiquete tiquete) throws IdExiste {
        Redencion redencion = new Redencion(tiquete.getViaje(),
                tiquete.getCliente(), tiquete.getFechaCompra(),
                numeroIdRedencion());

        Redencion aux = buscarRedncion(redencion.getId());
        if (aux == null) {
            caseta.getEmpresa().getRedenciones().add(redencion);
            Singleton.getINSTANCIA().escribirCasetas();
            return;
        }
        throw new IdExiste();
    }

    public Redencion buscarRedncion(int id) {
        for (int i = 0; i < caseta.getEmpresa().getRedenciones().size(); i++) {
            if (caseta.getEmpresa().getRedenciones().get(i).getId() == (id)) {
                return caseta.getEmpresa().getRedenciones().get(i);
            }
        }
        return null;
    }

    public void interaccionCola(Tiquete tiquete, int cuposDisponibles) {
        if (cuposDisponibles != 0) {
            for (int i = 0; i < caseta.getEmpresa().getViajes().size(); i++) {
                if (caseta.getEmpresa().getViajes().get(i).getId() == tiquete.getViaje().getId()) {
                    for (int j = 0; j < cuposDisponibles; j++) {
                        if (!caseta.getEmpresa().getViajes().get(i).getColaTiquetes().isEmpty()) {
                            Tiquete aux = caseta.getEmpresa().getViajes().get(i).getColaTiquetes().deQueve();
                            Reserva reserva = new Reserva(aux.getViaje(),
                                    aux.getCantidad(), aux.getCliente(),
                                    aux.getFechaCompra(), aux.getId());
                            caseta.getEmpresa().getReservas().add(reserva);
                        }
                    }
                }
            }
        }

    }

    public int numeroIdRedencion() {
        return (int) (Math.random() * 899999999) + 1;
    }

    public void descontarPuntos(Cliente cliente, int cantidad) {
        controlL.eliminarPuntos(90 * cantidad, cliente);
    }
}
