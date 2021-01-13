/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.ProductoDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author axel_
 */
public class ProductoDAO {
    private static final String SQL_INSERT = "insert into Producto(nombreProducto, descripcionProducto, precio, existencia, idCategoria)"
            + "values (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update Producto set nombreProducto = ?, descripcionProducto = ?, precio = ?, existencia = ?, "
            + "idCategoria = ? where idProducto = ?";
    private static final String SQL_DELETE = "delete from Producto where idProducto = ?";
    private static final String SQL_SELECT = "select * from Producto where idProducto = ?";
    private static final String SQL_SELECT_ALL = "select * from Producto";
    
    private Connection con;
    
    public Connection obtenerConexion() {
        Conexion conexion = new Conexion();
        con = conexion.obtenerConexion();
        return con;
    }
    
    public void create(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        
        try{
            cs = con.prepareCall(SQL_INSERT);
            cs.setString(1, dto.getEntidad().getNombreProducto());
            cs.setString(2, dto.getEntidad().getDescripcionProducto());
            cs.setDouble(3, dto.getEntidad().getPrecio());
            cs.setInt(4, dto.getEntidad().getExistencia());
            cs.setInt(5, dto.getEntidad().getIdCategoria());
            
            cs.executeUpdate();
        }finally{
            if(cs != null){
                cs.close();
            }
            if(con != null){
                con.close();
            }
        }  
    }
    
    public void update(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        
        try{
            cs = con.prepareCall(SQL_UPDATE);
            cs.setString(1, dto.getEntidad().getNombreProducto());
            cs.setString(2, dto.getEntidad().getDescripcionProducto());
            cs.setDouble(3, dto.getEntidad().getPrecio());
            cs.setInt(4, dto.getEntidad().getExistencia());
            cs.setInt(5, dto.getEntidad().getIdCategoria());
            cs.setInt(4, dto.getEntidad().getIdProducto());
            cs.executeUpdate();
        }finally{
            if(cs != null){
                cs.close();
            }
            if(con != null){
                con.close();
            }
        }  
    }
    
    public void delete(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        
        try{
            cs = con.prepareCall(SQL_DELETE);
            cs.setInt(1, dto.getEntidad().getIdProducto());
            cs.executeUpdate();
        }finally{
            if(cs != null){
                cs.close();
            }
            if(con != null){
                con.close();
            }
        }  
    }
    
    public ProductoDTO read(ProductoDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try{
            cs = con.prepareCall(SQL_SELECT);
            cs.setInt(1, dto.getEntidad().getIdProducto());
            rs = cs.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size()>0){
                return (ProductoDTO) resultados.get(0);
            }else{
                return null;
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(cs != null){
                cs.close();
            }
            if(con != null){
                con.close();
            }
        }  
    }
    
    public List readAll() throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try{
            cs = con.prepareCall(SQL_SELECT_ALL);
            rs = cs.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size()>0){
                return resultados;
            }else{
                return null;
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(cs != null){
                cs.close();
            }
            if(con != null){
                con.close();
            }
        }  
    }

    private List obtenerResultados(ResultSet rs) throws SQLException{
        List resultados = new ArrayList();
        while(rs.next()){
            ProductoDTO dto = new ProductoDTO();
            dto.getEntidad().setIdProducto(rs.getInt("idProducto"));
            dto.getEntidad().setNombreProducto(rs.getString("nombreProducto"));
            dto.getEntidad().setDescripcionProducto(rs.getString("descripcionProducto"));
            dto.getEntidad().setPrecio(rs.getDouble("precio"));
            dto.getEntidad().setExistencia(rs.getInt("existencia"));
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
            resultados.add(dto);
        }
        return resultados;
    }
}
