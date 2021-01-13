<%-- 
    Document   : almacenarCategoria
    Created on : 25 Nov 2020, 17:11:19
    Author     : axel_
--%>

<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String rId = request.getParameter("id");
            String rNombre = request.getParameter("nombre");
            String rDescripcion = request.getParameter("descripcion");

            CategoriaDAO dao = new CategoriaDAO();
            CategoriaDTO dto = new CategoriaDTO();

            if (!rId.isEmpty()) {
                dto.getEntidad().setIdCategoria(Integer.parseInt(rId));
            }

            dto.getEntidad().setNombreCategoria(rNombre);
            dto.getEntidad().setDescripcionCategoria(rDescripcion);

            if (rId.isEmpty()) {
                dao.create(dto);
            } else {
                dao.update(dto);
            }

            response.sendRedirect("listaDeCategorias.jsp");
        %>
    </body>
</html>
