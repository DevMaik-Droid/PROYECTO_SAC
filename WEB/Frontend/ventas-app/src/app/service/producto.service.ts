import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Producto } from '../models/Producto';
import { Cliente } from '../models/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

private http=inject(HttpClient);
listarProductos(){
  return this.http.get<Producto[]>('https://rqrw0pfs-8080.brs.devtunnels.ms/producto/listar');
}

create(cliente : any){
  return this.http.post<Cliente>('http://localhost:8080/api/contacts', cliente)
}

}
