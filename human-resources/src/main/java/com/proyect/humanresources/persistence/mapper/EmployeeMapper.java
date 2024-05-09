package com.proyect.humanresources.persistence.mapper;

import com.proyect.humanresources.domain.dto.Employee;
import com.proyect.humanresources.persistence.entity.Empleado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mappings({
            @Mapping(source ="nombre",target = "name"),
            @Mapping(source ="apellido",target = "surname"),
            @Mapping(source ="celular",target = "phoneNumber"),
            @Mapping(source ="direccion",target = "direction"),
            @Mapping(source ="correoElectronico",target = "emailEmployee"),
            @Mapping(source ="salario",target = "salary"),
            @Mapping(source ="cargo",target = "work"),
            @Mapping(source ="estado",target = "active"),
            @Mapping(source ="recursosHumanos",target = "humanResources"),
            @Mapping(source ="contraseña",target = "password"),


    })
    Employee toEmployee(Empleado empleado);
    List<Employee> toEmployees(List<Empleado> empleado);

    @InheritInverseConfiguration
    Empleado toEmpleado(Employee empleado);

}
