/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.EntidadFederativaDTO;
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
public class EntidadFederativaDAO {

    private static final String SQL_INSERT = "{call spInsertarEntidadFederativa(?, ?, ?)}";
    private static final String SQL_UPDATE = "{call spActualizarEntidadFederativa(?, ?, ?)}";
    private static final String SQL_DELETE = "{call spBorrarEntidadFederativa(?)}";
    private static final String SQL_SELECT = "{call spVerEntidadFederativa(?)}";
    private static final String SQL_SELECT_ALL = "{call spMostrarEntidadesFederativas()}";

    private Connection con;

    public Connection obtenerConexion() {
        Conexion conexion = new Conexion();
        con = conexion.obtenerConexion();
        return con;
    }

    public void create(EntidadFederativaDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;

        try {
            cs = con.prepareCall(SQL_INSERT);
            cs.setInt(1, dto.getEntidad().getIdEntidadFederativa());
            cs.setString(2, dto.getEntidad().getNombre());
            cs.setString(3, dto.getEntidad().getAbreviatura());
            cs.executeUpdate();
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void update(EntidadFederativaDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;

        try {
            cs = con.prepareCall(SQL_UPDATE);
            cs.setString(1, dto.getEntidad().getNombre());
            cs.setString(2, dto.getEntidad().getAbreviatura());
            cs.setInt(3, dto.getEntidad().getIdEntidadFederativa());
            cs.executeUpdate();
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void delete(EntidadFederativaDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;

        try {
            cs = con.prepareCall(SQL_DELETE);
            cs.setInt(1, dto.getEntidad().getIdEntidadFederativa());
            cs.executeUpdate();
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public EntidadFederativaDTO read(EntidadFederativaDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            cs = con.prepareCall(SQL_SELECT);
            cs.setInt(1, dto.getEntidad().getIdEntidadFederativa());
            rs = cs.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (EntidadFederativaDTO) resultados.get(0);
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List readAll() throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            cs = con.prepareCall(SQL_SELECT_ALL);
            rs = cs.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            EntidadFederativaDTO dto = new EntidadFederativaDTO();
            dto.getEntidad().setIdEntidadFederativa(rs.getInt("idEntidadFederativa"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setAbreviatura(rs.getString("abreviatura"));
            resultados.add(dto);
        }
        return resultados;
    }
}
