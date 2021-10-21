// Variables Globales
let estaEnModoCompraTicket = false;

comprarTickets();

function comprarTickets(){
    console.log("Entró en comprarTickets()");
    estaEnModoCompraTicket = !estaEnModoCompraTicket;
    mostrarMain();
}

function mostrarMain(){
    elemHeaderMsg = document.getElementById("CaC-Hdr");
    elemSoloView = document.getElementById("CaC-SoloView");
    elemComprar = document.getElementById("CaC-SoloComprar");
    if (estaEnModoCompraTicket){
        elemHeaderMsg.style.display = 'none';
        elemSoloView.style.display = 'none';
        elemComprar.style.display = 'block';

    } else {
        elemHeaderMsg.style.display = 'flex'
        elemSoloView.style.display = 'block';
        elemComprar.style.display = 'none';
    }
}