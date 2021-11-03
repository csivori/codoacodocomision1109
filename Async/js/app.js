async function obtenerPosicion(){
    const response = await fetch("https://api.wheretheiss.at/v1/satellites/25544");
    console.log(response);
    const data = await response.json();
    console.log(data);

    const {latitude, longitude, velocity, visibility} = data;

    console.log(latitude);
    console.log(longitude);
    console.log(velocity);
    console.log(visibility);

    document.getElementById("lat").textContent = latitude;
    document.getElementById("lon").textContent = longitude;
    document.getElementById("vel").textContent = velocity;    
// Visibilidad no existe en el HTML y lo creo generando el HTML en este Javascript "<br>Visibilidad:<span id="vis"></span>"
 // Genero el <br>
    let br = document.createElement('br');
 
    // Genero el <span id="vis"></span>
    let span = document.createElement('span');
    span.setAttribute("id", "vis");
 
    // Agrego el valor leido en el JSON   
    span.textContent = visibility;

 // Inserto en el HTML, como no tengo el padre, le pregunto a "vel" y luego le agrego el elemento "vis"
    let parentelem = document.getElementById("vel").parentElement; 
    parentelem.appendChild(br);
    parentelem.append(` Visibilidad:`);
    parentelem.appendChild(span);

}
obtenerPosicion();