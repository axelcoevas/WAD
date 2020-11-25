<%-- 
    Document   : categoriaForm
    Created on : 24 Nov 2020, 11:12:26
    Author     : axel_
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categoria</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img src="imagenes/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="" loading="lazy">
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
                            <a class="nav-link" href="CategoriaServlet?accion=listaDeCategorias">Categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="CategoriaServlet?accion=nuevo">Registrar Categoria</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <div class="card">
                <div class="card-header bg-primary text-white">
                    Datos de la Categoria
                </div>
                <div class="card-body">
                    <form
                        action="CategoriaServlet?accion=guardar"
                        method="post"
                        name="frmCategoriaForm"
                        id="frmCategoriaForm">
                        <input 
                            type="hidden" 
                            name="id" 
                            id="id" 
                            value="<c:out value="${dto.entidad.idCategoria}"/>"
                            />
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Nombre</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="nombre" name="nombre" required="required" value="<c:out value="${dto.entidad.nombreCategoria}"/>">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Descripcion</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="descripcion" name="descripcion" required="required" value="<c:out value="${dto.entidad.descripcionCategoria}"/>">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
    </body>
</html>
