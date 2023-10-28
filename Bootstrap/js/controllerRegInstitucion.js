function registrarColeccion(){
    var idInstitucion = document.getElementById("idInstitucion").value;    
    var nombreInst = document.getElementById("nombreInst").value;
    var siglasInst = document.getElementById("siglasInst").value;


    console.log(idInstitucion,nombreInst,siglasInst)

    var details = {
        idInstitucion:idInstitucion,
        nombreInst:nombreInst,
        siglasInst:siglasInst
    };

    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    console.log(formBody);
    
    fetch('http://localhost:8080/institucion/registrarInstitucion', {
      method: 'POST', 
      headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
      body: formBody
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
}