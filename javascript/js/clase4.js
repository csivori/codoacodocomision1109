let elemento = document.getElementById('principal');
let btn = document.getElementById('btn');
btn.addEventListener('click', inicio);
function inicio(){alert('Llamando a la función inicio')};
window.addEventListener('load', function(){elemento.innerHTML = `
<form>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="button" class="btn btn-primary" onclick="inicio()">Submit</button>
</form>
`});

let usuario = {
    NyA: 'Pepito FLORES',
    email: 'pepe@yahoo.com',
    pass:'123456',
    validar:(e,p)=>{return (e === usuario.email && p === usuario.pass) ? true : false},
    mostrar:()=>{alert(`El email de ${usuario.NyA} es ${usuario.email}`)}
};

function inicio(){
    // ev.preventDefault();
    let correo = document.getElementById("exampleInputEmail1").value;
    let contrasenia = document.getElementById("exampleInputPassword1").value;
    // alert('Llamando a la función inicio');
    // alert(correo);
    // alert(contrasenia);
    if (usuario.validar(correo, contrasenia)){
      elemento.innerHTML = `<h1>Administración</h1><p>Bienvenid@ ${usuario.NyA}</p>`;
      usuario.mostrar();
    }
    else{alert("El correo o la contraseña son inválidos. Reintente");};
};