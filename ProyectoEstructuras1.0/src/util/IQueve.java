/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package util;

/**
 *
 * @author JORGE
 */
public interface IQueve<T> {

    public void enQueve(T dato);
    
    public T deQueve();
    
    public T peek();
    
    public boolean isEmpty();
    
}
