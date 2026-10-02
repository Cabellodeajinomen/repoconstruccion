package pe.edu.uls.demojpa.dominio.entity.administrarproductos;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.uls.demojpa.dominio.entity.Marca;
import pe.edu.uls.demojpa.dominio.entity.Producto;
import pe.edu.uls.demojpa.dominio.entity.administrarproductos.exception.ProductoNoEncontradoException;
import pe.edu.uls.demojpa.dominio.entity.administrarproductos.request.RequestAjusteStock;
import pe.edu.uls.demojpa.dominio.entity.administrarproductos.request.RequestProducto;
import pe.edu.uls.demojpa.dominio.entity.repository.RepoMarca;
import pe.edu.uls.demojpa.dominio.entity.repository.RepoProducto;

@Service
public class ServiceAdministrarProductos {

    private final RepoProducto repoProducto;
    private final RepoMarca repoMarca;

    public ServiceAdministrarProductos(RepoProducto repoProducto, RepoMarca repoMarca) {
        this.repoProducto = repoProducto;
        this.repoMarca = repoMarca;
    }

    @Transactional
    public Producto registrarProducto(int idMarca, RequestProducto request) {
        validarProducto(request);
        Marca marca = repoMarca.findById(idMarca)
                .orElseThrow(() -> new ProductoNoEncontradoException("Marca no encontrada: " + idMarca));

        Producto producto = new Producto();
        producto.setMarca(marca);
        producto.setNombre(request.nombre());
        producto.setDescripcion(request.descripcion());
        producto.setPrecio(request.precio());
        producto.setStock(request.stock());
        return repoProducto.save(producto);
    }

    @Transactional(readOnly = true)
    public Producto consultarProducto(int idProducto) {
        return repoProducto.findById(idProducto)
                .orElseThrow(() -> new ProductoNoEncontradoException(
                        "Producto no encontrado: " + idProducto));
    }

    @Transactional
    public Producto ajustarStock(RequestAjusteStock request) {
        if (request.stock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        Producto producto = consultarProducto(request.idProducto());
        producto.setStock(request.stock());
        return repoProducto.save(producto);
    }

    private void validarProducto(RequestProducto request) {
        if (request.nombre() == null || request.nombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }
        if (request.precio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (request.stock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }
}
