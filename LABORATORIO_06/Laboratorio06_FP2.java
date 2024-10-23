/*
  Autor : Chipana Jeronimo German Arturo
  Proposito : Laboratorio 06
*/
package laboratorio06_fp2;


public class Laboratorio06_FP2 {

    public static void main(String[] args) {
        VideoJuego3 juego=new VideoJuego3(10, 10);
        juego.mostrarTablero();
        juego.mostrarSoldadosMayorVida(1, juego.ejercito1);
        juego.mostrarSoldadosMayorVida(2, juego.ejercito2);
        juego.mostrarPromedioNivelVida(1, juego.ejercito1);
        juego.mostrarPromedioNivelVida(2, juego.ejercito2);
        juego.mostrarSoldadosOrdenCreacion(1, juego.ejercito1);
        juego.mostrarSoldadosOrdenCreacion(2, juego.ejercito2);
    }
    
}
