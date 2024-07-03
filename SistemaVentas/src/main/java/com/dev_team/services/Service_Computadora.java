package com.dev_team.services;

import com.dev_team.models.Computadora;
import com.dev_team.models.Laptop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service_Computadora implements I_Service {

    private final String TABLA = "tb_computadora";

    @Override
    public boolean crear(Object objeto) {

        Connection cn = Conexion.conectar();
        Computadora computadora = (Computadora) objeto;
        String sql = String.format("INSERT INTO %s (claveComputadora, nombre,procesador,placaMadre, memoriaRam, almacenamiento, tarjetaGrafica, fuente, ccase, monitor, disipadores,ventiladores,imagen, precioReal, descripcion)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", TABLA);

        try (PreparedStatement consulta = cn.prepareStatement(sql)) {
            consulta.setString(1, computadora.getClaveComputadora());
            consulta.setString(2, computadora.getNombre());
            consulta.setString(3, computadora.getProcesador());
            consulta.setString(4, computadora.getPlacaMadre());
            consulta.setString(5, computadora.getMemoriaRam());
            consulta.setString(6, computadora.getAlmacenamiento());
            consulta.setString(7, computadora.getTarjeta());
            consulta.setString(8, computadora.getFuente());
            consulta.setString(9, computadora.getCcase());
            consulta.setString(10, computadora.getMonitor());
            consulta.setString(11, computadora.getDisipador());
            consulta.setString(12, computadora.getVentilador());
            consulta.setBinaryStream(13, computadora.getImagen());
            consulta.setDouble(14, computadora.getPrecio());
            consulta.setString(15, computadora.getDescripcion());

            return consulta.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error en crear, service");
        }

        return false;

    }

    public Computadora buscarComputadora(String clave) {
        Connection cn = Conexion.conectar();
        Computadora computadora = null;

        try {
            String sql = String.format("SELECT * FROM %s WHERE claveComputadora = '%s'", TABLA, clave);
            PreparedStatement pst = cn.prepareStatement(sql);

            try (ResultSet rst = pst.executeQuery()) {

                while (rst.next()) {
                    computadora = new Computadora();
                    computadora.setNombre(rst.getString("nombre"));
                    computadora.setProcesador(rst.getString("procesador"));
                    computadora.setPlacaMadre(rst.getString("placaMadre"));
                    computadora.setMemoriaRam(rst.getString("memoriaRam"));
                    computadora.setAlmacenamiento(rst.getString("almacenamiento"));
                    computadora.setTarjeta(rst.getString("tarjetaGrafica"));
                    computadora.setFuente(rst.getString("fuente"));
                    computadora.setCcase(rst.getString("ccase"));
                    computadora.setMonitor(rst.getString("monitor"));
                    computadora.setDisipador(rst.getString("disipadores"));
                    computadora.setVentilador(rst.getString("ventiladores"));
                    computadora.setPrecio(rst.getDouble("precioReal"));

                }
                cn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error listar Componentes: ".concat(e.getMessage()));
        }
        return computadora;

    }

    @Override
    public boolean actualizar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<?> listar() {
        Connection cn = Conexion.conectar();
        List<Computadora> list_Computadoras = null;
        Computadora computadora = null;

        try {
            String sql = String.format("SELECT * FROM %s", TABLA);
            PreparedStatement pst = cn.prepareStatement(sql);

            try (ResultSet rst = pst.executeQuery()) {
                
                list_Computadoras = new ArrayList<>();

                while (rst.next()) {
                    computadora = new Computadora();
                    computadora.setIdComputadora(rst.getInt("idComputadora"));
                    computadora.setClaveComputadora(rst.getString("claveComputadora"));
                    computadora.setNombre(rst.getString("nombre"));
                    computadora.setProcesador(rst.getString("procesador"));
                    computadora.setPlacaMadre(rst.getString("placaMadre"));
                    computadora.setMemoriaRam(rst.getString("memoriaRam"));
                    computadora.setAlmacenamiento(rst.getString("almacenamiento"));
                    computadora.setTarjeta(rst.getString("tarjetaGrafica"));
                    computadora.setFuente(rst.getString("fuente"));
                    computadora.setCcase(rst.getString("ccase"));
                    computadora.setMonitor(rst.getString("monitor"));
                    computadora.setDisipador(rst.getString("disipadores"));
                    computadora.setVentilador(rst.getString("ventiladores"));
                    computadora.setPrecio(rst.getDouble("precioReal"));
                    computadora.setDescripcion(rst.getString("descripcion"));
                    computadora.setFechaCreacion(rst.getDate("fechaCreacion"));
                    list_Computadoras.add(computadora);
                }
                cn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error listar Componentes: ".concat(e.getMessage()));
        }
        return list_Computadoras;
    
    
    }

    @Override
    public boolean eliminar(Long L) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
