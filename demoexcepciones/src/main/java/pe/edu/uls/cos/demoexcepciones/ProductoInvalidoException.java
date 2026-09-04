package pe.edu.uls.cos.demoexcepciones;

public class ProductoInvalidoException extends RuntimeException{

    public ProductoInvalidoException(String msg) {
        super(msg);
    }
}
