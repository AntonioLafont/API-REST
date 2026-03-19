package edu.comillas.icai.gitt.pat.spring.practica3.service;

import edu.comillas.icai.gitt.pat.spring.practica3.entity.Carrito;
import edu.comillas.icai.gitt.pat.spring.practica3.entity.LineaCarrito;
import edu.comillas.icai.gitt.pat.spring.practica3.repositorio.CarritoRepository;
import edu.comillas.icai.gitt.pat.spring.practica3.repositorio.LineaCarritoRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class LineaCarritoService {
    
    @Autowired
    private LineaCarritoRepository lineaCarritoRepository;
    
    @Autowired
    private CarritoRepository carritoRepository;
    
    @Transactional
    public LineaCarrito crearLinea(Long idCarrito, LineaCarrito linea) {
        Carrito carrito = carritoRepository.findByIdCarrito(idCarrito);
        if (carrito == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Carrito con ID " + idCarrito + " no encontrado");
        }
        if (linea.getIdArticulo() == null || linea.getPrecioUnitario() == null || linea.getNumeroUnidades() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Los campos idArticulo, precioUnitario y numeroUnidades son obligatorios");
        }
        
        linea.setCarrito(carrito);
        linea.setCosteLinea(linea.getPrecioUnitario() * linea.getNumeroUnidades());
        carrito.setTotalPrecio(carrito.getTotalPrecio() + linea.getCosteLinea());
        carritoRepository.save(carrito);
        
        return lineaCarritoRepository.save(linea);
    }

    @Transactional
    public void eliminarLinea(Long idLineaCarrito) {
        LineaCarrito linea = lineaCarritoRepository.findByIdLineaCarrito(idLineaCarrito);
        if (linea == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Línea de carrito con ID " + idLineaCarrito + " no encontrada");
        }
        Carrito carrito = linea.getCarrito();
        carrito.setTotalPrecio(carrito.getTotalPrecio() - linea.getCosteLinea());
        lineaCarritoRepository.deleteById(idLineaCarrito);
    }
    
}