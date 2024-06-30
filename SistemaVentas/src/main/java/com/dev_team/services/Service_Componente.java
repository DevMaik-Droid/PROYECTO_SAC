package com.dev_team.services;

import com.dev_team.models.Componente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Service_Componente implements I_Service {

    private final String TABLA = "tb_componente";

    @Override
    public boolean crear(Object objeto) {
        Connection cn = Conexion.conectar();
        Componente componenteonente = (Componente) objeto;
        String sql = String.format("INSERT INTO %s (claveComponente, nombre,marca,modelo,capacidad,velocidad,imagen,descripcion)  VALUES (?,?,?,?,?,?,?,?)", TABLA);

        try (PreparedStatement consulta = cn.prepareStatement(sql)) {
            consulta.setString(1, componenteonente.getClave());
            consulta.setString(2, componenteonente.getNombre());
            consulta.setString(3, componenteonente.getMarca());
            consulta.setString(4, componenteonente.getModelo());
            consulta.setString(5, componenteonente.getCapacidad());
            consulta.setString(6, componenteonente.getVelocidad());
            consulta.setBinaryStream(7, componenteonente.getImagen());
            consulta.setString(8, componenteonente.getDescripcion());
            
            return consulta.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(Service_Componente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }


    @Override
    public boolean actualizar(Object objeto, String L) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<?> listar() {
        Connection cn = Conexion.conectar();
        List<Componente> componenteonente = null;
        try {
            String sql = String.format("SELECT * FROM %s", TABLA);
            PreparedStatement pst = cn.prepareStatement(sql);

            ResultSet rst = pst.executeQuery();

            componenteonente = new ArrayList<>();
            while (rst.next()) {
                Componente componente = new Componente();
                componente.setIdComponente(rst.getInt("idc"));
                componente.setClave(rst.getString("claveComponente"));
                componente.setNombre(rst.getString("nombre"));
                componente.setMarca(rst.getString("marca"));
                componente.setModelo(rst.getString("modelo"));
                componente.setCapacidad(rst.getString("capacidad"));
                componente.setVelocidad(rst.getString("velocidad"));
                componenteonente.add(componente);
            }

        } catch (SQLException e) {
            System.out.println("Error listar Componentes: ".concat(e.getMessage()));
        }
        return componenteonente;
    }
    
    public List<?> listarClaves() {
        
        Connection cn = Conexion.conectar();
        List<Componente> componenteonente = null;
        try {
            String sql = String.format("SELECT * FROM %s", TABLA);
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            componenteonente = new ArrayList<>();
            while (rst.next()) {
                Componente componente = new Componente();
                componente.setClave(rst.getString("claveComponente"));
                componente.setNombre(rst.getString("nombre"));
                componenteonente.add(componente);
            }

        } catch (SQLException e) {
            System.out.println("Error listar Componentes: ".concat(e.getMessage()));
        }
        return componenteonente;
    }

    @Override
    public boolean eliminar(Long L) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Componente buscarCompenente(String clave){
        Connection cn = Conexion.conectar();
        Componente componente = null;
        try {
            String sql = String.format("SELECT * FROM %s WHERE claveComponente = '%s'", TABLA,clave);
            PreparedStatement pst = cn.prepareStatement(sql);

            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                componente = new Componente();
                componente.setNombre(rst.getString("nombre"));
                componente.setMarca(rst.getString("marca"));
                componente.setModelo(rst.getString("modelo"));
                componente.setCapacidad(rst.getString("capacidad"));
                componente.setVelocidad(rst.getString("velocidad"));
            }

        } catch (SQLException e) {
            System.out.println("Error listar Componentes: ".concat(e.getMessage()));
        }
        return componente;
    }

}
