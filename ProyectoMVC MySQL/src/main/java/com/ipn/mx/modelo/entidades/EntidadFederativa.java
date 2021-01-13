/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author axel_
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntidadFederativa implements Serializable{
    private int idEntidadFederativa;
    private String nombre;
    private String abreviatura;
}
