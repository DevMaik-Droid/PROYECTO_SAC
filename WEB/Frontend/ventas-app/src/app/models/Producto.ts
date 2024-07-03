export interface Producto {
  idProducto: number
  claveproducto: string
  nombreProducto: string
  categoriaProducto: string
  precioUnitario: string
  stock: string
  precioTotal: number
  disponibilidad: string
  idProveedor: string
  idUsuario: number
  detalle?: string
  fechaModificacion: string
}
