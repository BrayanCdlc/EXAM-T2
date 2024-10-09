package edu.pe.cibertec.controller;

import edu.pe.cibertec.model.Libro;
import edu.pe.cibertec.model.Orden;
import edu.pe.cibertec.service.ILibroService;
import edu.pe.cibertec.service.IOrdenService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdenController {

    @Autowired
    private IOrdenService ordenService;
    
    @Autowired
    private ILibroService libroService;
    
    @GetMapping("/listarOrdenes")
    public String listarOrdenes(Model modelo) {
        modelo.addAttribute("ordenes", ordenService.listarOrdenes());
        return "ordenes";
    }

    @GetMapping("/nuevaOrden")
    public String nuevaOrden(Model modelo) {
        Orden orden = new Orden();
        modelo.addAttribute("orden", orden);
        List<Libro> libros = libroService.listarLibros();
        modelo.addAttribute("libros", libros);
        return "formOrden";
    }

    @PostMapping("/saveOrden")
    public String saveOrden(@ModelAttribute Orden orden) {
        ordenService.guardarOrden(orden);
        return "redirect:/listarOrdenes";
    }


    @GetMapping("/editarOrden/{id}")
    public String editarOrden(@PathVariable Long id, Model modelo) {
        Orden orden = ordenService.obtenerOrdenPorId(id);
        modelo.addAttribute("orden", orden);
        List<Libro> libros = libroService.listarLibros();
        modelo.addAttribute("libros", libros);
        return "formOrden";
    }




    @GetMapping("/eliminarOrden/{id}")
    public String eliminarOrden(@PathVariable Long id) {
        ordenService.eliminarOrden(id);
        return "redirect:/listarOrdenes";
    }
}