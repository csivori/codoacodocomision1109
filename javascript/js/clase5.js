let elemento = document.querySelector("#principal");

/** Arrays **/
let mascotas = [];
mascotas[0] = { propietario: "Claudio", especie: "Loro", raza: "Barranquero", edad: "3", peso: "0.5", foto: "./img/loro.jfif", practica: "consulta" };
mascotas.push({ propietario: "Mauro", especie: "Lagarto", raza: "Overo", edad: "7", peso: "2", foto: "./img/lagarto.jfif", practica: "consulta" });

const grabarMascota = (i, bViewOnly) => {
  if (bViewOnly){
    mascotas.splice(i, 1);
  } else{
    let datos = document.querySelectorAll("input");
    let mascota = {
      propietario: datos[0].value,
      especie: datos[1].value,
      raza: datos[2].value,
      edad: datos[3].value,
      peso: datos[4].value,
      foto: datos[5].value,
      practica: (datos[6].checked) ? "urgencia" : "consulta"
    }
    console.log(i + " - " + ((isNaN(i)) ? "E" : "NO e") + "s NaN");
    if (isNaN(i)) { mascotas.push(mascota) } else { mascotas[i] = mascota };  
  }
  mostrarMascotas();
}

const BorrarMascota = (i) => {
  CrearFormulario(i, true);
}

const ModificarMascota = (i) => {
  CrearFormulario(i);
}

const mostrarMascotas = () => {
  elemento.innerHTML = ""
  for (let a = 0; a < mascotas.length; a++) {
    elemento.innerHTML += `
          <div class="card m-lg" style="width: 24%;">
            <img src="${mascotas[a].foto}" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Propietario: ${mascotas[a].propietario}</h5>
              <p class="card-text">Especie: ${mascotas[a].especie}</p>
              <p class="card-text">Raza: ${mascotas[a].raza}</p>
              <p class="card-text">Edad: ${mascotas[a].edad}</p>
              <p class="card-text">Peso: ${mascotas[a].peso}</p>
              <p class="card-text">Tipo de Práctica: ${mascotas[a].practica}</p>
              <div>
                <a href="#" class="btn btn-primary btn-lg" onclick="CrearFormulario(${a})"><i class="far fa-edit"></i></a>
                <a href="#" class="btn btn-danger btn-lg" onclick="CrearFormulario(${a}, true)"><i class="far fa-trash-alt"></i></a>
                <a href="#" class="btn btn-success btn-lg" onclick="CrearFormulario()"><i class="fas fa-folder-plus"></i></a>
              </div>
            </div>
          </div>`
  }
};

/* {propietario, especie, raza, edad, peso, imagen, tipoConsulta} */
const CrearFormulario = (i, bViewOnly) => {
  bViewOnly = (bViewOnly || false);
  elemento.innerHTML = `
      <form>
        <div class="mb-3">
          <label for="propietario" class="form-label">Propietario</label>
          <input type="text" class="form-control" id="propietario" value=${(i == null) ?
      "" : mascotas[i].propietario} ${(bViewOnly)?"disabled":""}>
        </div>
        <div class="mb-3">
          <label for="especie" class="form-label">Especie</label>
          <input type="texto" class="form-control" id="especie" value=${(i == null) ?
      "" : mascotas[i].especie} ${(bViewOnly)?"disabled":""}>
        </div>
        <div cRass="mb-3">
          <label for="raza" class="form-label">Raza</label>
          <input type="texto" class="form-control" id="raza" value=${(i == null) ?
      "" : mascotas[i].raza} ${(bViewOnly)?"disabled":""}>
        </div>
        <div classdadmb-3">
          <label for="edad" class="form-label">Edad</label>
          <input type="texto" class="form-control" id="edad" value=${(i == null) ?
      "" : mascotas[i].edad} ${(bViewOnly)?"disabled":""}>
        </div>
        <div class="mb-3">
          <label for="peso" class="form-label">Peso</label>
          <input type="texto" class="form-control" id="peso" value=${(i == null) ?
      "" : mascotas[i].peso} ${(bViewOnly)?"disabled":""}>
        </div>
        <div class="mb-3">
          <label for="img" class="form-label">Img</label>
          <input type="texto" class="form-control" id="img" value=${(i == null) ?
      "" : mascotas[i].foto} ${(bViewOnly)?"disabled":""}>
        </div>
        <div class="mb-3 form-check">
          <input type="radio" class="form-check-input" name="practica" id="urgencia" ${(i != null && mascotas[i].practica == "urgencia") ? "checked":""} ${(bViewOnly)?"disabled":""}>
          <label class="form-check-label" for="urgencia">Urgencia</label>
        </div>
        <div class="mb-3 form-check">
          <input type="radio" class="form-check-input" name="practica" 
          id="consulta" ${(i != null && mascotas[i].practica == "consulta") ? "checked":""} ${(bViewOnly)?"disabled":""}>
          <label class="form-check-label" for="consulta">Consulta</label>
        </div>
        <button type="button" class="btn btn-primary" onclick="grabarMascota(${i}, ${bViewOnly})" default>${(i == null) ?
      "Agregar" : (bViewOnly)?"Borrar":"Modificar"} Datos</button>
      </form>`;
};

const CrearFormulario4 = () => {
for (var i=0; i<2; i++){
  continue
}
console.log(i);
}
CrearFormulario4();
// mostrarMascotas();