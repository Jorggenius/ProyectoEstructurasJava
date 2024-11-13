/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.Caseta;
import modelo.Cliente;
import modelo.Usuario;
import util.IList;
import util.Lista;


/**
 *
 * @author JORGE
 */
public class Singleton {

    private static final Singleton INSTANCIA = new Singleton();
    private IList<Usuario> usuarios;
    private Caseta[][] casetas;

    private Singleton() {
        usuarios = leerUsuarios();
        casetas = leerCasetas();
        
    }

    public static Singleton getINSTANCIA() {
        return INSTANCIA;
    }

    public IList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Caseta[][] getCasetas() {
        return casetas;
    }
    


    public void escribirUsuarios() {
        try {
            FileOutputStream archivo = new FileOutputStream("usuarios.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(usuarios);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public IList<Usuario> leerUsuarios() {
        try {
            FileInputStream archrivo = new FileInputStream("usuarios.dat");
            ObjectInputStream lector = new ObjectInputStream(archrivo);
            return (Lista<Usuario>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("No hay lista Usuarios");
            return new Lista<Usuario>();
        }
    }

    public void escribirCasetas() {
        try {
            FileOutputStream archivo = new FileOutputStream("casetas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(casetas);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Caseta[][] leerCasetas() {
        try {
            FileInputStream archrivo = new FileInputStream("casetas.dat");
            ObjectInputStream lector = new ObjectInputStream(archrivo);
            return (Caseta[][]) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("No Hay Lista casetas");
            return new Caseta[3][5];
        }
    }
}
