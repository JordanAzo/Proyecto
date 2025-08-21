/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praxair.com.controller;

import praxair.com.domain.Gas;
import praxair.com.Service.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/gas")
public class GasController {
    
    @Autowired
    private GasService gasService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var gases = gasService.getGases();
        model.addAttribute("gases", gases);
        model.addAttribute("totalGases", gases.size());
        model.addAttribute("gas", new Gas()); // Para el formulario modal
        return "/gases/listado";
    }
    
    @GetMapping("/nuevo")
    public String gasNuevo(Gas gas, Model model) {
        model.addAttribute("gas", gas);
        return "/gases/modifica";
    }
    
    @PostMapping("/guardar")
    public String gasGuardar(Gas gas,
                             @RequestParam(value = "imagenFile", required = false) MultipartFile imagenFile) {
        // Si planeas subir imágenes en el futuro
        if (imagenFile != null && !imagenFile.isEmpty()) {
            // gas.setRutaImagen(firebaseStorageService.cargaImagen(imagenFile, "gas", gas.getIdGas()));
        }
        
        gasService.save(gas);
        return "redirect:/gas/listado";
    }
    
    @GetMapping("/eliminar/{idGas}")
    public String gasEliminar(@PathVariable Long idGas) {
        Gas gas = new Gas();
        gas.setIdGas(idGas);
        gasService.delete(gas);
        return "redirect:/gas/listado";
    }
    
    @GetMapping("/modificar/{idGas}")
    public String gasModificar(@PathVariable Long idGas, Model model) {
        Gas gas = new Gas();
        gas.setIdGas(idGas);
        gas = gasService.getGas(gas);
        model.addAttribute("gas", gas);
        return "/gases/modifica";
    }
}