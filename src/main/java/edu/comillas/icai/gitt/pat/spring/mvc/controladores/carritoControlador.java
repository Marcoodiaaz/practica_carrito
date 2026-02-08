package edu.comillas.icai.gitt.pat.spring.mvc.controladores;

import edu.comillas.icai.gitt.pat.spring.mvc.modelo.Carrito;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class carritoControlador {
    private final Map<Integer, Carrito> carritos = new HashMap<>();

    @PostMapping("/api/contadores")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito creaCarrito(@RequestBody Carrito carrito) {
        carritos.put(Carrito.getIdCarrito(), carrito);
       return carrito;
    }

    @GetMapping("/api/carrito")
    public List<Carrito> getCarritos(){
        return (List<Carrito>) carritos.values();
    }

//    @PutMapping("/api/contadores/{nombre}/incremento/{incremento}")
//    public ModeloContador incrementa(@PathVariable String nombre,
//                                     @PathVariable Integer incremento) {
//        ModeloContador contadorActual = contadores.get(nombre);
//        ModeloContador contadorIncrementado =
//                new ModeloContador(nombre, contadorActual.valor() + incremento);
//        contadores.put(nombre, contadorIncrementado);
//        return contadorIncrementado;
//    }
}

