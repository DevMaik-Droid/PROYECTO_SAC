import { inject, Injectable } from '@angular/core';
import { Cliente } from '../models/Cliente';
import { Producto } from '../models/Producto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VentaService {

  private http = inject(HttpClient);
  

  crearVenta(cliente: any, producto: any){

    const venta = {cliente, producto};
    return  this.http.post<any>("http://localhost:8080/venta",venta);
  }


}
