let valor1 = "";
let valor2 = "";
let operacion = "";
let resultado = 0;
let reInicializar = false;

function tieneDecimales(valor) {
    return (parseFloat(valor) != parseInt(valor));
}

function borrarUltimoCaracter(valor) {
    let val = valor.toString();
    val = val.substr(0, --val.length);
    if ((tieneDecimales(valor)) && (val.charAt(--val.length) == ".")) { val = val.substr(0, --val.length); }
    return val;
}

function inicializar() {
    if (operacion == "") {valor1 = "";}
    if (valor2 == "") {operacion = "";}
    valor2 = "";
    resultado = 0;
}

function agregarCaracter(valor, caracter) {
    let val = valor.toString();
    if (caracter == ".") {
        if (val == "") {
            return "0."
        } else {
            // if (val.search("[.]") > 0) {return val;}
            if (val.includes(".")) {return val;}
        }
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
                    reInicializar == true ? reInicializar = false : calcularOperacion("=");
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
            reInicializar = true;
    }
}

function presiono(caracter) {
    console.log("Entró a la función presiono(" + caracter + ")");
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
            if (reInicializar == true){inicializar(); reInicializar = false;};
            console.log("Es un Nro: " + caracter + ", V1: " + valor1 + ", V2: " + valor2);
            operacion == "" ? valor1 = agregarCaracter(valor1, caracter) : valor2 = agregarCaracter(valor2, caracter);
            break;
        case 'AC':
            if (reInicializar == true){reInicializar = false;};
            inicializar();
            break;
        case 'Bk':
            if (reInicializar == true){inicializar(); reInicializar = false;};
            operacion == "" ? valor1 = borrarUltimoCaracter(valor1) : (valor2 == "" ? operacion = "" : valor2 = borrarUltimoCaracter(valor2));
            break;
        case '+-':
            if (reInicializar == true){inicializar(); reInicializar = false;};
            operacion == "" ? valor1 = -parseFloat(valor1) : valor2 = -parseFloat(valor2);
            break;
        case '+':
        case '-':
        case '*':
        case '/':
        case '%':
        case '=':
            calcularOperacion(caracter);
            break;
    }
    console.log("Post Nro: " + caracter + ", V1: " + valor1 + ", V2: " + valor2 + ", oper: " + operacion + ", R: " + resultado + ", reIni: " + reInicializar);
    Formula.innerHTML = "<p>=" + valor1 + operacion + valor2 + "</p>"
    Resultado.innerHTML = "<p>" + resultado + "</p>"
}

function presionoTecla(evt){
    var codTecla = e.keyCode || e.which;
    var tecla = String.fromCharCode(codTecla).toLowerCase();
    var letras = "0123456789+-*/%";
    var especiales = "8-37-39-46";

    va
}

let agregarAccionClick = (id, caracter) => {
    let Boton = document.getElementById(id);
    Boton.addEventListener('click', function(){ presiono(caracter) }, false);}

let agregarAccionKeyPress = (id, caracter) => {
    let Boton = document.getElementById(id);
    Boton.addEventListener('keypress', function(){ presionoTecla()}, false);}

let Resultado = document.getElementById("resultado");
let Formula = document.getElementById("formula");
agregarAccionKeyPress("calculadora", )
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
