/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ipn.mx.modelo.dto.GraficaDTO;

/**
 *
 * @author axel_
 */
public class GraficaDAO {

    private static final String SQL_GRAFICAR = "select nombreCategoria as categoria, count(*) as productos from Producto p, Categoria c where p.idCategoria = c.idCategoria group by c.idCategoria";

    private Connection con;

    public Connection obtenerConexion() {
        Conexion conexion = new Conexion();
        con = conexion.obtenerConexion();
        return con;
    }

    public List grafica() throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List lista = new ArrayList();
        try {
            ps = con.prepareStatement(SQL_GRAFICAR);
            rs = ps.executeQuery();
            while (rs.next()) {
                GraficaDTO dto = new GraficaDTO();
                dto.setNombre(rs.getString("categoria"));
                dto.setCantidad(rs.getInt("productos"));
                lista.add(dto);
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return lista;
    }
}
