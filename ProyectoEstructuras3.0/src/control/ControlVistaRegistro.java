/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import excepcion.IdExiste;
import modelo.Cliente;
import modelo.Usuario;
import singleton.Singleton;
import util.IList;
import util.Lista;

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

    public void guardarCliente(Usuario usuario) throws IdExiste {
        Usuario aux = buscarCliente(usuario.getId());
        if (aux == null) {
            usuarios.add(usuario);
            Singleton.getINSTANCIA().escribirUsuarios();
            return;
        }
        throw new IdExiste();
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
                Singleton.getINSTANCIA().escribirUsuarios();
                return;
            }
        }
        throw new RuntimeException("No se encuentra el Usuario que desea eliminar");
    }
    
    public Lista<Cliente> conseguirClientes(){
        Lista<Cliente> aux = new Lista<>();
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i) instanceof Cliente){
                aux.add((Cliente)usuarios.get(i));
            }
        }
        return aux;
    }
}
