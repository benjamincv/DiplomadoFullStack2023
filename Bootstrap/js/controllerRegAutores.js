function registrarAutores(){
    var idAutores = document.getElementById("idAutores").value;    
    var nombreAutor = document.getElementById("nombreAutor").value;
    var gradoAcademico = document.getElementById("gradoAcademico").value;
    var institucion = document.getElementById("institucion").value;

    console.log(idAutores,nombreAutor,gradoAcademico,institucion)

    var details = {
        idAutores:idAutores,
        nombreAutor:nombreAutor,
        gradoAcademico:gradoAcademico,
        institucion:institucion
    };

    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    console.log(formBody);
    
    fetch('http://localhost:8080/autores/registrarAutores', {
      method: 'POST', 
      headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
      body: formBody
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
}