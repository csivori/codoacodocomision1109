const maxTiempo = 30;
const radioElemento = 9;
let zona = document.getElementById("zona");
anchoZona = zona.offsetWidth;
altoZona = zona.offsetHeight;
anchoZonaLimite = anchoZona - (radioElemento * 2) - 6;
altoZonaLimite = altoZona - (radioElemento * 2) - 6;
console.log(`Zona [Ancho:${anchoZonaLimite} / Alto:${altoZonaLimite}]`);
let elementos = [];
const colores = ['red', 'green', 'blue', 'yellow', 'magenta', 'white']

class Zona {
    constructor(id, posX, posY, ancho, alto, color, idPadre, elementos) {
        let padre = document.getElementById(idPadre);
        this.id = id;
        this.posX = posX;
        this.posY = posY;
        this.ancho = (padre.offsetWidth < (posX + ancho)) ? padre.offsetWidth-posX : ancho;
        this.alto = (padre.offsetHeight < (posY + alto)) ? padre.offsetWidth-posY : alto;
        this.color = color;
        this.idPadre = idPadre;
        this.elementos = elementos;
    }
    getHTML() {
        return `<div id="zona${this.id}" class="zona" style="top: ${this.posY}px; left: ${this.posX}px; background: ${this.color}; width:${this.ancho}px; height:${this.alto}px;">${this.elementos.getHTML()}</div>`;
    }
    mostrar() {
        document.getElementById(this.idPadre).innerHTML = this.getHTML();
    }
    mover() { this.elementos.mover(0, 0, this.ancho - 6, this.alto - 6); }
};

class Elementos {
    constructor(elementos) { this.elementos = elementos; }
    getHTML() {
        let script = "";
        this.elementos.forEach((elem) => { script += elem.getHTML(); });
        return script;
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
        if ((this.posX + this.incX + (this.radio*2) > maxX) || (this.posX + this.incX < minX)) { this.incX = -this.incX };
        this.posX += this.incX;
        if ((this.posY + this.incY + (this.radio*2) > maxY) || (this.posY + this.incY < minY)) { this.incY = -this.incY };
        // if (this.id == 1) { console.log(`       this1Y:${this.posY} -> ${this.posY += this.incY}`) }
        this.posY += this.incY;
    }
};

let zona1 = new Zona(1, 50, 50, 200, 180, 'lightgray', "zona",
    new Elementos([new Elemento(1, 8, 10, 0, 1, 1, 'red'),
//                   new Elemento(2, 8, 0, 0, 2, 1, 'green'),
//                   new Elemento(4, 12, 30, 10, 3, 3, 'magenta'),
//                   new Elemento(5, 4, 30, 10, 1, 0, 'black'),
                   new Elemento(3, 8, 20, 30, 1, 2, 'blue')]));

zona1.mostrar();
var intervalId = setInterval(mover1T, 50);
tiempo = 0;
function mover1T() {
    if (tiempo > maxTiempo) { clearInterval(intervalId); }
    else {
        // console.log(`Tiempo: ${++tiempo}`)
        zona1.mover();
        zona1.mostrar();
    };
}