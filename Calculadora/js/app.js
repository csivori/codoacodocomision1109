let primeraCarga = true;
let valor1 = "";
let valor2 = "";
let operacion = "";
let resultado = 0;
let reInicializar = false;

let logBase = (msg) => { console.log(`${msg}`); }
let log = (msg, caracter) => { logBase(`${msg} - C:${caracter}, V1:${valor1}, V2:${valor2}, Op:${operacion}, reIni:${reInicializar}, Re:${resultado}`); }
let tieneDecimales = (valor) => { return (parseFloat(valor) != parseInt(valor)) }
let borrarUltimoCaracter = (valor) => {
    let val = valor.toString();
    if (val.length > 0) {
        val = val.substr(0, --val.length);
        if ((tieneDecimales(valor)) && (val.charAt(--val.length) == ".")) { val = val.substr(0, --val.length) }
    } else { beep() }
    return val;
}
let inicializar = () => {
    if (reInicializar) { valor1 = ""; operacion = ""; reInicializar = false }
    else if (valor1 == "") { primeraCarga ? primeraCarga = false : beep() }
    else if (operacion == "") { valor1 = "" }
    else if (valor2 == "") { operacion = "" };
    valor2 = ""; resultado = 0;
}
let agregarCaracter = (valor, caracter) => {
    let val = valor.toString();
    if (caracter == ".") {
        if (val == "") {
            return "0."
        } else if (val.includes(".")) { beep(); return val }
    }
    return val + caracter;
}
function calcularOperacion(caracter) {
    switch (caracter) {
        case '+':
        case '-':
        case '*':
        case '/':
        case '%':
            if (operacion == "") {
                operacion = caracter;
            } else {
                if (valor2 == "") {
                    operacion = caracter;
                } else {
                    if (reInicializar == false) { calcularOperacion("=") };
                    reInicializar = false;
                    valor1 = resultado.toString();
                    valor2 = "";
                    operacion = caracter;
                    resultado = 0;
                }
            }
            break;
        case '=':
            switch (operacion) {
                case '+':
                    resultado = parseFloat(valor1) + parseFloat(valor2);
                    break;
                case '-':
                    resultado = parseFloat(valor1) - parseFloat(valor2);
                    break;
                case '*':
                    resultado = parseFloat(valor1) * parseFloat(valor2);
                    break;
                case '/':
                    resultado = parseFloat(valor1) / parseFloat(valor2);
                    break;
                case '%':
                    resultado = parseFloat(valor1) * 100 / parseFloat(valor2);
                    break;
            }
            resultado.toString().substr(0, 16);
            reInicializar = true;
    }
}
function presiono(caracter) {
    log("****** Entró a la función presiono", caracter);
    switch (caracter) {
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case '.':
            if (reInicializar == true) { inicializar() };
            log("Es un Nro", caracter);
            operacion == "" ? valor1 = agregarCaracter(valor1, caracter) : valor2 = agregarCaracter(valor2, caracter);
            break;
        case 'AC':
            if (reInicializar == true) { reInicializar = false };
            inicializar();
            break;
        case 'Bk':
            if (reInicializar == true) { inicializar(); reInicializar = false; };
            operacion == "" ? valor1 = borrarUltimoCaracter(valor1) : (valor2 == "" ? operacion = "" : valor2 = borrarUltimoCaracter(valor2));
            break;
        case '+-':
            if (reInicializar == true) { inicializar(); reInicializar = false; };
            operacion == "" ? valor1 = (valor1 == "" ? "-" : -parseFloat(valor1)) : valor2 = (valor2 == "" ? "-" : -parseFloat(valor2));
            break;
        case '-':
            //Tratamiento cuando se simulara cambio de signo de valor1
            if (operacion == "" && valor1 == "") { presiono("+-"); break }
        case '+':
        case '*':
        case '/':
        case '%':
        case '=':
            calcularOperacion(caracter);
            break;
    }
    log("Post Nro", caracter);
    Formula.innerHTML = "<p>=" + valor1 + operacion + valor2 + "</p>"
    Resultado.innerHTML = "<p>" + resultado.toString().substr(0, 16) + "</p>"
}

function presionoTecla(evt) {
    let codTecla = evt.keyCode || evt.which;
    let tecla = String.fromCharCode(codTecla).toLowerCase();
    logBase(`Presiono Tecla (${codTecla}, ${tecla})`)
    // %*+-./0..9=
    if ((codTecla == 37) || (codTecla >= 42 && codTecla <= 43) || (codTecla >= 45 && codTecla <= 57) || (codTecla == 61)) { logBase(`KEY-PRESS ${tecla}`); presiono(tecla) }
    // , --> .
    else if (codTecla == 44) { logBase(`KEY-PRESS .`); presiono(".") }
    else if (codTecla == 13) { logBase(`KEY-PRESS =`); presiono("=") }
    else if (codTecla == 8) { logBase(`KEY-PRESS Bk`); presiono('Bk') }
    else if (codTecla == 27) { logBase(`KEY-PRESS AC`); presiono('AC') }
    else { beep() }
}

function presionoTeclaEsp(evt) {
    let codTecla = evt.keyCode || evt.which;
    logBase(`Presiono Tecla Esp (${codTecla})`)
    if (codTecla == 8) { logBase(`KEY-PRESS Bk`); presiono('Bk') }
    else if (codTecla == 27) { logBase(`KEY-PRESS AC`); presiono('AC') }
}

let agregarAccionClick = (id, caracter) => {
    let Boton = document.getElementById(id);
    Boton.addEventListener('click', function () { presiono(caracter) }, false);
}

let Resultado = document.getElementById("resultado");
let Formula = document.getElementById("formula");
// agregarAccionKeyPress("calculadora", )
window.onload = function () { document.onkeypress = presionoTecla; document.onkeyup = presionoTeclaEsp };
agregarAccionClick("comadecimal", ".");
agregarAccionClick("cero", "0");
agregarAccionClick("uno", "1");
agregarAccionClick("dos", "2");
agregarAccionClick("tres", "3");
agregarAccionClick("cuatro", "4");
agregarAccionClick("cinco", "5");
agregarAccionClick("seis", "6");
agregarAccionClick("siete", "7");
agregarAccionClick("ocho", "8");
agregarAccionClick("nueve", "9");
agregarAccionClick("inicializar", "AC");
agregarAccionClick("masmenos", "+-");
agregarAccionClick("porcentaje", "%");
agregarAccionClick("dividir", "/");
agregarAccionClick("multiplicar", "*");
agregarAccionClick("restar", "-");
agregarAccionClick("sumar", "+");
agregarAccionClick("borrarCaracter", "Bk");
agregarAccionClick("igual", "=");
inicializar()

// FUNCIONES de BASE
function beep() { sonido.play() };

const sonido = new Audio("data:audio/wav;base64,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qJrx4KOQjahZxWbcZgztj2c49nKmkId44S71j0c8eV9yDK6uPRzx5X18eDvjvQ6yKo9ZSS6l//8elePK/Lf//IInrOF/FvDoADYAGBMGb7FtErm5MXMlmPAJQVgWta7Zx2go+8xJ0UiCb8LHHdftWyLJE0QIAIsI+UbXu67dZMjmgDGCGl1H+vpF4NSDckSIkk7Vd+sxEhBQMRU8j/12UIRhzSaUdQ+rQU5kGeFxm+hb1oh6pWWmv3uvmReDl0UnvtapVaIzo1jZbf/pD6ElLqSX+rUmOQNpJFa/r+sa4e/pBlAABoAAAAA3CUgShLdGIxsY7AUABPRrgCABdDuQ5GC7DqPQCgbbJUAoRSUj+NIEig0YfyWUho1VBBBA//uQZB4ABZx5zfMakeAAAAmwAAAAF5F3P0w9GtAAACfAAAAAwLhMDmAYWMgVEG1U0FIGCBgXBXAtfMH10000EEEEEECUBYln03TTTdNBDZopopYvrTTdNa325mImNg3TTPV9q3pmY0xoO6bv3r00y+IDGid/9aaaZTGMuj9mpu9Mpio1dXrr5HERTZSmqU36A3CumzN/9Robv/Xx4v9ijkSRSNLQhAWumap82WRSBUqXStV/YcS+XVLnSS+WLDroqArFkMEsAS+eWmrUzrO0oEmE40RlMZ5+ODIkAyKAGUwZ3mVKmcamcJnMW26MRPgUw6j+LkhyHGVGYjSUUKNpuJUQoOIAyDvEyG8S5yfK6dhZc0Tx1KI/gviKL6qvvFs1+bWtaz58uUNnryq6kt5RzOCkPWlVqVX2a/EEBUdU1KrXLf40GoiiFXK///qpoiDXrOgqDR38JB0bw7SoL+ZB9o1RCkQjQ2CBYZKd/+VJxZRRZlqSkKiws0WFxUyCwsKiMy7hUVFhIaCrNQsKkTIsLivwKKigsj8XYlwt/WKi2N4d//uQRCSAAjURNIHpMZBGYiaQPSYyAAABLAAAAAAAACWAAAAApUF/Mg+0aohSIRobBAsMlO//Kk4soosy1JSFRYWaLC4qZBYWFRGZdwqKiwkNBVmoWFSJkWFxX4FFRQWR+LsS4W/rFRb/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////VEFHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAU291bmRib3kuZGUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMjAwNGh0dHA6Ly93d3cuc291bmRib3kuZGUAAAAAAAAAACU=");
