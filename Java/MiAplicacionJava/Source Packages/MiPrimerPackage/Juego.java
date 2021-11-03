package MiPrimerPackage;

public class Juego {
    public int puntos,vidas;
    public String personajes, enemigos, armas;
    Juego(int puntos,int vidas, String armas, String personajes, String enemigos){
        this.puntos = puntos;
        this.vidas = vidas;
        this.armas = armas;
        this.personajes = personajes;
        this.enemigos = enemigos;
    }
    public String mostrarVidas(){
        return "Te quedan " + this.vidas + " vidas";
    } 
}
