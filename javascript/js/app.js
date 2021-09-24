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
console.log(elemento);
elemento.innerHTML="<h1 class='text-center'>Hola " + nombre + " " + nombre2 + "</h1>";
document.write("<h1 class='text-center bg-info'>"+ nombre + "</h1>");

/* Interacción con el Usuario */
let n1 = prompt("Decime el Primer Valor");
let n2 = prompt("Decime el Segundo Valor");
suma = n1 + n2;
suma2 = parseInt(n1) + parseInt(n2);
suma3 = null;
operacion = "La suma de " + n1 + " + " + n2 + " = " + suma2;
alert("La suma es: " + suma + ".... What ???");
alert("Hay que usar parseInt(), sino los numeros serán strings. Con parseInt() la suma es: " + suma2 + ".... Eeeehhh !!!");

document.write("<h1>La SUPER Calcu</h1>");
document.write("<p>" + operacion + "</p>");
document.write("<h1>La función var.<i>length</i></h1>");
document.write("<p>El resultado " + suma + " tiene: " + suma.length + " caracteres</p>");
document.write("<h1>La función var.<i>repeat(n)</i></h1>");
document.write("<p>El resultado " + suma + " repetido 3 veces es: " + suma.repeat(3) + "</p>");
document.write("<h1>La función <i>typeof</i> var</h1>");
document.write("<p>El resultado de typeof suma es: " + typeof(suma) + " [" + suma + "]</p>");
document.write("<p>El resultado de typeof suma2 es: " + typeof(suma2) + " [" + suma2 + "]</p>");
document.write("<p>El resultado de typeof suma3 es: " + typeof(suma3) + " [" + suma3 + "]</p>");
document.write("<p>El resultado de typeof suma4 es: " + typeof(suma4) + " []</p>");

document.write("<h1>RESUMEN</h1>");
document.write("<table>");
document.write("<tr><td colspan='2'><h3>Manejo de Datos</h3></td></tr>");
document.write("<tr><td>var y let</td><td>Para definir variables. (Mejor let)</td></tr>");
document.write("<tr><td>const</td><td>Para definir Constantes</td></tr>");
document.write("<tr><td colspan='2'><h3>Manejo de la Consola</h3></td></tr>");
document.write("<tr><td>console.log() / console.info()</td><td>Para mostrar mensajes y valores x la Consola</td></tr>");
document.write("<tr><td>console.warn()</td><td>Para mostrar mensajes y valores x la Consola en Amarillo</td></tr>");
document.write("<tr><td>console.error()</td><td>Para mostrar mensajes y valores x la Consola en Rojo</td></tr>");
document.write("<tr><td colspan='2'><h3>Manejo de la Interacción con el Usuario</h3></td></tr>");
document.write("<tr><td>alert()</td><td>Para mostrar mensajes y valores x Pantalla. Simil MsgBox() de VB.</td></tr>");
document.write("<tr><td>prompt()</td><td>Para solicitar valores x Pantalla. Simil InputBox() de VB.</td></tr>");
document.write("<tr><td colspan='2'><h3>Manejo del Código HTML</h3></td></tr>");
document.write("<tr><td>document.write()</td><td>Para agregar código HTML en la Página.</td></tr>");
document.write("<tr><td>document.getElementById()</td><td>Para obtener un elemento con un ID y luego xej. agregar código HTML dentro de ese elemento en la Página.</td></tr>");
document.write("<tr><td>document.getElementById().innerHTML='<p>...'</td><td>Para agregar código HTML dentro del elemento con ese ID en la Página.</td></tr>");
document.write("<tr><td colspan='2'><h3>Manejo de Condiciones</h3></td></tr>");
document.write("<tr><td>=</td><td>Para asignar un valor. NO COMPARA!!</td></tr>");
document.write("<tr><td>==</td><td>Compara igualdad de 2 valores. NO COMPARA OBJETOS!!</td></tr>");
document.write("<tr><td>===</td><td>Compara igualdad del contenido de 2 objetos.</td></tr>");
document.write("<tr><td>!=</td><td>Comparar desigualdad de 2 valores.</td></tr>");
document.write("<tr><td>&& y ||</td><td>AND y OR</td></tr>");
document.write("<tr><td>Sintaxis</td><td>if (<strong><i>condición</i></strong>) {<strong><i>acción x Verdadero</i></strong>} else {<strong><i>acción x Falso</i></strong>}</td></tr>");



// /* Condicionales */
// /* Igual ==  /  Distinto !=  /  And &&  /  Or ||  */
// if (num1 == num2) {
//     console.info("if: num1 = num2");
// }
// else {
//     if (num1 > num2) {
//         console.info("if: num1 > num2");
//     }
//     else {
//         console.info("else: num1 < num2");
//     }
// }
// console.warn("Modo Ternario:", (num1 > num2) ? "if: num1 > num2" : "else: num1 < num2"); /* Modo Ternario */
// if (num1 > num2 && estaSoleado) {
//     console.error("Verdadero");
// } else {
//     console.error("Falso");
// }
// if (num1 < num2 || estaSoleado != true) {
//     console.error("Verdadero");
// } else {
//     console.error("Falso");
// }
