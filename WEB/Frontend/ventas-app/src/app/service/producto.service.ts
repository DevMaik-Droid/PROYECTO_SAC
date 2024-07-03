import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Producto } from '../models/Producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

private http=inject(HttpClient);
listarProductos(){
  return this.http.get<Producto[]>('https://rqrw0pfs-8080.brs.devtunnels.ms/producto/listar');
}
}
