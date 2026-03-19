package edu.comillas.icai.gitt.pat.spring.practica3.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import edu.comillas.icai.gitt.pat.spring.practica3.entity.Carrito;
import edu.comillas.icai.gitt.pat.spring.practica3.entity.LineaCarrito;
import edu.comillas.icai.gitt.pat.spring.practica3.service.CarritoService;
import edu.comillas.icai.gitt.pat.spring.practica3.service.LineaCarritoService;


@RestController
@RequestMapping("/api/carrito")
public class ControladorCarrito {
    
    @Autowired
    private CarritoService carritoService;

    @Autowired
    private LineaCarritoService lineaCarritoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito crearCarrito(@RequestBody Carrito carritoNuevo) {
        return carritoService.crearCarrito(carritoNuevo);
    }

    @GetMapping("/{idCarrito}")
    public Carrito buscarCarrito(@PathVariable Long idCarrito) {
        return carritoService.buscarCarritoPorId(idCarrito);
    }

    @PutMapping("/{idCarrito}")
    public Carrito actualizarCarrito(@PathVariable Long idCarrito,
                                    @RequestBody Carrito carritoActualizado) {
        return carritoService.actualizarCarrito(idCarrito, carritoActualizado);
    }

    @DeleteMapping("/{idCarrito}")
    public void eliminarCarrito(@PathVariable Long idCarrito) {
        carritoService.eliminarCarrito(idCarrito);
    }

    @PostMapping("/{idCarrito}/lineas")
    @ResponseStatus(HttpStatus.CREATED)
        public LineaCarrito crearLineaCarrito(@PathVariable Long idCarrito, @RequestBody LineaCarrito lineaNueva) {
        return lineaCarritoService.crearLinea(idCarrito, lineaNueva);
    }

    @DeleteMapping("/{idCarrito}/lineas/{idLineaCarrito}")
    public void eliminarLineaCarrito(@PathVariable Long idCarrito, @PathVariable Long idLineaCarrito) {
        lineaCarritoService.eliminarLinea(idLineaCarrito);
    }
}
