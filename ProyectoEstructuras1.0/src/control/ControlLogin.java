/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.List;
import modelo.Cliente;
import modelo.Notificacion;
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

    public Usuario validarAcceso(String contraseña, String nombre) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equals(nombre)
                    && usuarios.get(i).getContraseña().equals(contraseña)) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    public Lista<Cliente> obtenerClientes() {
        Lista<Cliente> clientes = new Lista<>();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i) instanceof Cliente) {
                clientes.add((Cliente) usuarios.get(i));
            }
        }
        return clientes;
    }

    public void asignarPuntos(int puntos, Cliente cliente) {
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getId() == cliente.getId()){
                Cliente aux =(Cliente) usuarios.get(i);
                int acumulado = aux.getPuntos();
                aux.setPuntos(puntos + acumulado);
                usuarios.remove(i);
                usuarios.add(aux);
                Singleton.getINSTANCIA().escribirUsuarios();
                return;
            }
        }
    
    }

    public void eliminarPuntos(int puntos, Cliente cliente) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == cliente.getId()) {
                Cliente aux = (Cliente) usuarios.get(i);
                int acomulado = aux.getPuntos();
                aux.setPuntos(acomulado - puntos);
                usuarios.remove(i);
                usuarios.add(aux);
                Singleton.getINSTANCIA().escribirUsuarios();
                Singleton.getINSTANCIA().escribirUsuarios();
                return;
            }
        }
    }
    
    public void guardarNotifs(Notificacion notif){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getId() == notif.getCliente().getId()){
                Cliente aux = (Cliente) usuarios.get(i);
                aux.getNotificaciones().add(notif);
            }
        }
    }
}
