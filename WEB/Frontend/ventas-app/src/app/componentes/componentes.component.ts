import { Component, OnInit, inject } from '@angular/core';
import { initFlowbite } from 'flowbite';
import { Producto } from '../models/Producto';
import { ProductoService } from '../service/producto.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-componentes',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './componentes.component.html',
  styleUrl: './componentes.component.css'
})
export default class ComponentesComponent implements OnInit {
  private productoService = inject(ProductoService)
  prod: Producto[] = []
  ngOnInit(): void {
    initFlowbite();
    this.productoService.listarProductos().subscribe(producto => {
      this.prod = producto
    })

  }
}

