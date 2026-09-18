package pe.edu.uls.demojpa.dominio.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class PedidoTest {

    @Test
    void agregarItemDebeActualizarTotalYRelacionarPedido() {
        Producto producto = new Producto();
        producto.setNombre("Teclado");

        Pedido pedido = new Pedido();
        pedido.agregarItem(producto, 2, 100.0);

        assertEquals(200.0, pedido.getTotal());
        assertEquals(1, pedido.getItems().size());
        assertSame(pedido, pedido.getItems().get(0).getPedido());
    }
}
