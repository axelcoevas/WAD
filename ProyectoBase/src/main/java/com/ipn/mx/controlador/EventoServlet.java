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
        } else if (accion.equals("actualizar")) {
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
            out.println("<meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />");
            out.println("<title>Lista de Eventos</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\">");
            out.println("</head>");
            out.println("<body>");         
            out.println("<div class='container'>"
                      + "<nav class=\"navbar navbar-light bg-light\">\n" +
        "                    <a class=\"navbar-brand\" href=\"index.html\">\n" +
        "                        <img src=\"imagenes/escom.png\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\" alt=\"\">\n" +
        "                        Eventos\n" +
        "                    </a>\n" +
        "                </nav>\n" +
        "                <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n" +
        "                    <ul class=\"navbar-nav\">\n" +
        "                        <li class=\"nav-item active\">\n" +
        "                            <a class=\"nav-link\" href=\"\">Inicio<span class=\"sr-only\">(current)</span></a>\n" +
        "                        </li>\n" +
        "                        <li class=\"nav-item\">\n" +
        "                            <a class=\"nav-link\" href=\"EventoServlet?accion=listaDeEventos\">Lista de Eventos</a>\n" +
        "                        </li>\n" +
        "                    </ul>\n" +
        "                </div>");
            out.println("<h1>Lista de eventos</h1>");
            out.println("<div class=\"table-responsive\">");
            out.println("<table class='table table-stripped'>");

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
                if(!lista.isEmpty()){
                    for (int i = 0; i < lista.size(); i++) {
                        Evento e = (Evento) lista.get(i);
                        idEvento = e.getIdEvento();
                        nombreEvento = e.getNombreEvento();
                        sede = e.getSede();
                        fechaInicio = e.getFechaInicio();
                        fechaTermino = e.getFechaTermino();

                        out.println("<tr>");
                        out.println("<td>"+idEvento+"</td>");
                        out.println("<td><a href='EventoServlet?accion=ver&id="+idEvento+"'>"+nombreEvento+"</a></td>");
                        out.println("<td>"+sede+"</td>");
                        out.println("<td>"+fechaInicio+"</td>");
                        out.println("<td>"+fechaTermino+"</td>");
                        out.println("<td>");
                        out.println("<button onclick=\"window.location.href='EventoServlet?accion=actualizar&id="+idEvento+"'\" type=\"button\" class=\"btn btn-primary\">Actualizar</button> "
                                  + "<button onclick=\"window.location.href='EventoServlet?accion=eliminar&id="+idEvento+"'\" type=\"button\" class=\"btn btn-danger\">Eliminar</button>");
                        out.println("</td>");
                        out.println("</tr>");
                    }
                }
            } catch (SQLException e) {
                
            }
            
            out.println("</table>");
            out.println("</div>");
            out.println("<button onclick=\"window.location.href='eventosForm.html'\" type=\"button\" class=\"btn btn-success\" style='float: right'>Nuevo</button>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void nuevoEvento(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

    private void actualizarEvento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        EventoDAO dao = new EventoDAO();
        Evento e = new Evento();
        
        try {
            e.setIdEvento(id);
            e = dao.read(e);
        } catch (SQLException ex) {
            Logger.getLogger(EventoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />");
            out.println("<title>Actualizar</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\">");
            out.println("</head>");
            out.println("<body>"); 
            out.println(""
                + "        <div class=\"container\">\n" +
                "            <div class=\"row justify-content-center\">\n" +
                "                <div class=\"col-md-8\">\n" +
                "                    <div class=\"card\">\n" +
                "                        <div class=\"card-header\">Actualizar Evento</div>\n" +
                "                        <div class=\"card-body\">\n" +
                "                            <form method=\"POST\" action=\"EventoServlet?accion=guardar\">\n" +
                "                                <div class=\"form-group row\">\n" +
                "                                    <label for=\"idEvento\" \n" +
                "                                           class=\"col-md-4 col-form-label text-md-right\">\n" +
                "                                        Id Evento\n" +
                "                                    </label>\n" +
                "                                    <div class=\"col-md-6\">\n" +
                "                                        <input \n" +
                "                                            id=\"idEvento\" \n" +
                "                                            type=\"text\" \n" +
                "                                            class=\"form-control \"\n" +
                "                                            name=\"id\" \n" +
                "                                            value='"+e.getIdEvento()+"'"+
                "                                            autofocus readonly/>\n" +
                "                                    </div>\n" +
                "                                </div>" +                                                       
                "                                <div class=\"form-group row\">\n" +
                "                                    <label for=\"sede\" \n" +
                "                                           class=\"col-md-4 col-form-label text-md-right\">\n" +
                "                                        Nombre del Evento\n" +
                "                                    </label>\n" +
                "                                    <div class=\"col-md-6\">\n" +
                "                                        <input \n" +
                "                                            id=\"sede\" \n" +
                "                                            type=\"text\" \n" +
                "                                            class=\"form-control \"\n" +
                "                                            name=\"nombreEvento\" \n" +
                "                                            value='"+e.getNombreEvento()+"'"+
                "                                            required \n" +
                "                                            autofocus />\n" +
                "                                    </div>\n" +
                "                                </div>\n" +              
                "                                <div class=\"form-group row\">\n" +
                "                                    <label for=\"sede\" \n" +
                "                                           class=\"col-md-4 col-form-label text-md-right\">\n" +
                "                                        Sede Evento\n" +
                "                                    </label>\n" +
                "                                    <div class=\"col-md-6\">\n" +
                "                                        <input \n" +
                "                                            id=\"sede\" \n" +
                "                                            type=\"text\" \n" +
                "                                            class=\"form-control \"\n" +
                "                                            name=\"sede\" \n" +
                "                                            value='"+e.getSede()+"'"+
                "                                            required \n" +
                "                                            autofocus />\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div class=\"form-group row\">\n" +
                "                                    <label for=\"fechaInicio\" \n" +
                "                                            class=\"col-md-4 col-form-label text-md-right\">\n" +
                "                                                Fecha Inicio\n" +
                "                                    </label>\n" +
                "                                    <div class=\"col-md-6\">\n" +
                "                                        <input \n" +
                "                                            class=\"form-control\" \n" +
                "                                            type=\"date\"\n" +
                "                                            name=\"fechaInicio\" " +
                "                                            value='"+e.getFechaInicio()+"' "+
                "                                            id=\"fechaInicio\">\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div class=\"form-group row\">\n" +
                "                                    <label for=\"fechaTermino\" \n" +
                "                                            class=\"col-md-4 col-form-label text-md-right\">\n" +
                "                                                Fecha Término\n" +
                "                                    </label>\n" +
                "                                    <div class=\"col-md-6\">\n" +
                "                                        <input \n" +
                "                                            class=\"form-control\" \n" +
                "                                            type=\"date\" \n" +
                "                                            name=\"fechaTermino\"\n" +
                "                                            value='"+e.getFechaTermino()+"' "+
                "                                            id=\"fechaTermino\">\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div class=\"form-group row mb-0\">\n" +
                "                                    <div class=\"col-md-6 offset-md-4\">\n" +
                "                                        <button type=\"submit\" class=\"btn btn-success\">\n" +
                "                                            Actualizar\n" +
                "                                        </button>\n" +
                "                                        <button onclick=\"window.location.href='EventoServlet?accion=listaDeEventos'\" class=\"btn btn-primary\">\n" +
                "                                            Cancelar\n" +
                "                                        </button>\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </form>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n");
            out.println("</div>");
            out.println("<script>\n" +
                "            var fechaInicio = document.getElementById(\"fechaInicio\");\n" +
                "            var fechaTermino = document.getElementById(\"fechaTermino\");\n" +
                "\n" +
                "            //Obtiene la fecha de hoy\n" +
                "            var today = new Date();\n" +
                "            var dd = today.getDate();\n" +
                "            var mm = today.getMonth()+1; \n" +
                "            var yyyy = today.getFullYear();\n" +
                "             if(dd<10){\n" +
                "                    dd='0'+dd;\n" +
                "                } \n" +
                "                if(mm<10){\n" +
                "                    mm='0'+mm;\n" +
                "                } \n" +
                "\n" +
                "            today = yyyy+'-'+mm+'-'+dd;\n" +
                "\n" +
                "            fechaInicio.setAttribute(\"min\", today);\n" +
                "            fechaTermino.setAttribute(\"min\", today);\n" +
                "\n" +
                "\n" +
                "            //Cambia la fecha mínima de fechaTermino cada que fechaInicio cambia\n" +
                "            function minTermino(){\n" +
                "                var max = fechaInicio.value;\n" +
                "\n" +
                "                fechaTermino.setAttribute(\"min\", max);\n" +
                "            }\n" +
                "        </script>");
            out.println("</body>");
            out.println("</html>");
        }
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
                    response.sendRedirect("EventoServlet?accion=listaDeEventos");
                    
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
            out.println("<meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />");
            out.println("<title>"+e.getNombreEvento()+"</title>");
            out.println("<link rel=\'stylesheet\' href=\'https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Datos del evento</h1>");
            out.println("<div class=\"card\" style=\"width: 50%; align: center;\">\n" +
                        "  <img src=\"imagenes/escom.png\" class=\"card-img-top\" alt=\"...\">"+
                        "  <div class=\"card-body\">\n" +
                        "    <h5 class=\"card-title\">"+e.getNombreEvento()+"</h5>\n" +
                        "    <h6 class=\"card-subtitle mb-2 text-muted\">"+e.getSede()+"</h6>\n" +
                        "    <p class=\"card-text\">Evento que se llevará a cabo del "+e.getFechaInicio()+" al "+e.getFechaTermino()+"</p>\n" +
                        "    <a href=\"EventoServlet?accion=actualizar&id="+e.getIdEvento()+"\" class=\"card-link\">Editar</a>\n" +
                        "    <a href=\"EventoServlet?accion=listaDeEventos\" class=\"card-link\">Volver</a>\n" +
                        "  </div>\n" +
                        "</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
