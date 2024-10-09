package edu.pe.cibertec.controller;

import edu.pe.cibertec.model.Libro;
import edu.pe.cibertec.service.ILibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibroController {

    @Autowired
    private ILibroService libroService;

    @GetMapping("/listarLibros")
    public String listarLibros(Model modelo) {
        modelo.addAttribute("libros", libroService.listarLibros());
        return "libros";
    }

    @GetMapping("/nuevoLibro")
    public String nuevoLibro(Model modelo) {
        modelo.addAttribute("libro", new Libro());
        return "formLibro";
    }

    @PostMapping("/saveLibro")
    public String saveLibro(@ModelAttribute Libro libro) {
        libroService.guardarLibro(libro);
        return "redirect:/listarLibros";
    }


    @GetMapping("/editarLibro/{id}")
    public String editarLibro(@PathVariable Long id, Model modelo) {
        Libro libro = libroService.obtenerLibroPorId(id);
        modelo.addAttribute("libro", libro);
        return "formLibro";
    }


    @GetMapping("/eliminarLibro/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return "redirect:/listarLibros";
    }
}