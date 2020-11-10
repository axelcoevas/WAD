/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.Evento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author axel_
 */
public class EventoDAO {
    private static final String SQL_INSERT = "insert into Evento(nombreEvento, sede, fechaInicio, fechaTermino) values (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update Evento set nombreEvento=?, sede=?, fechaInicio=?, fechaTermino=? where idEvento=?";
    private static final String SQL_DELETE = "delete from Evento where idEvento=?";
    private static final String SQL_SELECT = "select * from evento where idEvento=?";
    private static final String SQL_SELECT_ALL = "select * from evento";
    
    private Connection con;
    
    private void obtenerConexion(){
        String user = "root";
        String pwd = "olakase123";
        String url = "jdbc:mysql://localhost:3306/3CM9?serverTimezone=America/Mexico_City&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false";
        String driverMySQL = "com.mysql.cj.jdbc.Driver";
        
        try {
            Class.forName(driverMySQL);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void create(Evento e) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, e.getNombreEvento());
            ps.setString(2, e.getSede());
            ps.setDate(3, e.getFechaInicio());
            ps.setDate(4, e.getFechaTermino());
            ps.executeUpdate();
        }finally{
            if (ps != null) {
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
    }
    
    public void update(Evento e) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, e.getNombreEvento());
            ps.setString(2, e.getSede());
            ps.setDate(3, e.getFechaInicio());
            ps.setDate(4, e.getFechaTermino());
            ps.setInt(5, e.getIdEvento());
            ps.executeUpdate();
        }finally{
            if (ps != null) {
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
    }
    
    public void delete(Evento e) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, e.getIdEvento());
            ps.executeUpdate();
        }finally{
            if (ps != null) {
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
    }
    
    public List readAll() throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size()>0){
                return resultados;
            }else{
                return Collections.emptyList();
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
    
    public Evento read(Evento e) throws SQLException{
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, e.getIdEvento());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size()>0){
                return (Evento)resultados.get(0);
            }else{
                return null;
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException{
        List resultados = new ArrayList();
        while(rs.next()){
            Evento e = new Evento();
            e.setIdEvento(rs.getInt("idEvento"));
            e.setNombreEvento(rs.getString("nombreEvento"));
            e.setSede(rs.getString("sede"));
            e.setFechaInicio(rs.getDate("fechaInicio"));
            e.setFechaTermino(rs.getDate("fechaTermino"));
            resultados.add(e);
        }
        return resultados;
    }
    
    public static void main(String[] args) {
        Evento e = new Evento();
        e.setNombreEvento("Torneo ajedréz");
        e.setSede("Pasillo Cultural");
        e.setFechaInicio(Date.valueOf("2020-10-16"));
        e.setFechaTermino(Date.valueOf("2020-10-17"));
        
        EventoDAO dao = new EventoDAO();
        try {
            dao.create(e);
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
