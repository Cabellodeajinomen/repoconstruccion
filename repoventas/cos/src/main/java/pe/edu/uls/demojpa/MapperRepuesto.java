package pe.edu.uls.demojpa;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface MapperRepuesto {

    @Mapping(target = "id", ignore = true)
    Repuesto toRepuesto(RequestRepuesto request);

    ResponseRepuesto toResponse(Repuesto repuesto);
}
