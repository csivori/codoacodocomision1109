let nombre = prompt("Ingresá tu nombre!");
let miDiv = document.getElementById("principal");
miDiv.innerHTML = "Hola "+nombre;
console.log("Escribió Hola");
let miBtn = document.getElementById("btn");
console.log("Obtengo Elemento Botón");
miBtn.addEventListener('click',sumar);
console.log("Agregó Listener");

function sumar(){
    console.log("Entró a la función");
    let num = parseInt(prompt("Ingresa el 1º Número"));
    let num2 = parseInt(prompt("Ingresa el 2º Número"));
    let resultado = num + num2;
    miDiv.innerHTML += "<p>" + resultado + "</p>" 
}