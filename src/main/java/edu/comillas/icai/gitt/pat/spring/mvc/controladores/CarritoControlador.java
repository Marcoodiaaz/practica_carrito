package edu.comillas.icai.gitt.pat.spring.mvc.controladores;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.comillas.icai.gitt.pat.spring.mvc.entidades.LineaCarrito;
import edu.comillas.icai.gitt.pat.spring.mvc.entidades.Carrito;
import edu.comillas.icai.gitt.pat.spring.mvc.servicio.CarritoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
public class CarritoControlador {

    @Autowired
    private CarritoServicio carritoServicio;

    // 1. Crear el carrito (Cabecera)
    @PostMapping
    public ResponseEntity<Carrito> crearCarrito(@Valid @RequestBody Carrito nuevoCarrito) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carritoServicio.crear(nuevoCarrito));
    }

    // 2. Obtener todos los carritos
    @GetMapping
    public List<Carrito> listarTodos() {
        return carritoServicio.obtenerTodos();
    }

    // 3. Obtener un carrito específico por ID
    @GetMapping("/{id}")
    public Carrito obtenerUno(@PathVariable Long id) throws Throwable {
        return carritoServicio.obtenerPorId(id);
    }

    // 4. AÑADIR LÍNEA (Nueva funcionalidad solicitada)
    @PostMapping("/{id}/lineas")
    public Carrito añadirLinea(@PathVariable Long id, @Valid @RequestBody LineaCarrito linea) throws Throwable {
        return carritoServicio.añadirLinea(id, linea);
    }

    // 5. BORRAR LÍNEA (Nueva funcionalidad solicitada)
    @DeleteMapping("/{idCarrito}/lineas/{idLinea}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarLinea(@PathVariable Long idCarrito, @PathVariable Long idLinea) throws Throwable {
        carritoServicio.eliminarLinea(idCarrito, idLinea);
    }

    // 6. Borrar carrito completo
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarCarrito(@PathVariable Long id) {
        carritoServicio.eliminarCarrito(id);
    }
}