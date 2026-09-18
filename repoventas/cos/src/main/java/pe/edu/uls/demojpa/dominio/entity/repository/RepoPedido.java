package pe.edu.uls.demojpa.dominio.entity.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.uls.demojpa.dominio.entity.Pedido;
public interface RepoPedido extends JpaRepository<Pedido, Integer> {

}
