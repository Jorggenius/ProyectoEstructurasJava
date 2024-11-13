/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import excepcion.IdExiste;
import java.time.LocalDate;
import java.time.LocalTime;
import modelo.Bus;
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

    public void guardarViaje(Viaje viaje) throws IdExiste {
        Viaje aux = buscarViaje(viaje.getId());
        if (aux == null) {
            caseta.getEmpresa().getViajes().add(viaje);
            Singleton.getINSTANCIA().escribirCasetas();
            return;
        }
        throw new IdExiste();
    }

    public Viaje buscarViaje(int id) {
        for (int i = 0; i < caseta.getEmpresa().getViajes().size(); i++) {
            if (caseta.getEmpresa().getViajes().get(i).getId() == (id)) {
                return caseta.getEmpresa().getViajes().get(i);
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
        for (int i = 0; i < caseta.getEmpresa().getViajes().size(); i++) {
            if (caseta.getEmpresa().getViajes().get(i).getId() == (id)) {
                caseta.getEmpresa().getViajes().remove(i);
                Singleton.getINSTANCIA().escribirCasetas();
                return;
            }
        }
        throw new RuntimeException("No se encuentra el Viaje que desea eliminar");
    }

    public boolean disponibilidadBus(LocalDate fechaSalida, LocalDate fechaLLeagada, LocalTime horaSalida, Bus bus) {
        for (int i = 0; i < caseta.getEmpresa().getViajes().size(); i++) {
            // here I should to compare the date an the hours;
            if (caseta.getEmpresa().getViajes().get(i).getBus().getPlaca().equals(bus.getPlaca())
                    && fechaSalida.isEqual(caseta.getEmpresa().getViajes().get(i).getFechaSalida())) {
                return false;
            }
            // para los viajes que son creados para despues
            if (caseta.getEmpresa().getViajes().get(i).getBus().getPlaca().equals(bus.getPlaca())
                    && fechaSalida.isAfter(caseta.getEmpresa().getViajes().get(i).getFechaSalida())
                    && fechaSalida.isBefore(caseta.getEmpresa().getViajes().get(i).getFechaLLegada().plusDays(2)) //                    && horaSalida.isBefore(caseta.getViajes().get(i).getHoraLlegada())// preguntar al profesor
                    ) {
                return false;
            }
            //para los viajes que sean creados para antes 
            if (caseta.getEmpresa().getViajes().get(i).getBus().getPlaca().equals(bus.getPlaca())
                    && fechaLLeagada.isAfter(caseta.getEmpresa().getViajes().get(i).getFechaSalida().minusDays(2))
                    && fechaLLeagada.isBefore(caseta.getEmpresa().getViajes().get(i).getFechaSalida())) {
                return false;
            }
        }
        return true;
    }
}

