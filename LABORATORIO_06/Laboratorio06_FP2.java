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
    }
    
}
