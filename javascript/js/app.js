alert("Hola Mundo");
console.log("Estamos en la console");
const apellido = "Sivori";
let nombre = "Carlos";
var nombre2 = "Alberto";
let estaSoleado = true;
let num1 = 10;
let num2 = 5;
console.log(num1 + num2);
console.log(nombre + nombre2 + apellido);
console.log(nombre + nombre2 + apellido + num1 * 5 + 3);
console.log(nombre + nombre2 + apellido + (num1 * 5 + 3));

/* Condicionales */
/* Igual ==  /  Distinto !=  /  And &&  /  Or ||  */
if (num1 == num2) {
    console.info("if: num1 = num2");
}
else {
    if (num1 > num2) {
        console.info("if: num1 > num2");
    }
    else {
        console.info("else: num1 < num2");
    }
}
console.warn("Modo Ternario:", (num1 > num2) ? "if: num1 > num2" : "else: num1 < num2"); /* Modo Ternario */
if (num1 > num2 && estaSoleado) {
    console.error("Verdadero");
} else {
    console.error("Falso");
}
if (num1 < num2 || estaSoleado != true) {
    console.error("Verdadero");
} else {
    console.error("Falso");
}

let elemento = document.getElementById("secundario")
console.log(elemento)
elemento.innerHTML="<h1 class='text-center'>Hola " + nombre + " " + nombre2 + "</h1>";
document.write("<h1 class='text-center bg-info'>"+ nombre + "</h1>")