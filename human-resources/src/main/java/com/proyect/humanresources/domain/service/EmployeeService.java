package com.proyect.humanresources.domain.service;

import com.proyect.humanresources.domain.dto.Employee;
import com.proyect.humanresources.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById(String id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(String id) {
        employeeRepository.delete(id);
    }

    public List<String> allEmail() {
        return employeeRepository.allEmail();
    }

    public String findContraseñaById(String id) {
        return employeeRepository.findContraseñaById(id);
    }

    public Boolean humanResources(String id){
        return employeeRepository.humanResources(id);
    }

    public void actualizarCelular(String id,  Long nuevoCelular){
        employeeRepository.actualizarCelular(id, nuevoCelular);
    }

    public void actualizarCorreo(String id, String nuevoCorreo) {
        employeeRepository.actualizarCorreo(id, nuevoCorreo);
    }

    public void actualizarContraseña(String id, String nuevaContrasena) {
        employeeRepository.actualizarContraseña(id, nuevaContrasena);
    }

    public void actualizarDireccion(String id, String nuevaDir) {
        employeeRepository.actualizarDireccion(id, nuevaDir);
    }
}
