package edu.comillas.icai.gitt.pat.spring.mvc.servicio;

import edu.comillas.icai.gitt.pat.spring.mvc.entidades.Carrito;
import edu.comillas.icai.gitt.pat.spring.mvc.entidades.LineaCarrito;
import edu.comillas.icai.gitt.pat.spring.mvc.repositorio.CarritoRepository;
import edu.comillas.icai.gitt.pat.spring.mvc.repositorio.LineaCarritoRepository;
import edu.comillas.icai.gitt.pat.spring.mvc.repositorio.LineaCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarritoServicio {

    @Autowired
    private CarritoRepository carritoRepo;

    @Autowired
    private LineaCarritoRepository lineaRepo;

    public Carrito crear(Carrito carrito) {
        return (Carrito) carritoRepo.save(carrito);
    }

    public List<Carrito> obtenerTodos() {
        return carritoRepo.findAll();
    }

    public Carrito obtenerPorId(Long id) throws Throwable {
        return (Carrito) carritoRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado"));
    }

    // AÑADIR LÍNEA Y ACTUALIZAR PRECIO
    public Carrito añadirLinea(Long idCarrito, LineaCarrito nuevaLinea) throws Throwable {
        Carrito carrito = obtenerPorId(idCarrito);

        // 1. Calculamos el coste de la línea
        nuevaLinea.setCosteLinea(nuevaLinea.getPrecioUnitario() * nuevaLinea.getUnidades());

        // 2. Vinculamos con el carrito
        nuevaLinea.setCarrito(carrito);
        carrito.getLineas().add(nuevaLinea);

        // 3. Actualizamos el total del carrito sumando la nueva línea
        carrito.setTotalPrecio(carrito.getTotalPrecio() + nuevaLinea.getCosteLinea());

        return (Carrito) carritoRepo.save(carrito);
    }

    // BORRAR LÍNEA Y RESTAR DEL PRECIO TOTAL
    public void eliminarLinea(Long idCarrito, Long idLinea) throws Throwable {
        Carrito carrito = obtenerPorId(idCarrito);

        LineaCarrito linea = (LineaCarrito) lineaRepo.findById(idLinea)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Línea no encontrada"));

        // 1. Restamos el precio de la línea que se va a borrar del total
        carrito.setTotalPrecio(carrito.getTotalPrecio() - linea.getCosteLinea());

        // 2. Quitamos la línea de la lista del carrito
        carrito.getLineas().remove(linea);

        // 3. Borramos la línea de la BD y guardamos el carrito actualizado
        lineaRepo.delete(linea);
        carritoRepo.save(carrito);
    }

    public void eliminarCarrito(Long id) {
        if (!carritoRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        carritoRepo.deleteById(id);
    }
}
