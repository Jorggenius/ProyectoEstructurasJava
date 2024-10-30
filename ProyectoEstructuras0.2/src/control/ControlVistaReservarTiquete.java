/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import modelo.Caseta;
import modelo.Empresa;
import singleton.Singleton;
import util.Lista;

/**
 *
 * @author JORGE
 */
public class ControlVistaReservarTiquete {
    Caseta [][] casetas;

    public ControlVistaReservarTiquete() {
        casetas = Singleton.getINSTANCIA().getCasetas();
    }

    public Caseta[][] getCasetas() {
        return casetas;
    }

    public void setCasetas(Caseta[][] casetas) {
        this.casetas = casetas;
    }
    
    public Lista<Caseta> obtenerEmpresas(){
        Lista<Caseta> aux = new Lista<>();
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                if(!casetas[i][j].getEmpresa().getNombre().equals("")){
                    aux.add(casetas[i][j]);
                }
            }
        }
        return aux;
    }
    
}
