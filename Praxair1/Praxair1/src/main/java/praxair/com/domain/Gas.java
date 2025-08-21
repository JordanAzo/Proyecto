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
@Table(name="gases")
@NoArgsConstructor
@AllArgsConstructor
public class Gas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_gas")
    private Long idGas;

    @Column(name="nombre")  // ← AGREGADO
    private String nombre;  // ← AGREGADO

    private String descripcion;
    private double precio;
    private int stock;
    //private boolean activo; // Para isActivo()

    // Ejemplo de relación ManyToOne futura (opcional)
    // @ManyToOne
    // @JoinColumn(name="otra_entidad_id")
    // private OtraEntidad otraEntidad;
}
