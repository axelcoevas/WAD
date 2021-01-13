/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author axel_
 */
public class Conexion {

    public Connection con;

    public Conexion() {

    }

//    public Connection obtenerConexion() {
//        String user = "glugwpvgymafae";
//        String pwd = "8d4b6604c34543c65f485eb53f46397d083ecb7087e4f52cfab3802318b697b5";
//        String url = "jdbc:postgresql://ec2-34-232-24-202.compute-1.amazonaws.com:5432/d5fv8dcb687m13?sslmode=require";
//        String mySQLDriver = "org.postgresql.Driver";
//
//        try {
//            Class.forName(mySQLDriver);
//            con = DriverManager.getConnection(url, user, pwd);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return con;
//    }

    public Connection obtenerConexion() {
        String user = "postgres";
        String pwd = "olakase";
        String url = "jdbc:postgresql://localhost:5432/3CM9";
        String mySQLDriver = "org.postgresql.Driver";

        try {
            Class.forName(mySQLDriver);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
