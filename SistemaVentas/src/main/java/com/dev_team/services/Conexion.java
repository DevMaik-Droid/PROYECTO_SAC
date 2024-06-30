package com.dev_team.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    
    
    private static final String DATA_BASE = "bd_sistema_ventas";
    private static final String HOST = "localhost";
    private static final String USER= "root";
    private static final String PASSWORD = "";
    private static final String PUERTO = "3306";
    
    private static Connection cn;
    
    //conexion local
    public static Connection conectar()   {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = String.format("jdbc:mysql://%s:%s/%s?useSSL=true", HOST, PUERTO, DATA_BASE);
           
            cn = DriverManager.getConnection(url, USER, PASSWORD);
            
        } catch (SQLException |ClassNotFoundException e) {
            System.out.println("Error en la conexion local " + e);
        }
        return cn;
    }
}