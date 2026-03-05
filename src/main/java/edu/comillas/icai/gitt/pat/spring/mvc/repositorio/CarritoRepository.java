package edu.comillas.icai.gitt.pat.spring.mvc.repositorio;

import edu.comillas.icai.gitt.pat.spring.mvc.entidades.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito, Long> { }