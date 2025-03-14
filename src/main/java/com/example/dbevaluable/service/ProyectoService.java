package com.example.dbevaluable.service;

import com.example.dbevaluable.model.Proyecto;
import com.example.dbevaluable.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository) { this.proyectoRepository = proyectoRepository; }

    public List<Proyecto> listarProyectos() { return proyectoRepository.findAll(); }

    public Proyecto obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id).orElseThrow(() -> new RuntimeException("proyecto no encontrado"));
    }

    public Proyecto obtenerProyectoPorNombre(String nombre) {
        return proyectoRepository.findByNombre(nombre).orElseThrow(() -> new RuntimeException("proyecto no encontrado"));
    }

    public void agregarProyecto(Proyecto proyecto) {
        if(proyecto.getId() == null)
            proyectoRepository.save(proyecto);
    }

    public void eliminarProyecto(Proyecto proyecto) {
        proyectoRepository.delete(proyecto);
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    public void modificarProyecto(Long id, Proyecto proyectoActualizado) {
        Proyecto proyecto = obtenerProyectoPorId(id);
        proyecto.setNombre(proyectoActualizado.getNombre());
        proyecto.setDescripcion(proyectoActualizado.getDescripcion());
        proyecto.setFechaInicio(proyectoActualizado.getFechaInicio());
        proyecto.setEstado(proyectoActualizado.getEstado());
        proyectoRepository.save(proyecto);
    }}
