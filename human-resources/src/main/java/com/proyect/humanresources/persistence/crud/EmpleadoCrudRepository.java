package com.proyect.humanresources.persistence.crud;

import com.proyect.humanresources.persistence.entity.Empleado;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmpleadoCrudRepository extends CrudRepository<Empleado, Integer> {

    Empleado findByIdOrderByNombreAsc(String id);

    @Query("SELECT e.correoElectronico FROM Empleado e")
    List<String> findAllEmails();

    @Query("SELECT e.contraseña FROM Empleado e WHERE e.id = :id")
    String findContraseñaById(String id);

    @Query("SELECT e.recursosHumanos FROM Empleado e WHERE e.id = :id")
    Boolean humanResources(String id);

    @Transactional
    @Modifying
    @Query("UPDATE Empleado e SET e.celular = :nuevoCelular WHERE e.id = :id")
    void actualizarCelular(@Param("id") String id, @Param("nuevoCelular") Long nuevoCelular);

    @Transactional
    @Modifying
    @Query("UPDATE Empleado e SET e.correoElectronico = :nuevoCorreo WHERE e.id = :id")
    void actualizarCorreo(@Param("id") String id, @Param("nuevoCorreo") String nuevoCorreo);

    @Transactional
    @Modifying
    @Query("UPDATE Empleado e SET e.contraseña = :nuevaContraseña WHERE e.id = :id")
    void actualizarContraseña(@Param("id") String id, @Param("nuevaContraseña") String nuevaContraseña);

    @Transactional
    @Modifying
    @Query("UPDATE Empleado e SET e.direccion = :nuevaDir WHERE e.id = :id")
    void actualizarDireccion(@Param("id") String id, @Param("nuevaDir") String nuevaDir);

}
