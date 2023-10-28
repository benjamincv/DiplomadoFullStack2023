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
  
          tr.appendChild(celda);



          var tr2 = document.createElement('tr');
  
          var button2 = document.createElement("input2");
          button2.type = 'button2';
          button2.id = data[i].nombre;
          button2.value = data[i].nombre;
          button2.style.border = "none";
          button2.style.backgroundColor = "transparent";
          
          var celda2 = document.createElement('td')
          celda2.appendChild(button2);
  
          tr2.appendChild(celda2);


          cuerpo.appendChild(tr);
          cuerpo.appendChild(tr2);
          }
      })
  }