/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Producto;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
 *
 * @author axel_
 */
@Data
@AllArgsConstructor
public class ProductoDTO implements Serializable{
    private Producto entidad;
    
    public ProductoDTO(){
        this.entidad = new Producto();
    }
}