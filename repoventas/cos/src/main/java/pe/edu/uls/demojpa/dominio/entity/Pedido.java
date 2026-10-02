package pe.edu.uls.demojpa.dominio.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_pedido")
    @SequenceGenerator(
        name = "sec_pedido",
        sequenceName = "sec_pedido",
        allocationSize = 1
    )
    private Integer id;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoItem> items = new ArrayList<>();

    @Column(nullable = false)
    private Double total = 0.0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PedidoItem> getItems() {
        return items;
    }

    public Double getTotal() {
        return total;
    }

    public void agregarItem(Producto producto, int cantidad, Double precioUnitario) {
        PedidoItem item = new PedidoItem();
        item.setPedido(this);
        item.setProducto(producto);
        item.setCantidad(cantidad);
        item.setPrecioUnitario(precioUnitario);
        items.add(item);
        total += cantidad * precioUnitario;
    }
}