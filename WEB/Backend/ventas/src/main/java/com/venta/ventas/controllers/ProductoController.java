package com.venta.ventas.controllers;


import com.venta.ventas.models.Producto;
import com.venta.ventas.services.ServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/producto")
public class ProductoController {


    @Autowired
    ServiceProducto serviceProducto;

    @GetMapping("/listar")
    public List<Producto> obtenerProductos(){
        return serviceProducto.listar_productos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Long id){
        Optional<Producto> productoOptional = serviceProducto.buscar_producto(id);
        if(productoOptional.isPresent()){
            return ResponseEntity.ok(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
