import { Component, OnInit, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { initFlowbite } from 'flowbite';
import { ProductoService } from '../service/producto.service';
import { Producto } from '../models/Producto';

@Component({
  selector: 'app-computadoras',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './computadoras.component.html',
  styleUrl: './computadoras.component.css'
})
export default class ComputadorasComponent implements OnInit {
  private productoService = inject(ProductoService)
  prod: Producto []=[] 
  ngOnInit(): void {
    initFlowbite();
    this.productoService.listarProductos().subscribe(producto => {
    this.prod = producto
    })

  }
}
