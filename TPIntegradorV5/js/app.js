// **************************
// *** VARIABLES GLOBALES ***
// **************************
const correoValido = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
const nombreValido = /^[a-zA-ZÀ-ÿ\s]{1,40}$/; // Letras y espacios, pueden llevar acentos.
const telefonoValido = /^[+]\d{7,14}$/; // 7 a 14 numeros.
const precioTicket = 200;
let mostrarPaso = true; //Lo uso en true para debuggear en la consola
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
    arrInput.forEach((campo) => { campo.value = "" });
    document.querySelector("#CaC-FrmCompra #totalAPagar").innerHTML = `Total a Pagar: $`;
    document.querySelector("#CaC-FrmCompra input").focus();
}

function resumenTickets() {
    if (esValidoFrmCpra()) {
        mp(`5.1.-Entró en resumenTickets()`);
        let elemFrmCpraTotalAPagar = document.querySelector("#CaC-FrmCompra #totalAPagar");
        mp(`5.2.-Seleccionó ${elemFrmCpraTotalAPagar.id} con valor ${elemFrmCpraTotalAPagar.innerHTML} en resumenTickets()`);
        resultado = calcularCostoTickets()
        elemFrmCpraTotalAPagar.innerHTML = `<strong>Total a Pagar: $ ${resultado.total}</strong> (<small>Detalle: ${resultado.detalle}</small>)`;
        forzarScrRefresh(elemFrmCpraTotalAPagar, () => { alert('En Construcción: Ahora se calculará el Total A Pagar y en el futuro Lanzar Proceso de Compra !!!'); });
        mp(`5.3.-Recalculó ${elemFrmCpraTotalAPagar.id} con valor ${elemFrmCpraTotalAPagar.innerHTML} en resumenTickets()`);
//        alert('En Construcción: Ahora se calculará el Total A Pagar y en el futuro Lanzar Proceso de Compra !!!');
    }
}

let intervalId = 0;
function forzarScrRefresh(elemento, funcionPosterior) {
    // No anduvo:
    // let displayActual = elemFrmCpraTotalAPagar.style.display;
    // elemFrmCpraTotalAPagar.style.display = 'none';
    // elemFrmCpraTotalAPagar.style.display = displayActual;

    intervalId = setInterval((hnd) => { mp(`handler: ${hnd} / intervalId: ${intervalId}`); clearInterval(intervalId); funcionPosterior(); }, 500);
    mp(`Framing Seteado en 500 msegs.`);
}

function conocerMasElLugar() {
    alert('En Construcción: Conocer mas El Lugar !!!');
    irA("#");
}

function inscripcionOrador() {
    if (esValidoFrmOrador()) {
        alert('En Construcción: Orador Inscripto !!!');
        irA("#");
    }
}

function irA(marcador) {
    if (estaEnModoCompraTicket) { comprarTickets(); }
    document.location.href = marcador;
    if (marcador == "#CaC-Inscripcion") { document.querySelector("#CaC-Inscripcion input").focus() };
}

function setearCategoria(opcion) {
    document.querySelector("#CaC-FrmCompra select").value = opcion;
    document.querySelector("#CaC-FrmCompra input").focus();
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
        document.querySelector("#CaC-FrmCompra input").focus();
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
    return { total: `${fmtCosto.format(total)}`, detalle: `${fmtCant.format(cantidad)} x $${fmtCosto.format(precioTicket * (1 - descuento))}` }
}

// *********************************
// **** FUNCIONES para FORMATEO ****
// *********************************

let fmtCosto = new Intl.NumberFormat('es-AR', { minimumFractionDigits: 2, maximumFractionDigits: 2 });
let fmtCant = new Intl.NumberFormat('es-AR', { minimumFractionDigits: 0, maximumFractionDigits: 0 });

// ******************************************
// **** FUNCION para VALIDACION GENERICA ****
// ******************************************

const reValidarFormCampo = (idformulario, idcampo, funcEsValido) => {
    mp(`3.1.-Se disparó reValidarFrmCpraCampo('${idformulario}', '${idcampo}', '${funcEsValido}'`);
    let elemFormCampo = document.querySelector(`${idformulario} ${idcampo}`);
    mp(`3.2.-Identifiqué campo "${elemFormCampo.id}" en reValidarFormCampo()`);
    elemFormCampo.removeEventListener('change', () => { reValidarFormCampo(idformularion, idcampo, funcEsValido) });
    mp(`3.3.-Removí el EventListener 'CHANGE' del campo "${elemFormCampo.id}" en reValidarFormCampo()`);
    esValidoFormCampo(idformulario, idcampo, funcEsValido, false);
    mp(`3.4.-Llamo a validar el cambio con EsValidoFormCampo(${idformulario}, ${idcampo}, ${funcEsValido}, false) en reValidarFormCampo()`);
}

function esValidoFormCampo(idformulario, idcampo, funcEsValido, setearFoco) {
    let elemFormCampo = document.querySelector(`${idformulario} ${idcampo}`);
    mp(`2.1.-Voy a validar ${elemFormCampo.id} en EsValidoFormCampo()`);
    if (funcEsValido(elemFormCampo.value)) {
        mp(`2.2.-${elemFormCampo.id} es Válido en EsValidoFormCampo()`);
        elemFormCampo.style = `border: 1px solid #ced4da;`;
        return true
    } else {
        mp(`2.3.-${elemFormCampo.id} '${elemFormCampo.value}' es INVálido en EsValidoFormCampo()`);
        elemFormCampo.style = `border: 3px dashed red`;
        if (setearFoco) { elemFormCampo.focus() };
        mp(`2.4.-Activo Evento CHANGE en campo "${elemFormCampo.id}" en EsValidoFormCampo()`);
        elemFormCampo.addEventListener('change', () => { reValidarFormCampo(idformulario, idcampo, funcEsValido) });
        mp(`2.5.-Activé Evento CHANGE en campo "${elemFormCampo.id}" en EsValidoFormCampo()`);
        return false
    }
}

function esValidoFrmOradorCampo(campo, funcEsValido, setearFoco) {
    return esValidoFormCampo('#CaC-FormParaAnotarseH', campo, funcEsValido, setearFoco);
}

function esValidoFrmCpraCampo(campo, funcEsValido, setearFoco) {
    return esValidoFormCampo('#CaC-FrmCompra', campo, funcEsValido, setearFoco);
}

function esValidoFrmOrador() {
    mp(`1.1.-Entro en esValidoFrmOrador()`);
    mp(`1.2.-Voy a validar Nombre en esValidoFrmOrador()`);
    if (esValidoFrmOradorCampo('#nombreOrador', (v) => { mp(`4.1.-Validando el valor: '${v}'`); return ((v != "") && (nombreValido.test(v))) }, true)) {
        mp(`1.3.-Voy a validar Apellido en esValidoFrmOrador()`);
        if (esValidoFrmOradorCampo('#apellidoOrador', (v) => { mp(`4.2.-Validando el valor: '${v}'`); return ((v != "") && (nombreValido.test(v))) }, true)) {
            if (esValidoFrmOradorCampo('#temaOrador', (v) => { mp(`4.5.-Validando el valor: '${v}'`); return (v != "") }, true)) {
                mp(`4.6.-Validación Completa en EsValidoFrmOrador()`);
                return true;
            }
        }
    }
    return false;
}

function esValidoFrmCpra() {
    mp(`1.1.-Entro en EsValidoFrmCpra()`);
    mp(`1.2.-Voy a validar Nombre en EsValidoFrmCpra()`);
    if (esValidoFrmCpraCampo('#nombre', (v) => { mp(`4.1.-Validando el valor: '${v}'`); return ((v != "") && (nombreValido.test(v))) }, true)) {
        mp(`1.3.-Voy a validar Apellido en EsValidoFrmCpra()`);
        if (esValidoFrmCpraCampo('#apellido', (v) => { mp(`4.2.-Validando el valor: '${v}'`); return ((v != "") && (nombreValido.test(v))) }, true)) {
            if (esValidoFrmCpraCampo('#correo', (v) => { mp(`4.3.-Validando el valor: '${v}'`); return ((v != "") && (correoValido.test(v))) }, true)) {
                if (esValidoFrmCpraCampo('#cantidad', (v) => { mp(`4.4.-Validando el valor: '${v}'`); return ((v != "") && (parseInt(v) > 0)) }, true)) {
                    if (esValidoFrmCpraCampo('#categoria', (v) => { mp(`4.5.-Validando el valor: '${v}'`); return (v != "") }, true)) {
                        mp(`4.6.-Validación Completa en EsValidoFrmCpra()`);
                        return true;
                    }
                }
            }
        }
    }
    return false;
}

const mp = (msg) => { (mostrarPaso) ? console.log(msg) : null }