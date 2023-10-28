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
          var button2 = document.createElement("input");
          button2.type = 'button';
          button2.id = data[i].noSerie;
          button2.value = data[i].noSerie;
          button2.style.border = "none";
          button2.style.backgroundColor = "transparent";
          
          var celda = document.createElement('td')
          celda.appendChild(button);
          celda.appendChild(button2);
  
          tr.appendChild(celda);
          cuerpo.appendChild(tr);
          }
      })
  }