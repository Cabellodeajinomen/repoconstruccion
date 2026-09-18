package pe.edu.uls.demojpa.dominio.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.uls.demojpa.dominio.entity.Producto;

public interface RepoProducto extends JpaRepository<Producto, Integer> {

}
