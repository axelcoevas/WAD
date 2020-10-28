/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador;

import com.ipn.mx.modelo.dao.EventoDAO;
import com.ipn.mx.modelo.dto.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author axel_
 */
public class EventoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion.equals("listaDeEventos")) {
            listaDeEventos(request, response);
        } else if (accion.equals("nuevo")) {
            nuevoEvento(request, response);
        } else if (accion.equals("eliminar")) {
            eliminarEvento(request, response);
        } else if (accion.equals("acualizar")) {
            actualizarEvento(request, response);
        } else if (accion.equals("guardar")) {
            almacenarEvento(request, response);
        } else if (accion.equals("ver")) {
            mostrarEvento(request, response);
        }


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listaDeEventos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EventoServlet</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");         
            out.println("<div class='container'>");
            out.println("<h1>Lista de eventos</h1>");
            out.println("<table class='table table-stripped table-responsive'>");

            out.println("<tr>");
            
            out.println("<thead class='thead-dark'>");
            
            out.println("<th>");
            out.println("Clave de Evento");
            out.println("</th>");

            out.println("<th>");
            out.println("Nombre del Evento");
            out.println("</th>");

            out.println("<th>");
            out.println("Sede");
            out.println("</th>");

            out.println("<th>");
            out.println("Fecha de Inicio");
            out.println("</th>");

            out.println("<th>");
            out.println("Fecha de Término");
            out.println("</th>");

            out.println("<th>");
            out.println("Acciones");
            out.println("</th>");
            
            out.println("</tr>");
            
            out.println("</thead>");

            int idEvento;
            String nombreEvento;
            String sede;
            Date fechaInicio;
            Date fechaTermino;

            EventoDAO dao = new EventoDAO();
            try {
                List lista = dao.readAll();
                for (int i = 0; i < lista.size(); i++) {
                    Evento e = (Evento) lista.get(i);
                    idEvento = e.getIdEvento();
                    nombreEvento = e.getNombreEvento();
                    sede = e.getSede();
                    fechaInicio = e.getFechaInicio();
                    fechaTermino = e.getFechaTermino();
                    
                    out.println("<tr>");
                    out.println("<td>"+idEvento+"</td>");
                    out.println("<td>"+nombreEvento+"</td>");
                    out.println("<td>"+sede+"</td>");
                    out.println("<td>"+fechaInicio+"</td>");
                    out.println("<td>"+fechaTermino+"</td>");
                    out.println("<td><a href='EventoServlet?accion=actualizar&id="+idEvento+"'>Actualizar</a> | <a href='EventoServlet?accion=eliminar&id="+idEvento+"'>Eliminar</a></td>");
                    out.println("</tr>");
                }
            } catch (SQLException e) {
                
            }

            out.println("</table>");

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void nuevoEvento(HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void eliminarEvento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        EventoDAO dao = new EventoDAO();
        Evento e = new Evento();
        
        try {
            e.setIdEvento(id);
            dao.delete(e);
            response.sendRedirect("EventoServlet?accion=listaDeEventos");
        } catch (SQLException ex) {
            Logger.getLogger(EventoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    private void actualizarEvento(HttpServletRequest request, HttpServletResponse response) {
    }

    private void almacenarEvento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Evento e = new Evento();
        EventoDAO dao = new EventoDAO();
        
        String id = request.getParameter("id");
        String nombreEvento = request.getParameter("nombreEvento");
        String sede = request.getParameter("sede");
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaTermino = request.getParameter("fechaTermino");
        
        e.setNombreEvento(nombreEvento);
        e.setSede(sede);
        e.setFechaInicio(Date.valueOf(fechaInicio));
        e.setFechaTermino(Date.valueOf(fechaTermino));
            
        if(id==null||id.isBlank()){
            try{
                dao.create(e);
                try (PrintWriter out = response.getWriter()) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Registrado con éxito');");
                    out.println("</script>");
                    response.sendRedirect("EventoServlet?accion=listaDeEventos");
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            } 
        }else{
            try {
                e.setIdEvento(Integer.parseInt(id));
                dao.update(e);
                try (PrintWriter out = response.getWriter()) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Actualizado con éxito');");
                    out.println("</script>");
                }
            } catch (SQLException ex) {
                Logger.getLogger(EventoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    private void mostrarEvento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        EventoDAO dao = new EventoDAO();
        Evento e = new Evento();
        
        try{
            e.setIdEvento(Integer.parseInt(request.getParameter("id")));
            e = dao.read(e);
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EventoServlet</title>");
            out.println("<link rel=\'stylesheet\' href=\'https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Datos del evento</h1>");
            out.println("<div class='container'>");
            
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
