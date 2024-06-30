/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev_team.services;

import com.dev_team.models.Accesorios;
import com.dev_team.models.Componente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DevMaik
 */
public class Service_Accesorios implements I_Service {

    private final String TABLA = "tb_accesorios";

    @Override
    public boolean crear(Object objeto) {

        Connection cnt = Conexion.conectar();
        Accesorios accesorios = (Accesorios) objeto;
        String sql = String.format("INSERT INTO %s VALUES (?,?,?,?,?,?,?,?,?,?)", TABLA);

        try (PreparedStatement pst = cnt.prepareStatement(sql)) {
            pst.setInt(1, 0);//id
            pst.setString(2, accesorios.getNombre());
            pst.setString(3, accesorios.getMarca());
            pst.setString(4, accesorios.getDescripcion());
            pst.setBinaryStream(10, accesorios.getImagen());

            return pst.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e);
        }
        return false;

    }

    @Override
    public boolean actualizar(Object objeto, String L) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<?> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<?> listarClaves() {
        Connection cn = Conexion.conectar();
        List<Accesorios> accesorios = null;

        try {
            String sql = String.format("SELECT * FROM %s", TABLA);
            PreparedStatement pst = cn.prepareStatement(sql);

            ResultSet rst = pst.executeQuery();

            accesorios = new ArrayList<>();
            while (rst.next()) {
                Accesorios acc = new Accesorios();
                acc.setClaveAccesorio(rst.getString("claveAccesorio"));
                acc.setNombre(rst.getString("nombre"));
                accesorios.add(acc);
            }

        } catch (SQLException e) {
            System.out.println("Error listar Componentes: ".concat(e.getMessage()));
        }
        return accesorios;

    }

    public Accesorios buscarAccesorio(String clave) {

        Connection cn = Conexion.conectar();
        Accesorios accesorio = null;

        try {
            String sql = String.format("SELECT * FROM %s WHERE claveAccesorio = '%s'", TABLA,clave);
            PreparedStatement pst = cn.prepareStatement(sql);

            ResultSet rst = pst.executeQuery();
            
            while (rst.next()) {
                accesorio = new Accesorios();
                accesorio.setNombre(rst.getString("nombre"));
                accesorio.setMarca(rst.getString("marca"));
                accesorio.setModelo(rst.getString("modelo"));
                accesorio.setDescripcion(rst.getString("descripcion"));
               
            }
            cn.close();
            rst.close();

        } catch (SQLException e) {
            System.out.println("Error listar Componentes: ".concat(e.getMessage()));
        }
        return accesorio;

    }

    @Override
    public boolean eliminar(Long L) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
