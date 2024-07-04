import { Component, OnInit,inject } from '@angular/core';
import { initFlowbite } from 'flowbite';
import { Producto } from '../models/Producto';
import { ProductoService } from '../service/producto.service';

@Component({
  selector: 'app-laptop',
  standalone: true,
  imports: [],
  templateUrl: './laptop.component.html',
  styleUrl: './laptop.component.css'
})
export default class LaptopComponent implements OnInit{
  private productoService = inject(ProductoService)
  prod: Producto []=[] 
  ngOnInit(): void {
    initFlowbite();
    this.productoService.listarProductos().subscribe(producto => {
    this.prod = producto
    })
}
}