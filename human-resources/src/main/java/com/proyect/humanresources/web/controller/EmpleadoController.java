package com.proyect.humanresources.web.controller;

import com.proyect.humanresources.domain.dto.Employee;
import com.proyect.humanresources.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{buscar}/user/{id}/con/{pass}")
    public Employee findById(@PathVariable("pass") String pass,@PathVariable("id") String id,@PathVariable("buscar") String buscar){
        boolean humanResource=humanResources(id);
        String contraseña=findContraseñaById(id);
        if(pass.equals(contraseña) && humanResource) {
            return employeeService.findById(buscar);
        }
        return null;
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping("/save/{id}/con/{pass}")
    public Employee save(@PathVariable("pass") String pass,@PathVariable("id") String id,@RequestBody Employee employee) {
        boolean humanResource=humanResources(id);
        String contraseña=findContraseñaById(id);
        if(pass.equals(contraseña) && humanResource) {
            return employeeService.save(employee);
        }
        return null;
    }

    @DeleteMapping("/borrar/{borrar}/use/{id}/con/{pass}")
    public void delete(@PathVariable("pass") String pass,@PathVariable("id") String id,@PathVariable("borrar") String borrar) {
        boolean humanResource=humanResources(id);
        String contraseña=findContraseñaById(id);
        if(pass.equals(contraseña) && humanResource) {
            employeeService.delete(borrar);
        }
    }

    public List<String> allEmail(String id) {
            return employeeService.allEmail();
    }


    public String findContraseñaById(@PathVariable("id") String id){
        return employeeService.findContraseñaById(id);
    }

    public Boolean humanResources(String id){
        return employeeService.humanResources(id);
    }

    @PutMapping("/cambio-numero/{id}/con/{pass}")
    public void actualizarCelular(@PathVariable("pass") String pass,@PathVariable("id") String id, @RequestBody Long nuevoCelular) {
        String contraseña=findContraseñaById(id);
        if(pass.equals(contraseña)){
            employeeService.actualizarCelular(id, nuevoCelular);
        }

    }

    @PutMapping("/cambio-correo/{id}/con/{pass}")
    public void actualizarCorreo(@PathVariable("pass") String pass,@PathVariable("id")String id, @RequestBody String nuevoCorreo) {
        String contraseña=findContraseñaById(id);
        if(pass.equals(contraseña)) {
            employeeService.actualizarCorreo(id, nuevoCorreo);
        }
    }

    @PutMapping("/cambio-contraseña/{id}/con/{pass}")
    public void actualizarContraseña(@PathVariable("pass") String pass,@PathVariable("id")String id,@RequestBody String nuevaContrasena) {
        String contraseña=findContraseñaById(id);
        if(pass.equals(contraseña)) {
            employeeService.actualizarContraseña(id, nuevaContrasena);
        }
    }

    @PutMapping("/cambio-direccion/{id}/con/{pass}")
    public void actualizarDireccion(@PathVariable("pass") String pass,@PathVariable("id")String id,@RequestBody String nuevaDir) {
        String contraseña=findContraseñaById(id);
        if(pass.equals(contraseña)) {
            employeeService.actualizarDireccion(id, nuevaDir);
        }
    }

}
