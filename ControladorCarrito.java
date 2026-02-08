package edu.comillas.icai.gitt.pat.spring.practica2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ControladorCarrito {
    private final Map<Long, ModeloCarrito> carritos = new ConcurrentHashMap<>();

    @PostMapping("/api/carrito")
    @ResponseStatus(HttpStatus.CREATED)

    public ModeloCarrito crea(@RequestBody ModeloCarrito carritoNuevo) {

        carritos.put(carritoNuevo.idCarrito(), carritoNuevo);
        return carritoNuevo;
    }

    @GetMapping("/api/carrito/{idCarrito}")
    public ModeloCarrito buscar(@PathVariable Long idCarrito) {
        if (carritos.get(idCarrito)== null) {
            // Si no existe
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return carritos.get(idCarrito);
    }


    @PutMapping("/api/carrito/{idCarrito}")
    public ModeloCarrito actualizar(@PathVariable Long idCarrito,
                                    @RequestBody ModeloCarrito carritoActualizado) {

        if (!carritos.containsKey(idCarrito)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Carrito no encontrado");
        }

        // Aseguramos coherencia del id
        ModeloCarrito carritoFinal = new ModeloCarrito(
                idCarrito,
                carritoActualizado.idArticulo(),
                carritoActualizado.descripcion(),
                carritoActualizado.unidades(),
                carritoActualizado.precioFinal()
        );

        carritos.put(idCarrito, carritoFinal);
        return carritoFinal;
    }

    @DeleteMapping("/api/carrito/borrar/{idCarrito}")
    public void borrar(@PathVariable Long idCarrito){
        carritos.remove(idCarrito);
        return;
    }
}
