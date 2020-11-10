    var fechaInicio = document.getElementById("fechaInicio");
    var fechaTermino = document.getElementById("fechaTermino");

    //Obtiene la fecha de hoy
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; 
    var yyyy = today.getFullYear();
     if(dd<10){
            dd='0'+dd;
        } 
        if(mm<10){
            mm='0'+mm;
        } 

    today = yyyy+'-'+mm+'-'+dd;

    fechaInicio.setAttribute("min", today);
    fechaTermino.setAttribute("min", today);


    //Cambia la fecha mínima de fechaTermino cada que fechaInicio cambia
    function minTermino(){
        var max = fechaInicio.value;

        fechaTermino.setAttribute("min", max);
    }