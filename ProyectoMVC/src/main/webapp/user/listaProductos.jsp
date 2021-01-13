<%-- 
    Document   : listaDeProductos.jsp
    Created on : 8 Dec 2020, 19:10:02
    Author     : axel_
--%>

<%@page import="com.ipn.mx.modelo.dto.UsuarioDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    </head>
    <body>
        <%
            UsuarioDTO dto = (UsuarioDTO) session.getAttribute("Usuario");
            boolean isLogged = dto != null;

            int idUsuario = 0;
            String nombreUsuario = "";

            if (isLogged) {
                idUsuario = dto.getEntidad().getIdUsuario();
                nombreUsuario = dto.getEntidad().getNombreUsuario();
            }
        %>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img src="imagenes/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
                    Mi Tiendita MX
                </a>
                <a class="navbar-brand">Lista de productos</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ProductoServlet?accion=listaDeProductos">Productos</a>
                        </li>
                        <span></span>
                        <li class="nav-item dropdown">
                            <button class="btn btn-secondary dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Opciones
                            </button>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">

                                <%
                                    if (!isLogged) {

                                %>
                                <a class="dropdown-item" href="login.jsp">Iniciar Sesión</a>
                                <%                                } else {

                                %>
                                <a class="dropdown-item" href="signup.jsp?idUsuario=<%=idUsuario%>">Mi cuenta</a>
                                <a class="dropdown-item" href="logout">Cerrar Sesion</a>
                                <%
                                    }
                                %>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Clave</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach
                        var="producto"
                        items="${listaDeProductos}">

                        <tr>
                            <td>
                                <a class="btn btn-primary btn-xs"
                                   href="CategoriaServlet?accion=ver&id=<c:out value="${producto.entidad.idProducto}"/>">
                                    <c:out value="${producto.entidad.idProducto}"/>
                                </a>
                            </td>
                            <td>
                                <c:out value="${producto.entidad.nombreProducto}"/>
                            </td>
                            <td>
                                <c:out value="${producto.entidad.descripcionProducto}"/>
                            </td>
                            <td>
                                <c:out value="${producto.entidad.precio}"/>
                            </td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
    </body>
</html>

