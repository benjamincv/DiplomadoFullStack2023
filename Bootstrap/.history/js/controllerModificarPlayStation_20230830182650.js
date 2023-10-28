window.onload = function () {
    EstablecerDatos();
}

function EstablecerDatos(){
  
    document.getElementById("noSerie").value = sessionStorage.getItem('noSerie');
    document.getElementById("nombre").value = sessionStorage.getItem('nombre');
    document.getElementById("paisDeOrigen").value = sessionStorage.getItem('paisOrigen');
    document.getElementById("year").value = sessionStorage.getItem('year');

}
