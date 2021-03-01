/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Categoria;
import com.ipn.mx.modelo.entidades.Producto;
import java.io.Serializable;

/**
 *
 * @author darkdestiny
 */
public class CategoriaDTO implements Serializable{
    private Categoria entidad;

    public CategoriaDTO() {
        entidad = new Categoria();
    }

    public CategoriaDTO(Categoria entidad) {
        this.entidad = entidad;
    }

    public Categoria getEntidad() {
        return entidad;
    }

    public void setEntidad(Categoria entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id Categoría : ").append(getEntidad().getIdCategoria()).append("\n");
        sb.append("Nombre Categoría : ").append(getEntidad().getNombreCategoria()).append("\n");
        sb.append("Descripción Categoría : ").append(getEntidad().getDescripcionCategoria()).append("\n");
        
        sb.append("**********************************************************************").append("\n");
        sb.append("Datos de los productos").append("\n");
        sb.append("**********************************************************************").append("\n");
        
        for(Producto p: getEntidad().getListaProducto()){
            sb.append("Id Producto ==>:").append(p.getIdProducto()).append("\n");
            sb.append("Nombre de producto ==>:").append(p.getNombreProducto()).append("\n");
            sb.append("Descripción producto ==>:").append(p.getDescripcionProducto()).append("\n");
            sb.append("Existencia del producto ==>:").append(p.getExistencia()).append("\n");
            sb.append("Precio del producto ==>:").append(p.getPrecio()).append("\n");
        }

        return sb.toString();
    }
    
    
}
