<%-- 
    Document   : signup
    Created on : 10 Dec 2020, 12:04:02
    Author     : axel_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <title>Registro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <!-- Default form register -->
            <form class="text-center border border-light p-5" action="#!">

                <p class="h4 mb-4">Registro</p>

                <div class="form-row mb-4">
                    <div class="col">
                        <!-- First name -->
                        <input type="text" id="defaultRegisterFormFirstName" class="form-control" placeholder="Nombre">
                    </div>
                    <div class="col">
                        <!-- Last name -->
                        <input type="text" id="defaultRegisterFormLastName" class="form-control" placeholder="Apellido">
                    </div>
                </div>

                <!-- E-mail -->
                <input type="email" id="defaultRegisterFormEmail" class="form-control mb-4" placeholder="E-mail">

                <!-- Password -->
                <input type="password" id="defaultRegisterFormPassword" class="form-control" placeholder="Contraseña" aria-describedby="defaultRegisterFormPasswordHelpBlock">
                <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
                    At least 8 characters and 1 digit
                </small>

                <!-- Phone number -->
                <input type="text" id="defaultRegisterPhonePassword" class="form-control" placeholder="Phone number" aria-describedby="defaultRegisterFormPhoneHelpBlock">
                <small id="defaultRegisterFormPhoneHelpBlock" class="form-text text-muted mb-4">
                    Optional - for two step authentication
                </small>

                <!-- Sign up button -->
                <button class="btn btn-info my-4 btn-block" type="submit">Registrarme</button>

                <hr>

                <!-- Terms of service -->
                <p>Al hacer click
                    <em>Registrarme</em> aceptas los 
                    <a href="" target="_blank">terminos de servicio</a>

            </form>
            <!-- Default form register -->
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
    </body>
</html>
