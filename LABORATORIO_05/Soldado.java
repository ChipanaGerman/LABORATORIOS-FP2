/*
  Clase Soldado
*/
package ejercicio01lab05;


public class Soldado{
    private String nombre;
    private int nivelVida;
    private int fila;
    private int columna;    
    //Constructor
    public Soldado(String nombre, int nivelVida, int fila, int columna){
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.fila = fila;
        this.columna = columna;
    }   
    // Metodos accesores
    public String getNombre(){
        return nombre;
    }
    public int getNivelVida(){
        return nivelVida;
    }
    public int getFila(){
        return fila;
    }
    public int getColumna(){
        return columna;
    }
    
    public String toString(){
        return "Soldado: "+nombre+", Vida: "+nivelVida+", Posicion: ("+fila+", "+columna+")";
    }   
}



