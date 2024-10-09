package edu.pe.cibertec.service;

import edu.pe.cibertec.model.Libro;

import java.util.List;

public interface ILibroService {
    List<Libro> listarLibros();
    void guardarLibro(Libro libro);
    Libro obtenerLibroPorId(Long id);
    void eliminarLibro(Long id);
}