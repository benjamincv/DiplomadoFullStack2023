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
                var $tr = $('<tr>').append(
                    $('<td>').text(data[i].noSerie),
                    $('<td>').text(data[i].nombre),
                    $('<td>').text(data[i].paisOrigen)
                ); //.appendTo('#records_table');
                console.log($tr.wrap('<p>').html());
          }
      })
  }