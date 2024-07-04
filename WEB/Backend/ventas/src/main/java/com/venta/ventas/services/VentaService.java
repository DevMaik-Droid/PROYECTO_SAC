package com.venta.ventas.services;

import com.venta.ventas.models.Venta;
import com.venta.ventas.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Transactional
    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }
}
