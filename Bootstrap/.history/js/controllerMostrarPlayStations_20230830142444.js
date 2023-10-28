var playStations = [];
window.onload = function () {
    ObtenerGrupos();
  }
  
  function ObtenerGrupos() {
    
    fetch('http://localhost:8080/PlayStation/obtenerPlayStations', {
      method: 'GET',
    })
      .then(response => response.json())
      .then(data => {
  
        console.log(data);
  
        var cuerpo = document.getElementById('cuerpo');
          
        for (var i = 0; i < data.length; i++) {
          var tr = document.createElement('tr');
  
          var button = document.createElement("input");
          button.type = 'button';
          button.id = data[i].noSerie;
          button.value = data[i].noSerie;
          button.style.border = "none";
          button.style.backgroundColor = "transparent";
          
          var celda = document.createElement('td')
          celda.appendChild(button);

          var celda2 = document.createElement('td')
          celda2.innerHTML = data[i].nombre;

          var celda3 = document.createElement('td')
          celda3.innerHTML = data[i].paisOrigen;

          var celda4 = document.createElement('td')
          celda4.innerHTML = data[i].year;
  
          tr.appendChild(celda);
          tr.appendChild(celda2);
          tr.appendChild(celda3);
          tr.appendChild(celda4);

          cuerpo.appendChild(tr);
          }
      })

      
  }

  $(function() {
    $(document).on('click', 'input[type="button"]', function(event) {
       let id = this.id;
       var actividad = playStations.find( a => a.idActividad == id);

       sessionStorage.setItem('idActividad', id);
       sessionStorage.setItem('nombreActividad', actividad.nombre);
       sessionStorage.setItem('fechaCreada', actividad.fechaCreada);
       sessionStorage.setItem('fechaEntrega', actividad.fechaEntrega);
       sessionStorage.setItem('descripcion', actividad.descripcion);

       window.location.href = '../html/Alumno_Entregar_Actividad.html';
     });
   });
  