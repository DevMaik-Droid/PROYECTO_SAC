/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev_team.services;

import com.dev_team.models.Accesorios;
import com.dev_team.models.Componente;
import com.dev_team.models.Laptop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DevMaik
 */
public class Service_Laptop implements I_Service{

    private final String TABLA = "tb_laptop";
    @Override
    public boolean crear(Object objeto) {
       
        Connection cn = Conexion.conectar();
        Laptop laptop = (Laptop) objeto;
        String sql = String.format("INSERT INTO %s (claveLaptop, nombre,marca,modelo,procesador, memoriaRam, almacenamiento, conectividad, tarjetaGrafica, pantalla, bateria, imagen, descripcion)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)", TABLA);

        try (PreparedStatement consulta = cn.prepareStatement(sql)) {
            consulta.setString(1, laptop.getClaveLaptop());
            consulta.setString(2, laptop.getNombre());
            consulta.setString(3, laptop.getMarca());
            consulta.setString(4, laptop.getModelo());
            consulta.setString(5, laptop.getProcesador());
            consulta.setString(6, laptop.getMemoriaRam());
            consulta.setString(7, laptop.getAlmacenamiento());
            consulta.setString(8, laptop.getConectividad());
            consulta.setString(9, laptop.getTarjetaGrafica());
            consulta.setString(10, laptop.getPantalla());
            consulta.setString(11, laptop.getBateria());
            consulta.setBinaryStream(12, laptop.getImagen());
            consulta.setString(13, laptop.getDescripcion());
            
            return consulta.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Service_Componente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
        
        
    
    }

    @Override
    public boolean actualizar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<?> listar() {
        Connection cn = Conexion.conectar();
        List<Laptop> lista_laptops = null;
        try {
            String sql = String.format("SELECT * FROM %s", TABLA);
            PreparedStatement pst = cn.prepareStatement(sql);

            ResultSet rst = pst.executeQuery();

            lista_laptops = new ArrayList<>();
            while (rst.next()) {
                Laptop laptop = new Laptop();
                laptop.setIdLaptop(rst.getInt(1));
                laptop.setClaveLaptop(rst.getString(2));
                laptop.setNombre(rst.getString(3));
                laptop.setMarca(rst.getString(4));
                laptop.setModelo(rst.getString(5));
                laptop.setProcesador(rst.getString(6));
                laptop.setMemoriaRam(rst.getString(7));
                laptop.setAlmacenamiento(rst.getString(8));
                laptop.setConectividad(rst.getString(9));
                laptop.setPantalla(rst.getString(10));
                laptop.setBateria(rst.getString(11));
                laptop.setBytes_image(rst.getBytes(12));
                laptop.setDescripcion(rst.getString(13));
                laptop.setFechaCreacion(rst.getDate(14));
                lista_laptops.add(laptop);
                
            }

        } catch (SQLException e) {
            System.out.println("Error listar Componentes: ".concat(e.getMessage()));
        }
        return lista_laptops;
    
    }

    @Override
    public boolean eliminar(Long L) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        public List<?> listarClaves() {
        Connection cn = Conexion.conectar();
        List<Laptop> laptops = null;

        try {
            String sql = String.format("SELECT * FROM %s", TABLA);
            PreparedStatement pst = cn.prepareStatement(sql);

            ResultSet rst = pst.executeQuery();

            laptops = new ArrayList<>();
            while (rst.next()) {
                Laptop laptop = new Laptop();
                laptop.setClaveLaptop(rst.getString("claveLaptop"));
                laptop.setNombre(rst.getString("nombre"));
                laptops.add(laptop);
            }

        } catch (SQLException e) {
            System.out.println("Error listar Componentes: ".concat(e.getMessage()));
        }
        return laptops;

    }
        
    public Laptop buscarLaptop(String clave) {

        Connection cn = Conexion.conectar();
        Laptop laptop = null;

        try {
            String sql = String.format("SELECT * FROM %s WHERE claveLaptop = '%s'", TABLA,clave);
            PreparedStatement pst = cn.prepareStatement(sql);

            try (ResultSet rst = pst.executeQuery()) {
                
                while (rst.next()) {
                    laptop = new Laptop();
                    laptop.setNombre(rst.getString("nombre"));
                    laptop.setMarca(rst.getString("marca"));
                    laptop.setModelo(rst.getString("modelo"));
                    laptop.setProcesador(rst.getString("procesador"));
                    laptop.setMemoriaRam(rst.getString("memoriaRam"));
                    laptop.setAlmacenamiento(rst.getString("almacenamiento"));
                    laptop.setTarjetaGrafica(rst.getString("tarjetaGrafica"));
                    laptop.setPantalla(rst.getString("pantalla"));
                    
                    
                }
                cn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error listar Componentes: ".concat(e.getMessage()));
        }
        return laptop;
    }
    
}
