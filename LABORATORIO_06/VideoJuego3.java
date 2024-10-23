/*
  Clase VideoJuego3
*/
package laboratorio06_fp2;

import java.util.*;
public class VideoJuego3 {
    private ArrayList<ArrayList<Soldado>> tablero;  // Tablero bidimensional de soldados
    public ArrayList<Soldado> ejercito1;   // Arreglo de soldados
    public ArrayList<Soldado> ejercito2;    // Arreglo de soldados
    private int filas;
    private int columnas;  // Cantidad de soldados
    // Constructor
    public VideoJuego3(int filas, int columnas){
        this.tablero=new ArrayList<ArrayList<Soldado>>();
        this.ejercito1=new ArrayList<Soldado>();
        this.ejercito2=new ArrayList<Soldado>();
        this.filas=filas;
        this.columnas=columnas;
        inicializarTablero();
        inicializarEjercito(1, ejercito1);
        inicializarEjercito(2, ejercito2);
    }
    private void inicializarTablero(){
        for(int i=0;i<filas;i++){
            tablero.add(new ArrayList<>());
            for(int j=0;j<columnas;j++){
                tablero.get(i).add(null); // Inicializar casillas vacías
            }
        }
    }
    // Método para inicializar los soldados en el tablero
    private void inicializarEjercito(int numEjercito, ArrayList<Soldado> ejercito){
        int cantidadSoldados=(int)(Math.random()*10+1);
        for(int i=0;i<cantidadSoldados;i++){
            String nombre="Soldado"+i+"X"+numEjercito;
            int nivelVida=(int)(Math.random()*5+1);  // Nivel de vida entre 1 y 5
            int fila, columna;
            // Generar una posición única para el soldado
            do{
                fila=(int)(Math.random()*10);
                columna=(int)(Math.random()*10);
            }while(tablero.get(fila).get(columna)!=null);  // Asegurarse de que el espacio esté ocupado

            Soldado soldado=new Soldado(nombre, nivelVida, fila, columna);
            tablero.get(fila).set(columna, soldado);  // Asignar el soldado al tablero
            ejercito.add(soldado);  // Guardar soldado en el arreglo
        }
    }
    // Método para mostrar el tablero
    public void mostrarTablero(){
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                Soldado soldado=tablero.get(i).get(j);
                if(soldado==null){
                    System.out.print("| _________ ");  // Posición vacía
                }else{
                    System.out.print("|"+soldado.getNombre()+" ");  // Posición con un soldado
                }
            }
            System.out.println("|");
        }
    }
    // Método para mostrar el soldado con mayor nivel de vida
    public void mostrarSoldadosMayorVida(int numEjercito, ArrayList<Soldado> ejercito){
        Soldado mayorVida=ejercito.get(0);
        for(Soldado soldado : ejercito){
            if(soldado.getNivelVida()>mayorVida.getNivelVida()){
                mayorVida=soldado;
            }
        }
        System.out.println("Soldado con mayor nivel de vida del ejercito "+numEjercito+" : "+mayorVida);
    }   
    // Método para calcular el promedio de nivel de vida
    public void mostrarPromedioNivelVida(int numEjercito, ArrayList<Soldado> ejercito){
        int sumaVida=0;
        for(Soldado soldado : ejercito){
            sumaVida+=soldado.getNivelVida();
        }
        double promedio=(double)sumaVida/ejercito.size();
        System.out.println("Promedio del nivel de vida del ejercito "+numEjercito+" : "+promedio);
    }
    // Método para mostrar todos los soldados en el orden en que fueron creados
    public void mostrarSoldadosOrdenCreacion(int numEjercito, ArrayList<Soldado> ejercito){
        System.out.println("Soldados del ejercito "+numEjercito+" en el orden de creacion:");
        for(Soldado soldado : ejercito){
            System.out.println(soldado);
        }
    }
    
}
