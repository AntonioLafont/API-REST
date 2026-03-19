package edu.comillas.icai.gitt.pat.spring.practica3.repositorio;

import edu.comillas.icai.gitt.pat.spring.practica3.entity.LineaCarrito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LineaCarritoRepository extends CrudRepository<LineaCarrito, Long> {
    LineaCarrito findByIdLineaCarrito(Long idLineaCarrito);
}
