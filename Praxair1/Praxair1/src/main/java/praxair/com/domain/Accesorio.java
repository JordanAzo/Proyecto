/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praxair.com.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@Table(name="accesorios")
@NoArgsConstructor
@AllArgsConstructor
public class Accesorio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_accesorio")
    private Long idAccesorio;

    @Column(name="nombre")  // ← AGREGADO
    private String nombre;  // ← AGREGADO

    private String descripcion;
    private double precio;
    private int stock;
}