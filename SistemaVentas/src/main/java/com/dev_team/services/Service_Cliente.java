package com.dev_team.services;

import com.dev_team.models.Cliente;
import com.dev_team.models.Componente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Service_Cliente implements I_Service{

    
    private final String TABLA = "tb_cliente";
    
    public boolean guardar(Cliente objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_cliente values(?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e);
        }
        return respuesta;
    }

    /**
     * ********************************************************************
     * metodo para consultar si el producto ya esta registrado en la BBDD
     * ********************************************************************
     */
    public boolean existeCliente(String cedula) {
        boolean respuesta = false;
        String sql = "select cedula from tb_cliente where cedula = '" + cedula + "';";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar cliente: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para actualizar un cliente
     * **************************************************
     */
    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_cliente set nombre=?, apellido = ?, cedula = ?, telefono= ?, direccion = ?, estado = ? where idCliente ='" + idCliente + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
           
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para eliminar un cliente
     * **************************************************
     */
    public boolean eliminar(int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_cliente where idCliente ='" + idCliente + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e);
        }
        return respuesta;
    }

    @Override
    public boolean crear(Object objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        Cliente cliente = (Cliente) objeto;
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_cliente values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, cliente.getNombre());
            consulta.setString(3, cliente.getApellido());
            consulta.setString(4, cliente.getEmail());
            consulta.setString(5, cliente.getTelefono());
            consulta.setString(6, cliente.getDepartamento());
            consulta.setString(7, cliente.getDireccion());
            consulta.setString(8, cliente.getEstado());
            
            
            respuesta = consulta.executeUpdate() > 0;
            cn.close();
            
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e);
        }
        return respuesta;
    
    }

    @Override
    public boolean actualizar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<?> listar() {
        
        Connection cn = Conexion.conectar();
        List<Cliente> list_cliente = null;
        try {
            String sql = String.format("SELECT * FROM %s", TABLA);
            PreparedStatement pst = cn.prepareStatement(sql);

            ResultSet rst = pst.executeQuery();

            list_cliente = new ArrayList<>();
            while (rst.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rst.getLong(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellido(rst.getString(3));
                cliente.setEmail(rst.getString(4));
                cliente.setTelefono(rst.getString(5));
                cliente.setDepartamento(rst.getString(6));
                cliente.setDireccion(rst.getString(7));
                cliente.setEstado(rst.getString(8));
                list_cliente.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Error listar Componentes: ".concat(e.getMessage()));
        }
        return list_cliente;
    
    }

    @Override
    public boolean eliminar(Long L) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
        
        
    
}
