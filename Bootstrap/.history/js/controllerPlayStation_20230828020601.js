function registrarPlayStation(){
    var noSerie = document.getElementById("noSerie").value;
    var nombre = document.getElementById("nombre").value;
    var paisDeOrigen = document.getElementById("paisDeOrigen").value;
    var year = document.getElementById("year").value;

    console.log(noSerie)

    var details = {
        noSerie:noSerie,
        nombre:nombre,
        paisDeOrigen:paisDeOrigen,
        year:year
    };

    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");
    
    fetch('http://localhost:8080/PlayStation/registrarPlayStation', {
      method: 'POST',
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