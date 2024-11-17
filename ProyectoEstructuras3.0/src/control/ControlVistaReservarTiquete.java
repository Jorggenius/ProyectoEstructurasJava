/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import excepcion.IdExiste;
import java.time.LocalDate;
import modelo.Caseta;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Notificacion;
import modelo.Reserva;
import modelo.Viaje;
import singleton.Singleton;
import util.Lista;

/**
 *
 * @author JORGE
 */
public class ControlVistaReservarTiquete {

    Caseta[][] casetas;
    ControlLogin controlL;

    public ControlVistaReservarTiquete() {
        casetas = Singleton.getINSTANCIA().getCasetas();
        controlL = new ControlLogin();
    }

    public Caseta[][] getCasetas() {
        return casetas;
    }

    public void setCasetas(Caseta[][] casetas) {
        this.casetas = casetas;
    }

    public Lista<Caseta> obtenerCasetas() {
        Lista<Caseta> aux = new Lista<>();
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                if (!casetas[i][j].getEmpresa().getNombre().equals("")) {
                    aux.add(casetas[i][j]);
                }
            }
        }
        return aux;
    }

    public Lista<Viaje> obtenerViajes() {
        Lista<Viaje> aux = new Lista<>();
        for (int i = 0; i < obtenerCasetas().size(); i++) {
            for (int j = 0; j < obtenerCasetas().get(i).getEmpresa()
                    .getViajes().size(); j++) {
                if (obtenerCasetas().get(i).getEmpresa().getViajes()// this (if) allow me to control that only will be look 
                        .get(j).getFechaSalida()///////////////////// the viajes that are after of actual date.
                        .isAfter(LocalDate.now())) {
                    aux.add(obtenerCasetas().get(i)
                            .getEmpresa().getViajes().get(j));
                }
            }
        }
        return aux;
    }

    public Viaje conseguirViaje(int id) {
        for (int i = 0; i < obtenerViajes().size(); i++) {
            if (obtenerViajes().get(i).getId() == id) {
                return obtenerViajes().get(i);
            }
        }
        return null;
    }

    public void guardarReserva(Reserva reserva) throws IdExiste {
        Reserva aux = buscarReserva(reserva);
        if (aux == null) {
            for (int i = 0; i < casetas.length; i++) {
                for (int j = 0; j < casetas[i].length; j++) {
                    for (int k = 0; k < casetas[i][j].getEmpresa().getViajes().size(); k++) {
                        if (casetas[i][j].getEmpresa().getViajes().get(k).getId() == reserva.getViaje().getId()) {
                            casetas[i][j].getEmpresa().getReservas().add(reserva);
                            Singleton.getINSTANCIA().escribirCasetas();
                            return;
                        }
                    }
                }
            }
        }
        throw new IdExiste();
    }

    public Reserva buscarReserva(Reserva reserva) {
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                for (int k = 0; k < casetas[i][j].getEmpresa().getReservas().size(); k++) {
                    if (casetas[i][j].getEmpresa().getReservas().get(k).getId() == reserva.getId()) {
                        return casetas[i][j].getEmpresa().getReservas().get(k);
                    }
                }
            }
        }
        return null;
    }

//    public void editarViaje(Tiquete tiquete) throws RuntimeException {
//        Tiquete aux = buscarTiquete(tiquete.getId());
//        if (aux != null) {
////            aux.setNombre(viaje.getNombre());
//            return;
//        }
//        throw new RuntimeException("No se encuentra el Tiquete que desea editar");
//    }
//
    public void eliminarReserva(int id) throws RuntimeException {
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                for (int k = 0; k < casetas[i][j].getEmpresa().getReservas().size(); k++) {
                    if (casetas[i][j].getEmpresa().getReservas().get(k).getId() == id) {
                        casetas[i][j].getEmpresa().getReservas().remove(k);
                        Singleton.getINSTANCIA().escribirCasetas();
                        return;
                    }
                }
            }
        }
        throw new RuntimeException("No se encuentra el Viaje que desea eliminar");
    }

    ////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    public Lista<Reserva> reservasCliente(Cliente cliente) {
        Lista<Reserva> aux = new Lista<>();
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                for (int k = 0; k < casetas[i][j].getEmpresa().getReservas().size(); k++) {
                    if (casetas[i][j].getEmpresa().getReservas().get(k).getCliente().getId() == cliente.getId()) {
                        aux.add(casetas[i][j].getEmpresa().getReservas().get(k));
                    }
                }
            }
        }
        return aux;
    }

    public boolean validarCantidad(Viaje viaje, int cantidad) {
        int countTiquetes = 0;
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                for (int k = 0; k < casetas[i][j].getEmpresa().getTiquetes().size(); k++) {
                    if (casetas[i][j].getEmpresa().getTiquetes().get(k).getViaje().getId() == viaje.getId()) {
                        countTiquetes++;
                    }
                }
            }
        }
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                for (int k = 0; k < casetas[i][j].getEmpresa().getReservas().size(); k++) {
                    if (casetas[i][j].getEmpresa().getReservas().get(k).getViaje().getId() == viaje.getId()) {
                        countTiquetes++;
                    }
                }
            }
        }
        if (cantidad <= viaje.getBus().getPuesto() - countTiquetes) {
            return true;
        }
        return false;

    }

    public int cuposDisponibles(Viaje viaje) {
        int countTiquetes = 0;
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                for (int k = 0; k < casetas[i][j].getEmpresa().getTiquetes().size(); k++) {
                    if (casetas[i][j].getEmpresa().getTiquetes().get(k).getViaje().getId() == viaje.getId()) {
                        countTiquetes++;
                    }
                }
            }
        }
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                for (int k = 0; k < casetas[i][j].getEmpresa().getReservas().size(); k++) {
                    if (casetas[i][j].getEmpresa().getReservas().get(k).getViaje().getId() == viaje.getId()) {
                        countTiquetes++;
                    }
                }
            }
        }
        return viaje.getBus().getPuesto() - countTiquetes;
    }

    public Empresa conseguirEmpresaViaje(Viaje viaje) {
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                for (int k = 0; k < casetas[i][j].getEmpresa().getViajes().size(); k++) {
                    if (casetas[i][j].getEmpresa().getViajes().get(k).getId() == viaje.getId()) {
                        return casetas[i][j].getEmpresa();
                    }
                }
            }
        }
        return null;
    }

    public void guardarNotifs(Notificacion notif) {
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
//                for (int k = 0; k < casetas[i][j].getEmpresa().getViajes().size(); k++) {
                    if (casetas[i][j].getEmpresa().getNit() == notif.getEmpresa().getNit()) {
                        casetas[i][j].getEmpresa().getNotificaciones().add(notif);
                    }
//                }
            }
        }
        controlL.guardarNotifs(notif);
    }
}
