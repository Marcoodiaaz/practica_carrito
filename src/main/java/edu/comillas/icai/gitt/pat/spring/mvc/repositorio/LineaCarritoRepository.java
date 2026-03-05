package edu.comillas.icai.gitt.pat.spring.mvc.repositorio;

import edu.comillas.icai.gitt.pat.spring.mvc.entidades.LineaCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LineaCarritoRepository extends JpaRepository<LineaCarrito, Long> {
}