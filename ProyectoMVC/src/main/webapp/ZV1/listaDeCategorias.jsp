<%-- 
    Document   : listaDeCategorias
    Created on : 20 Nov 2020, 11:03:01
    Author     : axel_
--%>

<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO"%>
<%@page import="java.util.List"%>
<%@page errorPage="error.jsp?de=listaDeCategorias.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Categor&iacute;as</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    </head>
    <body>
        <%
            String de = request.getParameter("de");
        %>

        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img src="../imagenes/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="" loading="lazy">
                    Proyecto Base MVC
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="listaDeCategorias.jsp">Categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="categoriaFormulario.jsp">Registrar Categoria</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <table class="table">
                <thead>
                    <tr>
                        <th>Clave Categoría</th>
                        <th>Nombre Categoria</th>
                        <th>Descripción Categoría</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        CategoriaDAO dao = new CategoriaDAO();
                        List lista = dao.readAll();
                        if (lista != null) {
                            for (int i = 0; i < lista.size(); i++) {
                                CategoriaDTO dto = (CategoriaDTO) lista.get(i);
                    %>
                    <tr>
                        <td>
                            <a class="btn btn-primary btn-xs"
                               href="verCategoria.jsp?id=<%= dto.getEntidad().getIdCategoria()%>">
                                <%= dto.getEntidad().getIdCategoria()%>
                            </a>
                        </td>
                        <td>

                        </td>
                        <td>
                            <%= dto.getEntidad().getNombreCategoria()%>
                        </td>
                        <td>
                            <%= dto.getEntidad().getDescripcionCategoria()%>
                        </td>
                        <td>
                            <a class="btn btn-danger btn-xs"
                               href="eliminarCategoria.jsp?id=<%= dto.getEntidad().getIdCategoria()%>">Eliminar</a>
                        </td>
                        <td>
                            <a class="btn btn-success btn-xs"
                               href="categoriaFormulario.jsp?id=<%= dto.getEntidad().getIdCategoria()%>">Actualizar</a>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                            out.println("No hay datos");
                        }
                    %>
                </tbody>
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
    </body>
</html>
