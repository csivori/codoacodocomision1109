const maxTiempo = 100000;

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
        this.posY += this.incY;
    }
};

function mover1T() {
    if (tiempo > maxTiempo) { clearInterval(intervalId); }
    else {
        // console.log(`Tiempo: ${++tiempo}`)
        zona1.mover();
        zona1.mostrar();
    };
}

let zona1 = new Zona(1, 50, 25, 250, 180, 'lightgray', "zona",
    new Elementos([new Elemento(1, 8, 10, 0, 1, 1, 'red'),
                   new Elemento(2, 8, 0, 0, 2, 1, 'green'),
                   new Elemento(3, 16, 20, 30, 1, 2, 'blue'),
                   new Elemento(4, 12, 30, 10, 3, 3, 'magenta'),
                   new Elemento(5, 8, 30, 10, 1, 0, 'white')]));
zona1.mostrar();
var intervalId = setInterval(mover1T, 20);
tiempo = 0;