import { Component, OnInit, inject } from '@angular/core';
import { initFlowbite } from 'flowbite';
import { Producto } from '../models/Producto';
import { ProductoService } from '../service/producto.service';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { Cliente } from '../models/Cliente';
import { VentaService } from '../service/venta.service';

@Component({
  selector: 'app-laptop',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './laptop.component.html',
  styleUrl: './laptop.component.css',
})
export default class LaptopComponent implements OnInit {
  private ventaService = inject(VentaService);
  private router = inject(Router);
  private fb = inject(FormBuilder);

  form = this.fb.group({
    cliente: this.fb.group({
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      correoElectronico: ['', Validators.email],
      telefono: [''],
      departamento: [''],
      direccion: [''],
    }),
    producto: this.fb.group({
      claveProducto: ['', Validators.required],
      precioUnitario: ['', Validators.required],
      stock: ['', Validators.required],
    }),
  });

  cliente: any = {};
  producto: any = {};

  private productoService = inject(ProductoService);
  prod: Producto[] = [];
  ngOnInit(): void {
    initFlowbite();
    this.productoService.listarProductos().subscribe((producto) => {
      this.prod = producto;
    });
  }
  obtenerElementos(id_detalle: string, id_precio: string): void {
    let descripcion = document.getElementById(id_detalle)?.innerHTML;
    let precio = document.getElementById(id_precio)?.innerHTML;
    if (descripcion && precio != undefined) {
      this.cargarModal(descripcion, precio);
    }
  }
  cargarModal(detalle: string, precio: string) {
    let elemento_detalle = document.getElementById('detalle');
    let elemento_precio = document.getElementById(
      'precioModal'
    ) as HTMLInputElement;

    if (elemento_precio && elemento_detalle != undefined) {
      elemento_detalle.innerHTML = detalle;
      elemento_precio.value = precio;
    }
  }

  realizarVenta(): void {
    const venta = this.form.value;
    this.ventaService
      .crearVenta(venta.cliente, venta.producto)
      .subscribe((venta) => {
        this.router.navigate(['/computadora']);

      });
  }
}
