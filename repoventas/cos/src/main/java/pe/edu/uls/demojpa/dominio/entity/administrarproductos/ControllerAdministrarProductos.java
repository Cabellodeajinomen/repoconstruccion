package pe.edu.uls.demojpa.dominio.entity.administrarproductos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uls.demojpa.dominio.entity.administrarproductos.request.RequestAjusteStock;
import pe.edu.uls.demojpa.dominio.entity.administrarproductos.request.RequestProducto;
import pe.edu.uls.demojpa.dominio.entity.administrarproductos.response.ResponseProducto;

@RestController
public class ControllerAdministrarProductos {

    private final ServiceAdministrarProductos service;

    public ControllerAdministrarProductos(ServiceAdministrarProductos service) {
        this.service = service;
    }

    @PostMapping("/producto/marca/{idMarca}/nuevo")
    public ResponseProducto registrarProducto(
            @PathVariable int idMarca,
            @RequestBody RequestProducto request) {
        return ResponseProducto.from(service.registrarProducto(idMarca, request));
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseProducto consultarProducto(@PathVariable int idProducto) {
        return ResponseProducto.from(service.consultarProducto(idProducto));
    }

    @PostMapping("/producto/stock/ajuste")
    public ResponseProducto ajustarStock(@RequestBody RequestAjusteStock request) {
        return ResponseProducto.from(service.ajustarStock(request));
    }
}
