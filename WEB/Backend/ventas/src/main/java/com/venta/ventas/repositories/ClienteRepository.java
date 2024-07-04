package com.venta.ventas.repositories;

import com.venta.ventas.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT e FROM Cliente e WHERE e.nombre = :nombre AND e.apellido = :apellido")
    Optional<Cliente> findByNombreAndApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);
}

