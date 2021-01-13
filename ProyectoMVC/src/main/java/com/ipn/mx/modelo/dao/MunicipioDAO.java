/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.MunicipioDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class MunicipioDAO {
    private static final String SQL_INSERT = "{call spInsertarMunicipio(?, ?, ?)}";
    private static final String SQL_UPDATE = "{call spActualizarMunicipio(?, ?, ?)}";
    private static final String SQL_DELETE = "{call spBorrarMunicipio(?)}";
    private static final String SQL_SELECT = "{call spVerMunicipio(?)}";
    private static final String SQL_SELECT_ALL = "{call spMostrarMunicipios)}";
    
    private Connection con;
    
    public Connection obtenerConexion() {
        Conexion conexion = new Conexion();
        con = conexion.obtenerConexion();
        return con;
    }
    
    public void create(MunicipioDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        
        try{
            cs = con.prepareCall(SQL_INSERT);
            cs.setString(1, dto.getEntidad().getIdMunicipio());
            cs.setInt(2, dto.getEntidad().getIdEntidadFederativa());
            cs.setString(3, dto.getEntidad().getNombre());
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
    
    public void update(MunicipioDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        
        try{
            cs = con.prepareCall(SQL_UPDATE);
            cs.setInt(1, dto.getEntidad().getIdEntidadFederativa());
            cs.setString(2, dto.getEntidad().getNombre());
            cs.setString(3, dto.getEntidad().getIdMunicipio());
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
    
    public void delete(MunicipioDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        
        try{
            cs = con.prepareCall(SQL_DELETE);
            cs.setString(1, dto.getEntidad().getIdMunicipio());
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
    
    public MunicipioDTO read(MunicipioDTO dto) throws SQLException{
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try{
            cs = con.prepareCall(SQL_SELECT);
            cs.setString(1, dto.getEntidad().getIdMunicipio());
            rs = cs.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size()>0){
                return (MunicipioDTO) resultados.get(0);
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
            MunicipioDTO dto = new MunicipioDTO();
            dto.getEntidad().setIdMunicipio(rs.getString("idMunicipio"));
            dto.getEntidad().setIdEntidadFederativa(rs.getInt("idEntidadFederativa"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            resultados.add(dto);
        }
        return resultados;
    }
}
