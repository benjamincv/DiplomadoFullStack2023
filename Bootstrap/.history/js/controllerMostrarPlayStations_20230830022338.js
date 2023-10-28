window.onload = function () {
    ObtenerGrupos();
  }
  
  function ObtenerGrupos() {
    
    fetch('http://localhost:8084/SchoolOnline/webresources/grupo/getGruposAlumno', {
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
          button.id = data[i].idGrupo;
          button.value = data[i].nombre;
          button.style.border = "none";
          button.style.backgroundColor = "transparent";
          
          var celda = document.createElement('td')
          celda.appendChild(button);
  
          tr.appendChild(celda);
          cuerpo.appendChild(tr);
          }
      })
  }