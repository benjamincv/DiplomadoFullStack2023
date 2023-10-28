window.onload = function () {
    EstablecerDatos();
}

function EstablecerDatos(){
  
    document.getElementById("noSerie").value = sessionStorage.getItem('noSerie');
    document.getElementById("nombre").value = sessionStorage.getItem('nombre');
    document.getElementById("paisDeOrigen").value = sessionStorage.getItem('paisOrigen');
    document.getElementById("year").value = sessionStorage.getItem('year');

}
function modificarPlayStation(){
    var noSerie = document.getElementById("noSerie").value;
    var nombre = document.getElementById("nombre").value;
    var paisDeOrigen = document.getElementById("paisDeOrigen").value;
    var year = document.getElementById("year").value;

    console.log(noSerie,nombre,paisDeOrigen,year)

    var details = {
        noSerie:noSerie,
        nombre:nombre,
        paisOrigen:paisDeOrigen,
        year:year
    };

    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    console.log(formBody);
    
    fetch('http://localhost:8080/PlayStation/modificarPlayStation', {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
      },
      param: formBody
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
}