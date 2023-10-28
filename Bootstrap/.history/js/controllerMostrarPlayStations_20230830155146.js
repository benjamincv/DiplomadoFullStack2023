var playStations = [];
window.onload = function () {
    ObtenerPlayStations();
  }
  
  function ObtenerPlayStations() {
    
    fetch('http://localhost:8080/PlayStation/obtenerPlayStations', {
      method: 'GET',
    })
      .then(response => response.json())
      .then(data => {
  
        console.log(data);

        playStations=data;
  
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
       

       window.location.href = '../html/modificarPlayStation.html';
     });
   });
  