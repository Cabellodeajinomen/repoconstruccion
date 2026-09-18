package pe.edu.uls.demojpa.dominio.entity.registrarpedido;

import org.springframework.web.bind.annotation.RestController;

import pe.edu.uls.demojpa.dominio.entity.registrarpedido.request.RequestPedido;
import pe.edu.uls.demojpa.dominio.entity.registrarpedido.response.ResponsePedido;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
public class ControllerRegistrarPedido {

    ServiceRegistrarPedido serviceRegistrarPedido;

    public ControllerRegistrarPedido(ServiceRegistrarPedido serviceRegistrarPedido) {
        this.serviceRegistrarPedido = serviceRegistrarPedido;
    }

    @PostMapping("/pedido/nuevo")
    public ResponsePedido guardarPedido(@RequestBody RequestPedido pedido) {
        return serviceRegistrarPedido.registrarPedido(pedido);
    }
    
}
