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
          var noSerie = document.createElement('tr');
          var nombre = document.createElement('tr');
          var paisOrigen = document.createElement('tr');
          var year = document.createElement('tr');
  
          var button = document.createElement("input");
          button.type = 'button';
          button.id = data[i].noSerie;
          button.value = data[i].noSerie;

          var button2 = document.createElement("input2");
          button2.type = 'button2';
          button2.id = data[i].nombre;
          button2.value = data[i].nombre;

          var button = document.createElement("input");
          button.type = 'button';
          button.id = data[i].noSerie;
          button.value = data[i].noSerie;

          var button = document.createElement("input");
          button.type = 'button';
          button.id = data[i].noSerie;
          button.value = data[i].noSerie;

          button.style.border = "none";
          button.style.backgroundColor = "transparent";
          button2.style.border = "none";
          button2.style.backgroundColor = "transparent";
          
          var celda = document.createElement('td')
          celda.appendChild(button);
          celda.appendChild(button2);
  
          noSerie.appendChild(celda);
          noSerie.appendChild(celda);
          cuerpo.appendChild(noSerie);

        }
      })
  }