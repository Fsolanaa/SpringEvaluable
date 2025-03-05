package com.example.dbevaluable.repository;

import java.util.Optional;
import com.example.dbevaluable.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TareaRepository extends JpaRepository<Tarea, Long>{

    Optional<Tarea> findByTitulo(String nombre);
}
