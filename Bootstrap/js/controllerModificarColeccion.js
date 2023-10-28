window.onload = function () {
    EstablecerDatos();
}

function EstablecerDatos(){
  
    document.getElementById("idColeccion").value = sessionStorage.getItem('idColeccion');
    document.getElementById("nombreCol").value = sessionStorage.getItem('nombreCol');
    document.getElementById("ancho").value = sessionStorage.getItem('ancho');
    document.getElementById("alto").value = sessionStorage.getItem('alto');

}
function modificarColeccion(){
    var idColeccion = document.getElementById("idColeccion").value;
    var nombreCol = document.getElementById("nombreCol").value;
    var ancho = document.getElementById("ancho").value;
    var alto = document.getElementById("alto").value;

    console.log(idColeccion,nombreCol,ancho,alto)

    var details = {
        idColeccion:idColeccion,
        nombreCol:nombreCol,
        ancho:ancho,
        alto:alto
    };

    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    console.log(formBody);
    
    fetch('http://localhost:8080/coleccion/modificarColeccion', {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
      },
      body: formBody
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
}