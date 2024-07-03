package com.dev_team.services;

import com.dev_team.models.Usuario;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Service_Usuario implements I_Service {

    
    
    //Registrar Usuario
    private final static String TABLA = "tb_usuario";
    
    @Override
    public boolean crear(Object objeto) {
        boolean respuesta = false;
        Usuario usuario = (Usuario) objeto;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_usuario values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, usuario.getNombre());
            consulta.setString(3, usuario.getApellido());
            consulta.setString(4, usuario.getCi());
            consulta.setDate(5, new Date(usuario.getFechaNacimiento().getTime()));
            consulta.setString(6, usuario.getTelefono());
            consulta.setString(7, usuario.getDireccion());
            consulta.setString(8, usuario.getUsuario());
            consulta.setString(9, usuario.getPassword());
            consulta.setBinaryStream(10, usuario.getFoto());
            consulta.setString(11, usuario.getClave());
            consulta.setString(12, usuario.getEstado().toUpperCase());
            consulta.setString(13, usuario.getObservaciones());
            consulta.setString(14, usuario.getNivel());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);
        }
        return respuesta;
    }


    public boolean existeUsuario(String usuario) {
        boolean respuesta = false;
        String sql = "select usuario from tb_usuario where usuario = '" + usuario + "';";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e);
        }
        return respuesta;
    }


    @Override
    public boolean eliminar(Long idUsuario) {
        Connection cn = Conexion.conectar();
        String sql = "CALL ELIMINAR_USUARIO(?)";
        
        try {
            CallableStatement cst = cn.prepareCall(sql);
            cst.setLong(1, idUsuario);
            
            cst.executeUpdate();
            cn.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e);
        }
        return false;
    }

    
    // Metodo para actulizar el registro
    @Override
    public boolean actualizar(Object objeto) {
       boolean respuesta = false;
       Usuario usuario = (Usuario) objeto;
        Connection cn = Conexion.conectar();
        String sql = String.format("update %s set nombre=?, apellido = ?,fecha_nacimiento = ?, telefono = ?, direccion = ?, usuario = ?, contrasenia= ?, foto = ?, estado = ?, nivel = ? where clave ='" + usuario.getClave() + "'", TABLA);
        try {

            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setString(1, usuario.getNombre());
            consulta.setString(2, usuario.getApellido());
            consulta.setDate(3, new Date(usuario.getFechaNacimiento().getTime()));
            consulta.setString(4, usuario.getTelefono());
            consulta.setString(5, usuario.getDireccion());
            consulta.setString(6, usuario.getUsuario());
            consulta.setString(7, usuario.getPassword());
            consulta.setBinaryStream(8, usuario.getFoto());
            consulta.setString(9, usuario.getEstado());
            consulta.setString(10, usuario.getNivel());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e);
        }
        return respuesta;
    }

    @Override
    public List<?> listar() {
        List<Usuario> lista_usuarios = null;
        try(Connection cn = Conexion.conectar()){
            
            String sql = String.format("SELECT * FROM %s", TABLA);
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            lista_usuarios = new ArrayList<>();
            
            while(rst.next()){
                Usuario us = new Usuario();
                us.setIdUsuario(rst.getLong("idUsuario"));
                us.setNombre(rst.getString("nombre"));
                us.setApellido(rst.getString("apellido"));
                us.setCi(rst.getString("ci"));
                us.setFechaNacimiento(rst.getDate("fecha_nacimiento"));
                us.setTelefono(rst.getString("telefono"));
                us.setDireccion(rst.getString("direccion"));
                us.setUsuario(rst.getString("usuario"));
                us.setPassword(rst.getString("contrasenia"));
                us.setBytes_image(rst.getBytes("foto"));
                us.setClave(rst.getString("clave"));
                us.setEstado(rst.getString("estado"));
                us.setObservaciones(rst.getString("observaciones"));
                us.setNivel(rst.getString("nivel"));
                lista_usuarios.add(us);
            }
            cn.close();
        }catch(SQLException e){
            
        }
       
        return lista_usuarios;
    }
}
