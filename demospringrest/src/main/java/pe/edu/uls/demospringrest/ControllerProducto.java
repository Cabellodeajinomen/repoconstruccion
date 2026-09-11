package pe.edu.uls.demospringrest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/producto")
public class ControllerProducto {

    @GetMapping("/{id}")
    public Producto consultarProducto(@PathVariable(name = "id") int id) {
        Producto p = new Producto(id, "Producto "+id, 2*id);
        return p;
    }
    
    @PostMapping("/nuevo")
    public Producto registrarProducto(@RequestBody Producto nuevo) {
        Date ahora = new Date();
        nuevo.setId((int)ahora.getTime()); 
        return nuevo;
    }
    
}
