/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import modelo.AdmiFlota;
import modelo.Caseta;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Tiquete;
import singleton.Singleton;
import util.IList;
import util.Lista;

/**
 *
 * @author JORGE
 */
public class ControlVistaTerminal {

    private Caseta[][] casetas;
    private AdmiFlota model;
    private Empresa empresa;

    public ControlVistaTerminal() {
        casetas = Singleton.getINSTANCIA().getCasetas();
        model = new AdmiFlota("", 0, "", 0, "", "", "");
        empresa = new Empresa("", 0, model);
        if (casetas[0][0] == null) {
            initCasetas();
        }
    }

    private void initCasetas() {
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                casetas[i][j] = new Caseta(model, empresa, 0, 0);
            }
        }
    }

    public Caseta entregarCaseta(int fila, int columna) {
        return casetas[fila][columna];
    }

    public Empresa validarEmpresa(int nit, String nombre) {
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                if (casetas[i][j].getEmpresa().getNit() == nit
                        || casetas[i][j].getEmpresa().getNombre().equals(nombre)) {
                    return casetas[i][j].getEmpresa();
                }
            }
        }
        return null;
    }

    public AdmiFlota validarAdminFlota(int id) {
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                if (casetas[i][j].getAdmiFlota().getId() == id) {
                    return casetas[i][j].getAdmiFlota();
                }
            }
        }
        return null;
    }

    public Caseta obtenerCaseta(AdmiFlota admiFlota) {
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {

                if (casetas[i][j].getAdmiFlota().getId() == admiFlota.getId()) {
                    return casetas[i][j];
                }
            }
        }
        return null;
    }

    public boolean validarPlaca(String placa) {
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                for (int k = 0; k < casetas[i][j].getEmpresa().getBuses().size(); k++) {
                    if (casetas[i][j].getEmpresa().getBuses().get(k).getPlaca().equals(placa)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Lista<Tiquete> obtenerTiquetes(Cliente cliente) {
        Lista<Tiquete> tiquetesCliente = new Lista<>();
        for (int i = 0; i < casetas.length; i++) {
            for (int j = 0; j < casetas[i].length; j++) {
                for (int k = 0; k < casetas[i][j].getTiquetes().size(); k++) {
                    if(casetas[i][j].getTiquetes().get(k).getCliente().getId() == cliente.getId()){
                        tiquetesCliente.add(casetas[i][j].getTiquetes().get(k));
                    }
                }
            }
        }
        return tiquetesCliente;
    }

}
