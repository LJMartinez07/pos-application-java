/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ipisa.proyectofinal.utilidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public interface ISubject {
     List<IObserver> observers = new ArrayList<>();
     void addObserver(IObserver observador);
     void removeObserver(IObserver observador);
     void notify(Class clase,Object argumento,String mensaje);
}
