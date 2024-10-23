/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import modelo.Bus;
import modelo.Caseta;
import singleton.Singleton;
import util.IList;

/**
 *
 * @author JORGE
 */
public class ControlGestionBuses {
    ControlVistaTerminal controlVT;
    private Caseta caseta;

    public ControlGestionBuses(Caseta caseta) {
        this.caseta = caseta;
        controlVT = new ControlVistaTerminal();
    }

    public Caseta getCaseta() {
        return caseta;
    }

    public void setCaseta(Caseta caseta) {
        this.caseta = caseta;
    }

    public void guardarBus(Bus bus) throws RuntimeException {
        Bus aux = buscarBus(bus.getPlaca());
        if (aux == null) {
            caseta.getBuses().add(bus);
            Singleton.getINSTANCIA().escribirCasetas();
            return;
        }
        throw new RuntimeException("El id ya esta en uso");
    }

    public Bus buscarBus(String placa) {
        for (int i = 0; i < caseta.getBuses().size(); i++) {
            if (caseta.getBuses().get(i).getPlaca().equals(placa)) {
                return caseta.getBuses().get(i);
            }
        }
        return null;
    }
    
      public void eliminarBus(String placa) throws RuntimeException {
        for (int i = 0; i < caseta.getBuses().size(); i++) {
            if (caseta.getBuses().get(i).getPlaca().equals(placa)) {
                caseta.getBuses().remove(i);
                return;
            }
        }
        throw new RuntimeException("No se encuentra el Bus que desea eliminar");
    }

    public boolean validarPlazas(){
        if(caseta.getBuses().size() < caseta.getPlazas()){
            return true;
        }
        return false;
    }
    
    public boolean validarPlaca(String placa){
        return controlVT.validarPlaca(placa);
    }
}
