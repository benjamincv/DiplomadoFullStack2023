var coleccion = [];

window.onload = function () {
    ObtenerColeccion();
  }
  
  function ObtenerColeccion() {
    
    fetch('http://localhost:8080/coleccion/obtenerColeccion', {
      method: 'GET',
    })
      .then(response => response.json())
      .then(data => {
  
        console.log(data);

        coleccion=data;
  
        var cuerpo = document.getElementById('cuerpo');
          
        for (var i = 0; i < data.length; i++) {
          var tr = document.createElement('tr');
  
          var button = document.createElement("input");
          button.type = 'button';
          button.id = data[i].idColeccion;
          button.value = data[i].idColeccion;
          button.style.border = "none";
          button.style.backgroundColor = "transparent";
          
          var celda = document.createElement('td')
          celda.appendChild(button);

          var celda2 = document.createElement('td')
          celda2.innerHTML = data[i].nombreCol;

          var celda3 = document.createElement('td')
          celda3.innerHTML = data[i].ancho;

          var celda4 = document.createElement('td')
          celda4.innerHTML = data[i].alto;
  
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
      var col = coleccion.find(a => a.idColeccion==id);
      sessionStorage.setItem('idColeccion',col.idColeccion);
      sessionStorage.setItem('nombreCol',col.nombreCol);
      sessionStorage.setItem('ancho',col.ancho);
      sessionStorage.setItem('alto',col.alto);


       window.location.href = '../html/modificarColeccion.html';

     });
   });