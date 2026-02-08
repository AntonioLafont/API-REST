package edu.comillas.icai.gitt.pat.spring.practica2;

public record ModeloCarrito(
        Long idCarrito,
        Long idArticulo,
        String descripcion,
        Integer unidades,
        Double precioFinal
) {
}
