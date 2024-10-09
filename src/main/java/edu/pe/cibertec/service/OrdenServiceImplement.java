package edu.pe.cibertec.service;

import edu.pe.cibertec.model.Orden;
import edu.pe.cibertec.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServiceImplement implements IOrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public List<Orden> listarOrdenes() {
        return ordenRepository.findAll();
    }

    @Override
    public void guardarOrden(Orden orden) {
        ordenRepository.save(orden);
    }

    @Override
    public Orden obtenerOrdenPorId(Long id) {
        return ordenRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarOrden(Long id) {
        ordenRepository.deleteById(id);
    }
}