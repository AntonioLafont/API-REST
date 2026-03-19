package edu.comillas.icai.gitt.pat.spring.practica3.repositorio;

import edu.comillas.icai.gitt.pat.spring.practica3.entity.Carrito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarritoRepository extends CrudRepository<Carrito, Long> {
    Carrito findByIdCarrito(Long idCarrito);
}
