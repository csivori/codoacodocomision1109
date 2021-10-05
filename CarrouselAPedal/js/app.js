let arrFotos = ['ba1.jpg', 'ba2.jpg', 'ba3.jpg'];
let sPuntos = "";
let numFoto = 0;

function refrescar() {
    console.log(numFoto);
    imagen.innerHTML = `<img id="Img1" src="./img/${arrFotos[numFoto]}" width=100% alt="">`;
    sPuntos= "";
    arrFotos.forEach(crearPuntos);
    puntos.innerHTML = sPuntos;
}

function crearPuntos(item, index) {
    if (index == numFoto){
        sPuntos += "<div id='Punto" + (index + 1).toString() + "' class='PuntoActivo'></div>"
    } else {
        sPuntos += '<div id="Punto' + (index + 1).toString() + '" class="Punto"></div>';
    }};

let imagen = document.getElementById("Imagen");
let puntos = document.getElementById("Puntos");
refrescar();
document.getElementById("Atras").addEventListener('click', function () {
    numFoto = (--numFoto + arrFotos.length) % arrFotos.length; refrescar();
});
document.getElementById("Adelante").addEventListener('click', function () {
    numFoto = ++numFoto % arrFotos.length; refrescar();
});
