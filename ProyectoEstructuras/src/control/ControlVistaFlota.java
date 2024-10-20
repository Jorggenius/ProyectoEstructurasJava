/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import modelo.AdmiFlota;
import modelo.Caseta;

/**
 *
 * @author JORGE
 */
public class ControlVistaFlota {
    ControlVistaTerminal controlVT;
    public ControlVistaFlota() {
        this.controlVT = new ControlVistaTerminal();
    }
    
    public Caseta obtenerCaseta(AdmiFlota admiFlota){
        return controlVT.obtenerCaseta(admiFlota);
    }
    
}
