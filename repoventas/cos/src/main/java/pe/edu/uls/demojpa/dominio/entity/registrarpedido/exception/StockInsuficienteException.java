package pe.edu.uls.demojpa.dominio.entity.registrarpedido.exception;

public class StockInsuficienteException extends RuntimeException {

    public StockInsuficienteException(String message) {
        super(message);
    }
}
