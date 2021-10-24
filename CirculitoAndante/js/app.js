// ******************
// ****  CLASES  ****
// ******************

class Zonas {
    constructor(idPadre) {
        this.zonas = [];
        this.intervalId = 0;
        this.zonaPadre = document.getElementById(idPadre);
    }
    push(zona) {
        this.zonas.push(zona);
    }
    pushElemento(zonaId, elemento) {
        this.zonas.forEach((z) => { if (z.getID() == zonaId) { z.pushElemento(elemento) } });
    }
    eliminarZona(id) {
        let newzonas = [];
        this.zonas.forEach((z, index) => { if (z.getID() != id) { newzonas.push(z) } });
        this.zonas = newzonas;
    }
    setRefreshRate(msegs, funcion) {
        if (msegs) {
            this.intervalId = setInterval(funcion, msegs);
            console.log(`Framing Seteado en ${msegs} msegs.`);
        } else {
            if (this.intervalId) {
                clearInterval(this.intervalId);
                this.intervalId = 0;
            } else {
                alert("No hay Animación Activa");
            }
        }
    }
    mover1T() {
        this.zonas.forEach((z) => { z.mover() });
        this.mostrar();
    }
    mostrar() {
        let script = "";
        this.zonas.forEach((z) => { script += z.getHTML() });
        this.zonaPadre.innerHTML = script;
    }
    getNewZonaID() {
        let maxID = 0;
        this.zonas.forEach((z) => { if (maxID < z.getID()) { maxID = z.getID() } });
        return parseInt(maxID) + 1;
    }
    getNewElementoID(zonaId) {
        let id = 1
        this.zonas.forEach((z) => { if (z.getID() == zonaId) { id = z.getNewElementoID() } });
        return id;
    }
}

class Zona {
    constructor(id, posX, posY, ancho, alto, color, idPadre, elementos) {
        let padre = document.getElementById(idPadre);
        this.id = parseInt(id);
        this.posX = parseInt(posX);
        this.posY = parseInt(posY);
        console.log('padre.offsetWidth: ' + padre.offsetWidth);
        console.log('posX: ' + posX);
        console.log('ancho: ' + ancho);
        console.log('posX + ancho: ' + (posX + ancho));
        this.ancho = (padre.offsetWidth < (parseInt(posX) + parseInt(ancho))) ? padre.offsetWidth - parseInt(posX) : parseInt(ancho);
        this.alto = (padre.offsetHeight < (parseInt(posY) + parseInt(alto))) ? padre.offsetWidth - parseInt(posY) : parseInt(alto);
        this.color = color;
        this.idPadre = idPadre;
        this.elementos = (elementos === null) ? new Elementos() : elementos;
    }
    getHTML() {
        return `<div id="zona${this.id}" class="zona" style="top: ${this.posY}px; left: ${this.posX}px; background: ${this.color}; width:${this.ancho}px; height:${this.alto}px;">${this.id}${(this.elementos !== null) ? this.elementos.getHTML() : ""}</div>`;
    }
    getID() {
        return this.id.toString().replace('zona', '');
    }
    getNewElementoID() {
        return (this.elementos === null) ? 1 : this.elementos.getNewElementoID();
    }
    mostrar() {
        document.getElementById(this.idPadre).innerHTML = this.getHTML();
    }
    mover() { (this.elementos !== null) ? this.elementos.mover(0, 0, this.ancho - 2, this.alto - 2) : ""; }
    pushElemento(elemento) { this.elementos.push(elemento) }
};

class Elementos {
    constructor() { this.elementos = []; }
    push(elemento) { this.elementos.push(elemento); }
    getHTML() {
        let script = "";
        this.elementos.forEach((elem) => { script += elem.getHTML(); });
        return script;
    }
    getNewElementoID() {
        if (this.elementos.length == 0) { return 1 }
        let maxID = 0;
        this.elementos.forEach((e) => { if (maxID < e.id) { maxID = e.id } });
        return parseInt(maxID) + 1;
    }
    mover(minX, minY, maxX, maxY) {
        this.elementos.forEach((elem) => { elem.mover(minX, minY, maxX, maxY); });
    }
}

class Elemento {
    constructor(id, radio, posX, posY, incX, incY, color) {
        this.id = id;
        this.radio = radio;
        this.posX = posX;
        this.posY = posY;
        this.incX = incX;
        this.incY = incY;
        this.color = color;
    }
    getHTML() {
        return `<div id="elemento${this.id}" class="elemento" style="top: ${this.posY}px; left: ${this.posX}px; background: ${this.color}; width:${this.radio * 2}px; height:${this.radio * 2}px; border-radius:${this.radio + 1}px;">${this.id}</div>`
    }
    mover(minX, minY, maxX, maxY) {
        if ((this.posX + this.incX + (this.radio * 2) > maxX) || (this.posX + this.incX < minX)) { this.incX = -this.incX };
        this.posX += this.incX;
        if ((this.posY + this.incY + (this.radio * 2) > maxY) || (this.posY + this.incY < minY)) { this.incY = -this.incY };
        this.posY += this.incY;
    }
};

// *********************
// ****  FUNCIONES  ****
// *********************

const ifCampoVacio = (campo, defecto) => {
    return (campo == "") ? defecto : campo;
}
const crearZona = () => {
    conjuntoZonas.push(new Zona(
        ifCampoVacio(document.getElementById('zonaID').value, conjuntoZonas.getNewZonaID()),
        ifCampoVacio(document.getElementById('ZposX').value, 0),
        ifCampoVacio(document.getElementById('ZposY').value, 0),
        ifCampoVacio(document.getElementById('ancho').value, 100),
        ifCampoVacio(document.getElementById('alto').value, 100),
        ifCampoVacio(document.getElementById('bkColor').value, 'gray'),
        "zona", null));
}

const eliminarZona = () => {
    if (document.getElementById('zonaID').value != "") {
        conjuntoZonas.eliminarZona(document.getElementById('zonaID').value);
    } else {
        alert("Debe especificar el ID de Zona a eliminar")
    }
}

const crearElemento = () => {
    let zonaID = ifCampoVacio(document.getElementById('zonaID').value, "0");
    if (zonaID != "") {
        conjuntoZonas.pushElemento(zonaID, new Elemento(
            ifCampoVacio(document.getElementById('etiqueta').value, conjuntoZonas.getNewElementoID(zonaID)),
            ifCampoVacio(document.getElementById('dimension').value, 8),
            ifCampoVacio(document.getElementById('posX').value, 0),
            ifCampoVacio(document.getElementById('posY').value, 0),
            ifCampoVacio(document.getElementById('incX').value, 1),
            ifCampoVacio(document.getElementById('incY').value, 1),
            ifCampoVacio(document.getElementById('bkColor').value, 'white')));
    } else {
        alert("Debe especificar el ID de Zona donde desea agregar este Elemento");
    }
};

// conjuntoZonas.pushElemento(new Zona(
//     ifCampoVacio(document.getElementById('zonaID').value, conjuntoZonas.getNewZonaID()),
//     ifCampoVacio(document.getElementById('ZposX').value, 0),
//     ifCampoVacio(document.getElementById('ZposY').value, 0),
//     ifCampoVacio(document.getElementById('ancho').value, 100),
//     ifCampoVacio(document.getElementById('alto').value, 100),
//     ifCampoVacio(document.getElementById('bkColor').value, 'gray'),
//     "zona", null));

// ****************
// ****  MAIN  ****
// ****************

let conjuntoElementos = new Elementos();
conjuntoElementos.push(new Elemento(1, 8, 10, 0, 1, 1, 'red'));
conjuntoElementos.push(new Elemento(2, 8, 0, 0, 2, 1, 'green'));
conjuntoElementos.push(new Elemento(3, 16, 20, 30, 1, 2, 'blue'));
conjuntoElementos.push(new Elemento(4, 12, 30, 10, 3, 3, 'magenta'));
conjuntoElementos.push(new Elemento(5, 8, 30, 10, 1, 0, 'white'));
let conjuntoZonas = new Zonas("zona");
conjuntoZonas.push(new Zona(1, 25, 25, 250, 180, 'lightgray', "zona", conjuntoElementos));
conjuntoZonas.setRefreshRate(20, () => { conjuntoZonas.mover1T(); });