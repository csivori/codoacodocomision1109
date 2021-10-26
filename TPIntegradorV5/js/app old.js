// **************************
// *** VARIABLES GLOBALES ***
// **************************
const correoValido = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
const nombreValido = /^[a-zA-ZÀ-ÿ\s]{1,40}$/; // Letras y espacios, pueden llevar acentos.
const telefonoValido = /^[+]\d{7,14}$/; // 7 a 14 numeros.
let estaEnModoCompraTicket = true;
let elemNavBarLogo = document.getElementById("CaC-NavBarLogo");
let elemSoloView = document.getElementById("CaC-SoloView");
let elemComprar = document.getElementById("CaC-SoloComprar");

// **************************
// *** FUNCIONES GLOBALES ***
// **************************
function comprarTickets() {
    console.log("Entró en comprarTickets()");
    estaEnModoCompraTicket = !estaEnModoCompraTicket;
    mostrarMain();
}

function BorrarFormTickets() {
    alert("Estoy en BorrarFormTickets()");
}

function ResumenTickets() {
    if (EsValidoFrmCpra()) {
        let elemFrmCpraTotalAPagar = document.querySelector("#CaC-FrmCompra #totalAPagar");
        elemFrmCpraTotalAPagar.setAttribute.value = `Total a Pagar: $ 200.-`
    }
}

// **************************
// *** FUNCIONES PRIVADAS ***
// **************************
function mostrarMain() {
    if (estaEnModoCompraTicket) {
        elemNavBarLogo.style.display = 'none';
        elemSoloView.style.display = 'none';
        elemComprar.style.display = 'block';

    } else {
        elemNavBarLogo.style.display = 'inline'
        elemSoloView.style.display = 'block';
        elemComprar.style.display = 'none';
    }
}

const reValidarFrmCpraNombre = () => {
    let elemFrmCpraNombre = document.querySelector("#CaC-FrmCompra #nombre");
    elemFrmCpraNombre.removeEventListener('change', reValidarFrmCpraNombre);
    EsValidoFrmCpraNombre();
}

const reValidarFrmCpraApellido = () => {
    let elemFrmCpraApellido = document.querySelector("#CaC-FrmCompra #apellido");
    elemFrmCpraApellido.removeEventListener('change', reValidarFrmCpraApellido);
    EsValidoFrmCpraApellido();
}

const reValidarFrmCpraCorreo = () => {
    let elemFrmCpraCorreo = document.querySelector("#CaC-FrmCompra #correo");
    elemFrmCpraCorreo.removeEventListener('change', reValidarFrmCpraCorreo);
    EsValidoFrmCpraCorreo();
}

const reValidarFrmCpraCantidad = () => {
    let elemFrmCpraCantidad = document.querySelector("#CaC-FrmCompra #cantidad");
    elemFrmCpraCantidad.removeEventListener('change', reValidarFrmCpraCantidad);
    EsValidoFrmCpraCantidad();
}

const reValidarFrmCpraCategoria = () => {
    let elemFrmCpraCategoria = document.querySelector("#CaC-FrmCompra #categoria");
    elemFrmCpraCategoria.removeEventListener('change', reValidarFrmCpraCategoria);
    EsValidoFrmCpraCategoria();
}

function EsValidoFrmCpraNombre() {
    let elemFrmCpraNombre = document.querySelector("#CaC-FrmCompra #nombre");
    if (elemFrmCpraNombre.value == "") {
        elemFrmCpraNombre.style = `border: 3px dashed red`;
        elemFrmCpraNombre.addEventListener('change', reValidarFrmCpraNombre);
        return false
    } else {
        elemFrmCpraNombre.style = `border: 1px solid #ced4da;`;
        return true
    }
}

function EsValidoFrmCpraApellido() {
    let elemFrmCpraApellido = document.querySelector("#CaC-FrmCompra #apellido");
    if (elemFrmCpraApellido.value == "") {
        elemFrmCpraApellido.style = `border: 3px dashed red`;
        elemFrmCpraApellido.addEventListener('change', reValidarFrmCpraApellido);
        return false
    } else {
        elemFrmCpraApellido.style = `border: 1px solid #ced4da;`;
        return true
    }
}

function EsValidoFrmCpraCorreo() {
    let elemFrmCpraCorreo = document.querySelector("#CaC-FrmCompra #correo");
    if (elemFrmCpraCorreo.value == "") {
        elemFrmCpraCorreo.style = `border: 3px dashed red`;
        elemFrmCpraCorreo.addEventListener('change', reValidarFrmCpraCorreo);
        return false
    } else {
        elemFrmCpraCorreo.style = `border: 1px solid #ced4da;`;
        return true
    }
}

function EsValidoFrmCpraCantidad() {
    let elemFrmCpraCantidad = document.querySelector("#CaC-FrmCompra #cantidad");
    if ((elemFrmCpraCantidad.value == "") || (parseInt(elemFrmCpraCantidad.value) == 0)) {
        elemFrmCpraCantidad.style = `border: 3px dashed red`;
        elemFrmCpraCantidad.addEventListener('change', reValidarFrmCpraCantidad);
        return false
    } else {
        elemFrmCpraCantidad.style = `border: 1px solid #ced4da;`;
        console.log(parseInt(elemFrmCpraCantidad.value))
        return true
    }
}

function EsValidoFrmCpraCategoria() {
    let elemFrmCpraCategoria = document.querySelector("#CaC-FrmCompra #categoria");
    if (elemFrmCpraCategoria.value == "") {
        elemFrmCpraCategoria.style = `border: 3px dashed red`;
        elemFrmCpraCategoria.addEventListener('change', reValidarFrmCpraCategoria);
        return false
    } else {
        elemFrmCpraCategoria.style = `border: 1px solid #ced4da;`;
        return true
    }
}

// **************************
// **** FUNCION GENERICA ****
// **************************

const reValidarFrmCpraCampo = (campo, funcEsValido) => {
    console.log(`3.1.-Se disparó reValidarFrmCpraCampo('${campo}', '${funcEsValido}'`);
    let elemFrmCpraCampo = document.querySelector(`#CaC-FrmCompra ${campo}`);
    console.log(`3.2.-Identifiqué campo "${elemFrmCpraCampo.id}" en reValidarFrmCpraCampo()`);
    elemFrmCpraCampo.removeEventListener('change', ()=>{reValidarFrmCpraCampo(campo, funcEsValido)});
    console.log(`3.3.-Removí el EventListener 'CHANGE' del campo "${elemFrmCpraCampo.id}" en reValidarFrmCpraCampo()`);
    EsValidoFrmCpraCampo(campo, funcEsValido, false);
    console.log(`3.4.-Llamo a validar el cambio con EsValidoFrmCpraCampo(${campo}, ${funcEsValido}, false) en reValidarFrmCpraCampo()`);
}

function EsValidoFrmCpraCampo(campo, funcEsValido, setearFoco) {
    let elemFrmCpraCampo = document.querySelector(`#CaC-FrmCompra ${campo}`);
    console.log(`2.1.-Voy a validar Nombre en EsValidoFrmCpraCampo()`);
    if (funcEsValido(elemFrmCpraCampo.value)) {
        console.log(`2.2.-El Nombre es Válido en EsValidoFrmCpraCampo()`);
        elemFrmCpraCampo.style = `border: 1px solid #ced4da;`;
        return true
    } else {
        console.log(`2.3.-El Nombre '${elemFrmCpraCampo.value}' es INVálido en EsValidoFrmCpraCampo()`);
        elemFrmCpraCampo.style = `border: 3px dashed red`;
        if (setearFoco) { elemFrmCpraCampo.focus() };
        console.log(`2.4.-Activo Evento CHANGE en campo "${elemFrmCpraCampo.id}" en EsValidoFrmCpraCampo()`);
        elemFrmCpraCampo.addEventListener('change', ()=>{reValidarFrmCpraCampo(campo, funcEsValido)});
        console.log(`2.5.-Activé Evento CHANGE en campo "${elemFrmCpraCampo.id}" en EsValidoFrmCpraCampo()`);
        return false
    }
}

function EsValidoFrmCpra() {
    console.log(`1.1.-Entro en EsValidoFrmCpra()`);
    console.log(`1.2.-Voy a validar Nombre en EsValidoFrmCpra()`);
    if (EsValidoFrmCpraCampo('#nombre', (v)=>{console.log(`4.1.-Validando el valor: '${v}'`); return ((v != "") && (nombreValido.test(v)))}, true)){
        console.log(`1.3.-Voy a validar Apellido en EsValidoFrmCpra()`);
    // if (EsValidoFrmCpraNombre()) {
        if (EsValidoFrmCpraApellido()) {
            if (EsValidoFrmCpraCorreo()) {
                if (EsValidoFrmCpraCantidad()) {
                    if (EsValidoFrmCpraCategoria()) {
                        return true;
                    } else { }
                } else { }
            } else { }
        } else { }
    } else { }
}






// *****************************************************************
// *****************************************************************
// var validarSoloTexto = function (campo, setearfoco) {
//     return validarGenerico(campo, setearfoco, ((campo.value.length >
//         0) && (nombreValido.test(campo.value))))
// }
// var validarTelefono = function (campo, setearfoco) {
//     return validarGenerico(campo, setearfoco, ((campo.value.length >
//         0) && (telefonoValido.test(campo.value))))
// }
// var validarCorreo = function (campo, setearfoco) {
//     return validarGenerico(campo, setearfoco, ((campo.value.length >
//         0) && (correoValido.test(campo.value))))
// }
// var validarPaquete = function (campo, setearfoco) {
//     return validarGenerico(campo, setearfoco, (campo.value != 0))
// }
// //Pongo el borde rojo, al campo o lo saco, segun si la validacion
// dio tue o false
// var validarGenerico = function (campo, setearfoco, esValido) {
//     if (esValido) {
//         campo.classList.remove('borde-rojo'); //saco borde rojo de
//         error
//         document.querySelector(`#${campo.id}-
// error`).classList.add('apagado'); //saco mensaje de error
//         return true;
//     } else {
//         campo.classList.add('borde-rojo'); //pongo borde rojo campo
//         error
//         document.querySelector(`#${campo.id}-
// error`).classList.remove('apagado'); //pongo mensaje de error
//         if (setearfoco) { campo.focus() }; //setea el foco en el
//         campo
//         campo.addEventListener('focusout', () => { reValidar(campo) }); //prende la alarma -Vuelvo a ver si ingreso
//         algo
//         return false;
//     }
// }
// var reValidar = function (campo) {
//     campo.removeEventListener('focusout', () => { reValidar(campo) }); //apaga la alarma focusout
//     switch (campo.id) {
//         case 'nombre':
//             validarSoloTexto(campo, false);
//             break;
//         case "apellido":
//             validarSoloTexto(campo, false);
//             break;
//         case "telefono":
//             validarTelefono(campo, false);
//             break;
//         case "correo":
//             validarCorreo(campo, false);
//             break;
//         case "interes":
//             validarPaquete(campo, false);
//             break;
//         default: break;
//     }
// }
// ////Ejecuta el Formulario - El Main
// document.addEventListener('keyup', (e) => {
//     if (e.keyCode == '13'
//         && !estoyValidando) { validarFormulario() }
// }); //Enter ==> boton
// enviar
// document.getElementById("telefono").addEventListener("focusin", ()
//     => {
//         if (formulario.telefono.value == "") { formulario.telefono.value = "+" }
// });
// let estoyValidando = false;
// var validarFormulario = function () {
//     if (validarSoloTexto(this.nombre, true)) {
//         if (validarSoloTexto(this.apellido, true)) {
//             if (validarTelefono(this.telefono, true)) {
//                 if (validarCorreo(this.correo, true)) {
//                     if (validarPaquete(this.interes, true)) {
//                         estoyValidando = true;
//                         //Utilizo swal = sweetalert2 - Para mostrar
//                         cartel
//                         document.removeEventListener('keyup', null);
//                         // ,(e) => { if (e.keyCode == '13')
//                         validarFormulario()
//                     });
//                     swal.fire({
//                         title: `Muchas Gracias ${this.nombre.value}
// ${this.apellido.value} por su Consulta!!`,
//                         icon: 'warning',
//                         showCancelButton: true,
//                         confirmButtonColor: 'rgb(13, 55, 125)',
//                         cancelButtonColor: '#d33',
//                         confirmButtonText: 'Confirmar'
//                     }).then((result) => {
//                         if (result.value) {
//                             swal.fire({
//                                 title: '¡Registrado!',
//                                 text: 'Duante las proximas 24hs
// responderemos su Consulta.',
// icon: 'success',
//                                 confirmButtonColor: 'rgb(13, 55,
// 125)'
//                         }).then(() => {
//                             estoyValidando = false;
//                             formulario.submit();
//                         })
//                 }
//             });
//         }
//     }
// }
// }
// }
// }