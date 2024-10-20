/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.List;
import modelo.Cliente;
import modelo.Usuario;
import singleton.Singleton;
import util.IList;
import util.Lista;

/**
 *
 * @author JORGE
 */
public class ControlLogin {

    IList<Usuario> usuarios;

    public ControlLogin() {
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

    
    public Usuario validarAcceso(String contraseña, String nombre){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getNombre().equals(nombre)&&
                    usuarios.get(i).getContraseña().equals(contraseña)){
                return usuarios.get(i);
            }
        }
        return null;
    }
    
    public Lista<Cliente> obtenerClientes(){
        Lista<Cliente> clientes = new Lista<>();
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i)instanceof Cliente){
                clientes.add((Cliente)usuarios.get(i));
            }
        }
        return clientes;
    }
        
    
}
