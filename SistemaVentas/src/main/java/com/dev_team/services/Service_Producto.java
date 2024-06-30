package com.dev_team.services;

import com.dev_team.models.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Service_Producto implements I_Service {

    /**
     * ********************************************************************
     * metodo para consultar si el producto ya esta registrado en la BBDDcomo
     * ********************************************************************
     */
    
    private final String TABLA = "tb_productos";
    
    
    public boolean existeProducto(String clave) {
        String sql = String.format("SELECT nombreProducto FROM '%s' WHERE claveProducto = '%s'", TABLA,clave);
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar producto: " + e);
        }
        return false;
    }
    

    @Override
    public boolean crear(Object objeto) {
        Connection cn = Conexion.conectar();
        Producto producto = (Producto) objeto;
        String sql = String.format("INSERT INTO %s (claveProducto,nombreProducto,categoriaProducto,precioUnitario,stock, precioTotal,idProveedor,idUsuario,detalle) VALUES (?,?,?,?,?,?,?,?,?)", TABLA);
        try {

            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setString(1, producto.getClaveProducto());
            consulta.setString(2, producto.getNombreProducto());
            consulta.setString(3, producto.getCategoriaProducto());
            consulta.setDouble(4, producto.getPrecioUnitario());
            consulta.setInt(5, producto.getStock());
            consulta.setDouble(6, producto.getPrecioTotal());
            consulta.setLong(7, producto.getIdProveedor());
            consulta.setLong(8, producto.getIdUsuario());
            consulta.setString(9, producto.getDetalle());
            if (consulta.executeUpdate() > 0) {
                return true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar producto: " + e);
        }

        return false;
    }

   /* @Override
    public boolean actualizar(Object objeto, Long L) {
       boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_producto set nombre=?, cantidad = ?, precio = ?, descripcion= ?, porcentajeIva = ?, idCategoria = ?, estado = ? where idProducto ='" + idProducto + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setInt(2, objeto.getCantidad());
            consulta.setDouble(3, objeto.getPrecio());
            consulta.setString(4, objeto.getDescripcion());
            consulta.setInt(5, objeto.getPorcentajeIva());
            consulta.setInt(6, objeto.getIdCategoria());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e);
        }
        return respuesta;    }
*/
    @Override
    public List<?> listar() {
        List<Producto> lista= new ArrayList<>();
        Connection cn = Conexion.conectar();
        String sql = String.format("SELECT * FROM %s", TABLA);
        try {
            
            PreparedStatement consulta = cn.prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {     
                Producto p = new Producto();
                p.setIdProducto(resultado.getLong(1));
                p.setClaveProducto(resultado.getString(2));
                p.setNombreProducto(resultado.getString(3));
                p.setCategoriaProducto(resultado.getString(4));
                p.setPrecioUnitario(resultado.getDouble(5));
                p.setStock(resultado.getInt(6));
                p.setPrecioTotal(resultado.getDouble(7));
                p.setDisponibilidad(resultado.getString(8));
                p.setIdProveedor(resultado.getLong(9));
                p.setIdUsuario(resultado.getLong(10));
                p.setDetalle(resultado.getString(11));
                p.setFechaModicacion(resultado.getTimestamp(12));
                lista.add(p);
            }
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error en listar productos: "+ex.getMessage());
        }
        return lista;
    }
    
    public Boolean actualizarStock(Long id,int cantidad,int stock){
        
        Connection cn = Conexion.conectar();
        String disponible;
        int nuevoStock = stock-cantidad;
        if(nuevoStock >= 5){
            disponible = "DISPONIBLE";
        }else if(nuevoStock == 0){
            disponible = "AGOTADO";
        }else{
            disponible = "POR AGOTAR";
        }
        
        
        String sql = String.format("UPDATE %s SET stock=stock-%d, disponibilidad='%s' WHERE idp = %d", TABLA,cantidad,disponible,id);
        try(PreparedStatement pst = cn.prepareStatement(sql)){
            
            return pst.executeUpdate() > 0;
            
        }catch(SQLException e){
            System.out.println("error en actualizar stock: " + e);
        }
        return false;
    }
            

    @Override
    public boolean eliminar(Long idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_producto where idProducto ='" + idProducto + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e);
        }
        return respuesta;
    }

    @Override
    public boolean actualizar(Object objeto, String L) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
