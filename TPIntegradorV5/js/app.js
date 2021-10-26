// **************************
// *** VARIABLES GLOBALES ***
// **************************
const correoValido = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
const nombreValido = /^[a-zA-ZÀ-ÿ\s]{1,40}$/; // Letras y espacios, pueden llevar acentos.
const telefonoValido = /^[+]\d{7,14}$/; // 7 a 14 numeros.
const precioTicket = 200;
let mostrarPaso = false; //Lo uso en true para debuggear en la consola
let estaEnModoCompraTicket = false;
let elemNavBarLogo = document.getElementById("CaC-NavBarLogo");
let elemSoloView = document.getElementById("CaC-SoloView");
let elemComprar = document.getElementById("CaC-SoloComprar");

// **************************
// *** FUNCIONES PUBLICAS ***
// **************************
function comprarTickets() {
    mp("Entró en comprarTickets()");
    estaEnModoCompraTicket = !estaEnModoCompraTicket;
    mostrarMain();
}

function borrarFormTickets() {
    mp("Estoy en BorrarFormTickets()");
    let arrInput = document.querySelectorAll("#CaC-FrmCompra input, #CaC-FrmCompra select");
    mp(arrInput);
    arrInput.forEach((campo) => {campo.value = ""});
    document.querySelector("#CaC-FrmCompra #totalAPagar").innerHTML = `Total a Pagar: $`
}

function resumenTickets() {
    if (esValidoFrmCpra()) {
        mp(`5.1.-Entró en resumenTickets()`);
        let elemFrmCpraTotalAPagar = document.querySelector("#CaC-FrmCompra #totalAPagar");
        mp(`5.2.-Seleccionó ${elemFrmCpraTotalAPagar.id} con valor ${elemFrmCpraTotalAPagar.innerHTML} en resumenTickets()`);
        resultado = calcularCostoTickets()
        elemFrmCpraTotalAPagar.innerHTML = `<strong>Total a Pagar: $ ${resultado.total}</strong> (<small>Detalle: ${resultado.detalle}</small>)`;
        mp(`5.3.-Recalculó ${elemFrmCpraTotalAPagar.id} con valor ${elemFrmCpraTotalAPagar.innerHTML} en resumenTickets()`);
    }
}
// ********************
// *****   MAIN   *****
// ********************

mostrarMain();

// **************************
// *** FUNCIONES PRIVADAS ***
// **************************
function mostrarMain() {
    if (estaEnModoCompraTicket) {
        elemNavBarLogo.style.display = 'none';
        elemSoloView.style.display = 'none';
        elemComprar.style.display = 'flex';

    } else {
        elemNavBarLogo.style.display = 'inline'
        elemSoloView.style.display = 'block';
        elemComprar.style.display = 'none';
    }
}

function calcularCostoTickets() {
    let cat = document.querySelector("#CaC-FrmCompra #categoria").value;
    let descuento = parseFloat((cat == "E") ? 0.8 : (cat == "T") ? 0.5 : 0.15);
    let cantidad = parseInt(document.querySelector("#CaC-FrmCompra #cantidad").value)
    let total = parseFloat(cantidad * parseFloat(precioTicket) * (1 - descuento));
    return {total:`${fmtCosto.format(total)}`, detalle:`${fmtCant.format(cantidad)} x $${fmtCosto.format(precioTicket * (1-descuento))}`} 
}

// *********************************
// **** FUNCIONES para FORMATEO ****
// *********************************

let fmtCosto  = new Intl.NumberFormat('es-AR', {minimumFractionDigits: 2, maximumFractionDigits: 2});
let fmtCant  = new Intl.NumberFormat('es-AR', {minimumFractionDigits: 0, maximumFractionDigits: 0});

// ******************************************
// **** FUNCION para VALIDACION GENERICA ****
// ******************************************

const reValidarFrmCpraCampo = (campo, funcEsValido) => {
    mp(`3.1.-Se disparó reValidarFrmCpraCampo('${campo}', '${funcEsValido}'`);
    let elemFrmCpraCampo = document.querySelector(`#CaC-FrmCompra ${campo}`);
    mp(`3.2.-Identifiqué campo "${elemFrmCpraCampo.id}" en reValidarFrmCpraCampo()`);
    elemFrmCpraCampo.removeEventListener('change', ()=>{reValidarFrmCpraCampo(campo, funcEsValido)});
    mp(`3.3.-Removí el EventListener 'CHANGE' del campo "${elemFrmCpraCampo.id}" en reValidarFrmCpraCampo()`);
    esValidoFrmCpraCampo(campo, funcEsValido, false);
    mp(`3.4.-Llamo a validar el cambio con EsValidoFrmCpraCampo(${campo}, ${funcEsValido}, false) en reValidarFrmCpraCampo()`);
}

function esValidoFrmCpraCampo(campo, funcEsValido, setearFoco) {
    let elemFrmCpraCampo = document.querySelector(`#CaC-FrmCompra ${campo}`);
    mp(`2.1.-Voy a validar ${elemFrmCpraCampo.id} en EsValidoFrmCpraCampo()`);
    if (funcEsValido(elemFrmCpraCampo.value)) {
        mp(`2.2.-${elemFrmCpraCampo.id} es Válido en EsValidoFrmCpraCampo()`);
        elemFrmCpraCampo.style = `border: 1px solid #ced4da;`;
        return true
    } else {
        mp(`2.3.-${elemFrmCpraCampo.id} '${elemFrmCpraCampo.value}' es INVálido en EsValidoFrmCpraCampo()`);
        elemFrmCpraCampo.style = `border: 3px dashed red`;
        if (setearFoco) { elemFrmCpraCampo.focus() };
        mp(`2.4.-Activo Evento CHANGE en campo "${elemFrmCpraCampo.id}" en EsValidoFrmCpraCampo()`);
        elemFrmCpraCampo.addEventListener('change', ()=>{reValidarFrmCpraCampo(campo, funcEsValido)});
        mp(`2.5.-Activé Evento CHANGE en campo "${elemFrmCpraCampo.id}" en EsValidoFrmCpraCampo()`);
        return false
    }
}

function esValidoFrmCpra() {
    mp(`1.1.-Entro en EsValidoFrmCpra()`);
    mp(`1.2.-Voy a validar Nombre en EsValidoFrmCpra()`);
    if (esValidoFrmCpraCampo('#nombre', (v)=>{mp(`4.1.-Validando el valor: '${v}'`); return ((v != "") && (nombreValido.test(v)))}, true)){
        mp(`1.3.-Voy a validar Apellido en EsValidoFrmCpra()`);
        if (esValidoFrmCpraCampo('#apellido', (v)=>{mp(`4.2.-Validando el valor: '${v}'`); return ((v != "") && (nombreValido.test(v)))}, true)){
            if (esValidoFrmCpraCampo('#correo', (v)=>{mp(`4.3.-Validando el valor: '${v}'`); return ((v != "") && (correoValido.test(v)))}, true)){
                if (esValidoFrmCpraCampo('#cantidad', (v)=>{mp(`4.4.-Validando el valor: '${v}'`); return ((v != "") && (parseInt(v) > 0))}, true)){
                    if (esValidoFrmCpraCampo('#categoria', (v)=>{mp(`4.5.-Validando el valor: '${v}'`); return (v != "")}, true)){
                        mp(`4.6.-Validación Completa en EsValidoFrmCpra()`);
                        return true;
                    }
                }
            }
        }
    } 
    return false;
}

const mp = (msg) => {(mostrarPaso) ? console.log(msg) : null}