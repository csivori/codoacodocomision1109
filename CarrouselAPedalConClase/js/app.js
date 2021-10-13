class boton {
    constructor(tag, color, caption){this.tag = tag; this.color = color; this.caption = caption;}
    mostrar(){
        let elem = document.querySelector(this.tag);
        elem.innerHTML += `<style>button{background-color: ${this.color};</style><button type="button">${this.caption}</button>`}
}
const tonbo = new boton("body", "red", "Soy una clase");
tonbo.mostrar();