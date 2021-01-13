<%-- 
    Document   : login
    Created on : 9 Dec 2020, 21:08:24
    Author     : axel_
--%>

<%@page import="com.ipn.mx.modelo.dto.UsuarioDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/login.css">
    </head>
    <div class="container">
        <%
            session = request.getSession();
            UsuarioDTO dto = (UsuarioDTO) session.getAttribute("Usuario");
            if (dto != null) {
                switch (dto.getEntidad().getTipoUsuario()) {
                    case "A":
                        response.sendRedirect("user/home.jsp");
                        break;
                    case "X":
                        response.sendRedirect("admin/home.jsp");
                        break;
                    default:
                        break;
                }
            }
        %>
        <div class="row">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <h5 class="card-title text-center">Iniciar Sesión</h5>
                        <form class="form-signin" action="login">
                            <div class="form-label-group">
                                <input type="text" id="nickname" name="nickname" class="form-control" required autofocus/>
                                <label for="nickname">Usuario</label>
                            </div>

                            <div class="form-label-group">
                                <input type="password" id="password" name="password" class="form-control" required/>
                                <label for="password">Contraseña</label>
                            </div>

                            <div class="custom-control custom-checkbox mb-3">
                                <input type="checkbox" class="custom-control-input" id="customCheck1">
                                <label class="custom-control-label" for="customCheck1">Recordar Contraseña</label>
                            </div>
                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Iniciar Sesión</button>
                            <hr class="my-4">
                            <center><span>No tienes cuenta? <a href="signup.html">Regístrate</a></span><center>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
    </body>
</html>
