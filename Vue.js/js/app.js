console.log("Hola Vue");
// //Ejemplo 1
// var app = new Vue({
//     el: "#app",
//     data: {
//         message: "Hola Mundo con Vue",
//     }
// });
//        app.message="Cambio mensaje";

// //Ejemplo 2
// var app = new Vue({
//     el: "#app",
//     data: {
//         valorModel: "Hola",
//         valorBind: "Hola",
//         link:"https://vuejs.org/v2/guide/",
//         nombreLink: "Doc de Vue"
//     }
// });

// //Ejemplo 3
// var app = new Vue({
//     el: "#app",
//     data: {
//         nombre: "",
//         tecnologias: ["HTML","CSS","Javascript"]
//     }
// });

// //Ejemplo 4
// new Vue({
//     el: "#formVue",
//     data: {
//         tareas: [],
//         nuevasTarea:""
//     },
//     methods:{
//         guardarTarea(){
//             this.tareas.push(this.nuevaTarea);
//             this.nuevaTarea = "";
//         }
//     }
// });

//Ejemplo 5 (idem 4 pero con Vanilla JS)
let tareas = [];
let formulario = document.querySelector("form");
formulario.onsubmit = ev =>{
    ev.preventDefault();
    tareas.push(document.querySelector(".nuevaTarea").value);
    document.querySelector(".nuevaTarea").value = ""
    mostrarTarea();
}

function mostrarTarea() {
    document.querySelector("ul").innerHTML = "";
    tareas.forEach(tarea => {
        document.querySelector("ul").innerHTML += `<li>${tarea}</li>`;});}
