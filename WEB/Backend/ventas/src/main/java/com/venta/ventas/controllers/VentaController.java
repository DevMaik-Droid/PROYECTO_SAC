package com.venta.ventas.controllers;


import com.venta.ventas.models.Cliente;
import com.venta.ventas.models.Producto;
import com.venta.ventas.models.Venta;
import com.venta.ventas.models.VentaRequest;
import com.venta.ventas.services.ClienteService;
import com.venta.ventas.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/venta")
public class VentaController {


    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public Venta crearVenta(@RequestBody VentaRequest ventaRequest){
        Cliente cliente = ventaRequest.getCliente();
        Producto producto = ventaRequest.getProducto();

        Optional<Cliente> c = clienteService.buscarNombreApellido(cliente.getNombre(), cliente.getApellido());
        Long id_cliente = 0L;
        if (c.isPresent()){
            id_cliente = c.get().getIdCliente();
        }else {
            cliente.setIdCliente(null);
            clienteService.save(cliente);
            id_cliente = clienteService.buscarNombreApellido(cliente.getNombre(), cliente.getApellido()).get().getIdCliente();
        }
        Venta venta = new Venta();
        venta.setCantidad(producto.getStock());
        venta.setPrecioUnitario(producto.getPrecioUnitario());
        venta.setTotal(producto.getStock() * producto.getPrecioUnitario());
        venta.setIdCliente(id_cliente);
        venta.setClaveP(producto.getClaveProducto());
        return ventaService.save(venta);
    }


}
