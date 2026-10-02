package pe.edu.uls.demojpa.dominio.entity.administrarproductos.response;

import pe.edu.uls.demojpa.dominio.entity.Producto;

public record ResponseProducto(
        Integer id,
        Integer idMarca,
        String nombre,
        String descripcion,
        double precio,
        Integer stock) {

    public static ResponseProducto from(Producto producto) {
        return new ResponseProducto(
                producto.getId(),
                producto.getMarca().getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock());
    }
}
