package com.venta.ventas.services;


import com.venta.ventas.models.Producto;

import java.util.List;
import java.util.Optional;

public interface I_ServiceProducto {

    List<Producto> listar_productos();

    Optional<Producto> buscar_producto(Long id);

    Producto guardar_producto(Producto producto);

    Optional<Producto> eliminar_producto(Producto producto);


}
