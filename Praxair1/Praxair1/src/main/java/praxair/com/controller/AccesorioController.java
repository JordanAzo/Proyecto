/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package praxair.com.controller;
import praxair.com.domain.Accesorio;
import praxair.com.Service.AccesorioService;
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
@RequestMapping("/accesorio")
public class AccesorioController {
    
    @Autowired
    private AccesorioService accesorioService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var accesorios = accesorioService.getAccesorios();
        model.addAttribute("accesorios", accesorios);
        model.addAttribute("totalAccesorios", accesorios.size());
        model.addAttribute("accesorio", new Accesorio()); // Para el formulario modal
        return "/accesorios/listado";
    }
    
    @GetMapping("/nuevo")
    public String accesorioNuevo(Accesorio accesorio, Model model) {
        model.addAttribute("accesorio", accesorio);
        return "/accesorios/modifica";
    }
    
    @PostMapping("/guardar")
    public String accesorioGuardar(Accesorio accesorio,
                                   @RequestParam(value = "imagenFile", required = false) MultipartFile imagenFile) {
        // Si planeas subir imágenes en el futuro
        if (imagenFile != null && !imagenFile.isEmpty()) {
            // accesorio.setRutaImagen(firebaseStorageService.cargaImagen(imagenFile, "accesorio", accesorio.getIdAccesorio()));
        }
        
        accesorioService.save(accesorio);
        return "redirect:/accesorio/listado";
    }
    
    @GetMapping("/eliminar/{idAccesorio}")
    public String accesorioEliminar(@PathVariable Long idAccesorio) {
        Accesorio accesorio = new Accesorio();
        accesorio.setIdAccesorio(idAccesorio);
        accesorioService.delete(accesorio);
        return "redirect:/accesorio/listado";
    }
    
    @GetMapping("/modificar/{idAccesorio}")
    public String accesorioModificar(@PathVariable Long idAccesorio, Model model) {
        Accesorio accesorio = new Accesorio();
        accesorio.setIdAccesorio(idAccesorio);
        accesorio = accesorioService.getAccesorio(accesorio);
        model.addAttribute("accesorio", accesorio);
        return "/accesorios/modifica";
    }
}
