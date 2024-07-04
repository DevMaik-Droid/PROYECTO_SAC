import { Component, OnInit,inject } from '@angular/core';
import { initFlowbite } from 'flowbite';
import { Producto } from '../models/Producto';
import { ProductoService } from '../service/producto.service';

@Component({
  selector: 'app-accesorios',
  standalone: true,
  imports: [],
  templateUrl: './accesorios.component.html',
  styleUrl: './accesorios.component.css'
})
export default class AccesoriosComponent implements OnInit{
  private productoService = inject(ProductoService)
  prod: Producto []=[] 
  ngOnInit(): void {
    initFlowbite();
    this.productoService.listarProductos().subscribe(producto => {
    this.prod = producto
    })

  }
}
