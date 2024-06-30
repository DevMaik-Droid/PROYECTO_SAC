package com.venta.ventas.services;


import com.venta.ventas.models.Producto;
import com.venta.ventas.repositories.Repository_Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProducto implements I_ServiceProducto {



    @Autowired
    private Repository_Productos repository;

    @Transactional(readOnly = true)
    @Override
    public List<Producto> listar_productos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Producto> buscar_producto(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Producto guardar_producto(Producto producto) {
        return repository.save(producto);
    }

    @Transactional
    @Override
    public Optional<Producto> eliminar_producto(Producto producto) {
        Optional<Producto> productoOptional = repository.findById(producto.getIdProducto());
        productoOptional.ifPresent(pro -> {
            repository.delete(pro);
        });
        return productoOptional;
    }
}
