package pe.edu.uls.cos.demoexcepciones;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperProducto {
    Producto toProducto(RequestProducto request);
}
