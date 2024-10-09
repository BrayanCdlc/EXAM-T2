package edu.pe.cibertec.service;

import edu.pe.cibertec.model.Orden;

import java.util.List;

public interface IOrdenService {
    List<Orden> listarOrdenes();
    void guardarOrden(Orden orden);
    Orden obtenerOrdenPorId(Long id);
    void eliminarOrden(Long id);
}