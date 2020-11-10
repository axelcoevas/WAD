/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Categoria;
import java.io.Serializable;

/**
 *
 * @author axel_
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
        sb.append("idCategoria: ").append(entidad.getIdCategoria()).append("\n");
        sb.append("nombreCategoria: ").append(entidad.getNombreCategoria()).append("\n");
        sb.append("descripcionCategoria: ").append(entidad.getDescripcionCategoria()).append("\n");
        sb.append('}');
        return sb.toString();
    }
    
    public static void main(String[] args) {
        CategoriaDTO dto = new CategoriaDTO();
        
    }
}
