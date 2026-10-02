package pe.edu.uls.demojpa.dominio.entity.registrarpedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.uls.demojpa.dominio.entity.Pedido;
import pe.edu.uls.demojpa.dominio.entity.Producto;
import pe.edu.uls.demojpa.dominio.entity.registrarpedido.exception.StockInsuficienteException;
import pe.edu.uls.demojpa.dominio.entity.registrarpedido.request.RequestPedido;
import pe.edu.uls.demojpa.dominio.entity.registrarpedido.request.RequestPedido.RequestPedidoItem;
import pe.edu.uls.demojpa.dominio.entity.registrarpedido.response.ResponsePedido;
import pe.edu.uls.demojpa.dominio.entity.repository.RepoPedido;
import pe.edu.uls.demojpa.dominio.entity.repository.RepoProducto;

@Service 
public class ServiceRegistrarPedido {

    RepoProducto repoProducto;

    RepoPedido repoPedido;

    public ServiceRegistrarPedido(RepoProducto repoProducto, RepoPedido repoPedido) {
        this.repoProducto = repoProducto;
        this.repoPedido = repoPedido;
    }

        @Transactional
        public ResponsePedido registrarPedido(RequestPedido pedido) {
        Pedido p = new Pedido();
        List<ResponsePedido.ResponsePedidoItem> lst = new ArrayList<>();

        for (RequestPedidoItem item : pedido.items()) {
            Producto producto = repoProducto.findById(item.idProducto())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + item.idProducto()));
            if (producto.getStock() < item.cantidad()) {
            throw new StockInsuficienteException(
                "Stock insuficiente para el producto: " + producto.getNombre()
                    + ". Disponible: " + producto.getStock()
                    + ", Solicitado: " + item.cantidad());
            }

            p.agregarItem(producto, item.cantidad(), item.precioUnitario());
            lst.add(new ResponsePedido.ResponsePedidoItem(producto.getNombre(), item.cantidad()));
            producto.setStock(producto.getStock() - item.cantidad());
            repoProducto.save(producto);
        }

        repoPedido.save(p);
        return new ResponsePedido(p.getId(), lst);
    }
}