/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import modelo.Usuario;
import singleton.Singleton;
import util.IList;

/**
 *
 * @author JORGE
 */
public class ControlVistaRegistro {

    IList<Usuario> usuarios;

    public ControlVistaRegistro() {
        usuarios = Singleton.getINSTANCIA().getUsuarios();
    }

    public IList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void guardarCliente(Usuario usuario) throws RuntimeException {
        Usuario aux = buscarCliente(usuario.getId());
        if (aux == null) {
            usuarios.add(usuario);
            Singleton.getINSTANCIA().escribirUsuarios();
            return;
        }
        throw new RuntimeException("El id ya esta en uso");
    }

    public Usuario buscarCliente(int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == (id)) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    public void eliminarElemento(int id) throws RuntimeException {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == (id)) {
                usuarios.remove(i);
                return;
            }
        }
        throw new RuntimeException("No se encuentra el Usuario que desea eliminar");
    }
}
