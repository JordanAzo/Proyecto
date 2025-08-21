/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package praxair.com.Service;

import praxair.com.domain.Accesorio;
import java.util.List;

public interface AccesorioService {
    List<Accesorio> getAccesorios();  // Se elimina el parámetro boolean
    Accesorio getAccesorio(Accesorio accesorio);
    void save(Accesorio accesorio);
    void delete(Accesorio accesorio);
    List<Accesorio> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    List<Accesorio> metodoJPQL(double precioInf, double precioSup);
}
