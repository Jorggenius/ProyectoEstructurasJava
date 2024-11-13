/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author JORGE
 */
public class Queve<T>implements Serializable, IQueve<T>{
    
     private Nodo<T>  primero;
     private int size;

    public Queve() {
        this.primero = null;
        this.size = 0;
    }
     

    public void enQueve(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> aux = primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }

    @Override
    public T deQueve() {
        if(primero == null){
        throw new IndexOutOfBoundsException("La lista esta vasia");
        }else{
        T t = primero.dato;
        primero = primero.siguiente;
        return t;
        }
    }

    @Override
    public T peek() {
        if(primero == null){
            throw new IndexOutOfBoundsException("La lista esta vasia");
        }
        return primero.dato;
    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }

}
