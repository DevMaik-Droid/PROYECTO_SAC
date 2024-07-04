package com.venta.ventas.controllers;

import com.venta.ventas.models.Cliente;
import com.venta.ventas.models.Producto;
import com.venta.ventas.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.findAll();

    }

    @PostMapping("/save")
    public Cliente crearCliente(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

}
