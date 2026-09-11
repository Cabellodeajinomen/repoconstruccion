package pe.edu.uls.demojpa;

import org.springframework.stereotype.Service;

@Service
public class ServiceRepuesto {

    private final RepositoryRepuesto repoRepuesto;

    public ServiceRepuesto(RepositoryRepuesto repoRepuesto) {
        this.repoRepuesto = repoRepuesto;
    }

    public Repuesto registrarRepuesto(Repuesto nuevo) {
        Repuesto repuesto = repoRepuesto.save(nuevo);
        return repuesto;
    }

    public Repuesto consultarRepuesto(int id) {
        return repoRepuesto.findById(id).get();
    }
}
