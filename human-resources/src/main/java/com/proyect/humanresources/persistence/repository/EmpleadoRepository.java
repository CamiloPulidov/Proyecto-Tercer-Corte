package com.proyect.humanresources.persistence.repository;

import com.proyect.humanresources.domain.dto.Employee;
import com.proyect.humanresources.domain.repository.EmployeeRepository;
import com.proyect.humanresources.persistence.crud.EmpleadoCrudRepository;
import com.proyect.humanresources.persistence.entity.Empleado;
import com.proyect.humanresources.persistence.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadoRepository implements EmployeeRepository {

    @Autowired
    private EmpleadoCrudRepository empleadoCrudRepository;
    @Autowired
    private EmployeeMapper mapper;

    @Override
    public Employee findById(String id) {
        Empleado empleado=empleadoCrudRepository.findByIdOrderByNombreAsc(id);
        return mapper.toEmployee(empleado);
    }

    @Override
    public List<Employee> getAll() {
        List<Empleado> empleados=(List<Empleado>) empleadoCrudRepository.findAll();
        return mapper.toEmployees(empleados);
    }

    @Override
    public Employee save(Employee employee) {
        Empleado empleado=mapper.toEmpleado(employee);
        Empleado newEmpleado=empleadoCrudRepository.save(empleado);
        return mapper.toEmployee(newEmpleado);

    }

    @Override
    public void delete(String id) {
        Employee DeleteEmployee=findById(id);
        empleadoCrudRepository.delete(mapper.toEmpleado(DeleteEmployee));
    }

    @Override
    public List<String> allEmail() {
        return empleadoCrudRepository.findAllEmails();
    }

    @Override
    public String findContraseñaById(String id) {
        return empleadoCrudRepository.findContraseñaById(id);
    }

    @Override
    public Boolean humanResources(String id){
        return empleadoCrudRepository.humanResources(id);
    }

    @Override
    public void actualizarCelular(String id,  Long nuevoCelular){
        empleadoCrudRepository.actualizarCelular(id, nuevoCelular);
    }

    @Override
    public void actualizarCorreo(String id, String nuevoCorreo) {
        empleadoCrudRepository.actualizarCorreo(id, nuevoCorreo);
    }

    @Override
    public void actualizarContraseña(String id, String nuevaContrasena) {
        empleadoCrudRepository.actualizarContraseña(id, nuevaContrasena);
    }

    @Override
    public void actualizarDireccion(String id, String nuevaDir) {
        empleadoCrudRepository.actualizarDireccion(id, nuevaDir);
    }

}
