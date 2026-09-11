package pe.edu.uls.demojpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRepuesto {
    private final ServiceRepuesto serviceRepuesto;
    private final MapperRepuesto mapperRepuesto;

    public ControllerRepuesto(ServiceRepuesto serviceRepuesto, MapperRepuesto mapperRepuesto) {
        this.serviceRepuesto = serviceRepuesto;
        this.mapperRepuesto = mapperRepuesto;
    }

    @PostMapping("/repuesto/nuevo")
    public ResponseRepuesto guardarRepuesto(@RequestBody RequestRepuesto nuevo) {
        Repuesto repuesto = mapperRepuesto.toRepuesto(nuevo);
        repuesto = serviceRepuesto.registrarRepuesto(repuesto);
        ResponseRepuesto response = mapperRepuesto.toResponse(repuesto);
        return response;
    }
    
	@GetMapping("/repuesto/{id}")
    public ResponseRepuesto consultarRepuesto(@PathVariable(name = "id") int id) {
        return mapperRepuesto.toResponse(serviceRepuesto.consultarRepuesto(id));
    }
    

}