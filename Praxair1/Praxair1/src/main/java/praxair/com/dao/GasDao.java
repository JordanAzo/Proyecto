/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package praxair.com.dao;

import praxair.com.domain.Gas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GasDao extends JpaRepository<Gas, Long> {

    List<Gas> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    @Query("SELECT g FROM Gas g WHERE g.precio BETWEEN :precioInf AND :precioSup ORDER BY g.descripcion ASC")
    List<Gas> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
}
