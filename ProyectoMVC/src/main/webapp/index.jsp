<%-- 
    Document   : index
    Created on : 9 Dec 2020, 22:08:21
    Author     : axel_
--%>

<%@page import="com.ipn.mx.modelo.dto.UsuarioDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi tiendita MX</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    </head>
    <body>
        <%
            UsuarioDTO dto = (UsuarioDTO) session.getAttribute("Usuario");
            boolean isLogged = dto != null;

            int idUsuario = 0;
            String nombreUsuario = "";
            String tipoUsuario = "";

            if (isLogged) {
                idUsuario = dto.getEntidad().getIdUsuario();
                nombreUsuario = dto.getEntidad().getNombreUsuario();
                tipoUsuario = dto.getEntidad().getTipoUsuario();
            }
        %>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img src="imagenes/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
                    Mi Tiendita MX
                </a>
                <a class="navbar-brand">Bienvenido</a>
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
                        <li class="nav-item">
                            <a class="nav-link" href="CategoriaServlet?accion=listaDeCategorias">Categorias</a>
                        </li>
                        <li class="nav-item dropdown">
                            <%if (!isLogged) {%>
                            <a class="btn btn-secondary" href="login.jsp"  aria-expanded="false">
                                Iniciar Sesión
                            </a>
                            <%} else {%>
                            <a class="dropdown-toggle  btn btn-secondary" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Opciones
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">Mi cuenta</a>
                                <a class="dropdown-item" href="logout">Cerrar Sesión</a>
                            </div>

                            <%}%>
                        </li>
                    </ul>
                </div>
            </nav>
            <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="imagenes/fortnite.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="imagenes/fifa.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="imagenes/ps5.jpg" class="d-block w-100" alt="...">
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    </body>
</html>
