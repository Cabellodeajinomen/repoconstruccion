package pe.edu.uls.demojpa.dominio.entity.administrarproductos.request;

public record RequestProducto(
        String nombre,
        String descripcion,
        double precio,
        int stock) {
}
