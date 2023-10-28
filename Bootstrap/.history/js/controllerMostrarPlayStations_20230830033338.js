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
          button.value = data[i].noSerie+" | "+data[i].nombre+" | "+data[i].paisOrigen+" | "+data[i].year;
          button.style.border = "none";
          button.style.backgroundColor = "transparent";
          
          var celda = document.createElement('th')
          celda.appendChild(button);
  
          tr.appendChild(celda);
          cuerpo.appendChild(tr);
          }
      })
  }