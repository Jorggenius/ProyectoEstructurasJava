/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import modelo.AdmiFlota;
import modelo.Empresa;
import modelo.Usuario;
import singleton.Singleton;
import util.IList;

/**
 *
 * @author JORGE
 */
public class ControlVistaGestionCaseta {
    ControlVistaTerminal controlVT;
    IList<Usuario> usuarios;

    public ControlVistaGestionCaseta() {
        
        usuarios = Singleton.getINSTANCIA().getUsuarios();
        controlVT = new ControlVistaTerminal();
    }
    
    public IList<Usuario> getUsuarios() {
        return usuarios;
    }
 
     public void guardarAdminFlota(Usuario usuario) throws RuntimeException {
        Usuario aux = buscarAdminFlota(usuario.getId());
        if (aux == null) {
            usuarios.add(usuario);
            Singleton.getINSTANCIA().escribirUsuarios();
            return;
        }
        throw new RuntimeException("El id ya esta en uso");
    }

    public Usuario buscarAdminFlota(int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == (id)) {
                return usuarios.get(i);
            }
        }
        return null;
    }
    
    public Empresa validarEmpresa(int nit, String nombre){
        return controlVT.validarEmpresa(nit, nombre);
    }
    public AdmiFlota validarAdminFlota(int id){
        return controlVT.validarAdminFlota(id);
    }
}
    

