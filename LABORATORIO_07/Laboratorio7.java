/*
  Autor : Chipana Jeronimo German Arturo
  Proposito : Laboratorio 07
*/
package laboratorio7;

import java.util.*;
public class Laboratorio7 {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String respuesta="s";
        while("s".equals(respuesta)){
            VideoJuego4 juego=new VideoJuego4(10, 10);  // Crea una instancia del juego con un tablero de 10x10
            juego.mostrarTablero(); // Muestra el tablero actual con los soldados colocados
            juego.mostrarSoldadosMayorVida(1, juego.ejercito1); // Muestra el soldado con mayor nivel de vida del Ejército 1
            juego.mostrarSoldadosMayorVida(2, juego.ejercito2); // Muestra el soldado con mayor nivel de vida del Ejército 2
            juego.mostrarPromedioNivelVida(1, juego.ejercito1); // Calcula y muestra el promedio de nivel de vida del Ejército 1
            juego.mostrarPromedioNivelVida(2, juego.ejercito2); // Calcula y muestra el promedio de nivel de vida del Ejército 2
            juego.mostrarSoldadosOrdenCreacion(1, juego.ejercito1); // Muestra los soldados del Ejército 1 en el orden en que fueron creados
            juego.mostrarSoldadosOrdenCreacion(2, juego.ejercito2); // Muestra los soldados del Ejército 2 en el orden en que fueron creados
            juego.mostrarRankingSoldados(1, juego.ejercito1);   // Ordena y muestra el ranking de soldados del Ejército 1
            juego.mostrarRankingSoldados(2, juego.ejercito2);   // Ordena y muestra el ranking de soldados del Ejército 2
            juego.mostrarEjercitoGanador(juego.ejercito1, juego.ejercito2); // Determina y muestra el ejército ganador
            System.out.println("\nDesea generar una nueva batalla?(s/n)");
            respuesta=scan.next();
        }
        System.out.println("\nGracias por jugar!");
    }    
}