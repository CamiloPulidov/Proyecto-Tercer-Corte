package com.proyect.humanresources.domain.repository;

import com.proyect.humanresources.domain.dto.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee findById(String id);
    List<Employee> getAll();
    Employee save(Employee employee);
    void delete(String id);
    List<String> allEmail();
    String findContraseñaById(String id);
    Boolean humanResources(String id);
    void actualizarCelular(String id,  Long nuevoCelular);
    void actualizarCorreo(String id,  String nuevoCorreo);
    void actualizarContraseña(String id,  String nuevaContrasena);
    void actualizarDireccion(String id,  String nuevaDir);


}
