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
            out.println("<h1>Lista de eventos</h1>");
            out.println("<div class='container'>");

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
                    out.println("<td>Eliminar | Actulizar</td>");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarEvento(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void actualizarEvento(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void almacenarEvento(HttpServletRequest request, HttpServletResponse response) throws IOException {
            //int id = Integer.parseInt(request.getParameter("id"));
            String nombreEvento = request.getParameter("nombreEvento");
            String sede = request.getParameter("sede");
            String fechaInicio = request.getParameter("fechaInicio");
            String fechaTermino = request.getParameter("fechaTermino");
            
            Evento e = new Evento();
            e.setNombreEvento(nombreEvento);
            e.setSede(sede);
            e.setFechaInicio(Date.valueOf(fechaInicio));
            e.setFechaTermino(Date.valueOf(fechaTermino));
            
            EventoDAO dao = new EventoDAO();
            try{
                dao.create(e);
                
                try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet EventoServlet</title>");
                out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Registro Satisfactorio</h1>");
                out.println("<a href='EventoServlet?accion=listaDeEventos'>Lista</a>");
                out.println("</body>");
                out.println("</html>");
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            
    }

    private void mostrarEvento(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
