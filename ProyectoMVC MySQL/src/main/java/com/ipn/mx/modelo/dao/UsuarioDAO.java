/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.UsuarioDTO;
import com.ipn.mx.modelo.entidades.Usuario;
import com.ipn.mx.utilerias.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author axel_
 */
public class UsuarioDAO {
    public void create(UsuarioDTO dto){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            
            session.save(dto.getEntidad());
            
            transaction.commit();
        } finally {
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    
    public void update(UsuarioDTO dto){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            
            session.update(dto.getEntidad());
            
            transaction.commit();
        } finally {
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    
    public void delete(UsuarioDTO dto){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            
            session.delete(dto.getEntidad());
            
            transaction.commit();
        } finally {
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    
    public UsuarioDTO read(UsuarioDTO dto){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            
            dto.setEntidad(session.get(dto.getEntidad().getClass(), dto.getEntidad().getIdUsuario()));
            dto.setEntidad(dto.getEntidad());
            
            transaction.commit();
        } finally {
            if(transaction != null){
                transaction.rollback();
            }
        }
        return dto;
    }  
    
    
    public List readAll(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        List lista = new ArrayList();
        try{
            transaction.begin();
            
            Query q = session.createQuery("from Usuario u order by u.idUsuario");
            for(Usuario u: (List<Usuario>) q.list()){
                UsuarioDTO dto = new UsuarioDTO();
                dto.setEntidad(u);
                lista.add(dto);
            }
            
            transaction.commit();
        } finally {
            if(transaction != null){
                transaction.rollback();
            }
        }
        return lista;
    } 
    
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioDTO dto = new UsuarioDTO();
        dto.getEntidad().setIdUsuario(1);
        dto = dao.read(dto);
        System.out.println(dto.toString());
    }
}
