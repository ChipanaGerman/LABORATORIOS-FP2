/*
  Clase VideoJuego3
*/
package laboratorio06_fp2;

import java.util.*;
public class VideoJuego3 {
    private ArrayList<ArrayList<Soldado>> tablero;  // Tablero bidimensional de soldados
    public ArrayList<Soldado> ejercito1;   // Lista de soldados del Ejército 1
    public ArrayList<Soldado> ejercito2;   // Lista de soldados del Ejército 2
    private int filas;
    private int columnas;  
    // Constructor: Inicializa el tablero y los ejércitos
    public VideoJuego3(int filas, int columnas){
        this.tablero=new ArrayList<ArrayList<Soldado>>();   // Inicializa el tablero bidimensional
        this.ejercito1=new ArrayList<Soldado>();    // Inicializa la lista del Ejército 1
        this.ejercito2=new ArrayList<Soldado>();    // Inicializa la lista del Ejército 2
        this.filas=filas;
        this.columnas=columnas;
        inicializarTablero();   // Llena el tablero con espacios vacíos
        inicializarEjercito(1, ejercito1);  // Inicializa los soldados para el Ejército 1
        inicializarEjercito(2, ejercito2);  // Inicializa los soldados para el Ejército 2
    }
    // Método para inicializar el tablero con filas y columnas vacías
    private void inicializarTablero(){
        for(int i=0;i<filas;i++){
            tablero.add(new ArrayList<>()); // Agrega una nueva fila
            for(int j=0;j<columnas;j++){
                tablero.get(i).add(null);   // Llena cada celda con null para indicar que está vacía
            }
        }
    }
    // Método para inicializar los soldados en el tablero y añadirlos a un ejército
    private void inicializarEjercito(int numEjercito, ArrayList<Soldado> ejercito){
        int cantidadSoldados=(int)(Math.random()*10+1); // Genera una cantidad aleatoria de soldados entre 1 y 10
        for(int i=0;i<cantidadSoldados;i++){
            String nombre="Soldado"+i+"X"+numEjercito;  // Genera un nombre único para cada soldado
            int nivelVida=(int)(Math.random()*5+1);  // Asigna un nivel de vida aleatorio entre 1 y 5
            int fila, columna;
            // Busca una posición vacía en el tablero para colocar al soldado
            do{
                fila=(int)(Math.random()*10);   // Fila aleatoria
                columna=(int)(Math.random()*10);    // Columna aleatoria
            }while(tablero.get(fila).get(columna)!=null);   // Repite mientras la posición no esté vacía  

            Soldado soldado=new Soldado(nombre, nivelVida, fila, columna);  // Crea el soldado con los atributos generados
            tablero.get(fila).set(columna, soldado);    // Coloca el soldado en el tablero  
            ejercito.add(soldado);  // Añade el soldado al ejército correspondiente  
        }
    }
    // Método para mostrar el tablero con los soldados posicionados
    public void mostrarTablero(){
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                Soldado soldado=tablero.get(i).get(j);  // Obtiene el soldado en la posición (i,j)
                if(soldado==null){
                    System.out.print("| _________ ");   // Imprime una casilla vacía 
                }else{
                    System.out.print("|"+soldado.getNombre()+" ");  // Imprime el nombre del soldado en la casilla
                }
            }
            System.out.println("|");    // Nueva línea después de cada fila
        }
        System.out.println();
    }
    // Método para mostrar el soldado con mayor nivel de vida en un ejército
    public void mostrarSoldadosMayorVida(int numEjercito, ArrayList<Soldado> ejercito){
        Soldado mayorVida=ejercito.get(0);  // Inicializa con el primer soldado
        for(Soldado soldado : ejercito){
            if(soldado.getNivelVida()>mayorVida.getNivelVida()){
                mayorVida=soldado;  // Actualiza si encuentra un soldado con mayor nivel de vida
            }
        }
        System.out.println("Soldado con mayor nivel de vida del ejercito "+numEjercito+" : "+mayorVida);
        System.out.println();
    }   
    // Método para calcular y mostrar el promedio del nivel de vida de un ejército
    public void mostrarPromedioNivelVida(int numEjercito, ArrayList<Soldado> ejercito){
        int sumaVida=0;
        for(Soldado soldado : ejercito){
            sumaVida+=soldado.getNivelVida();   // Suma el nivel de vida de cada soldado
        }
        double promedio=(double)sumaVida/ejercito.size();   // Calcula el promedio
        System.out.println("Promedio del nivel de vida del ejercito "+numEjercito+" : "+promedio);
        System.out.println();
    }
    // Método para mostrar los soldados en el orden en que fueron creados
    public void mostrarSoldadosOrdenCreacion(int numEjercito, ArrayList<Soldado> ejercito){
        System.out.println("Soldados del ejercito "+numEjercito+" en el orden de creacion:");
        for(Soldado soldado : ejercito){
            System.out.println(soldado);    // Imprime cada soldado en el orden de creación
        }
        System.out.println();
    }
    // Método para mostrar el ranking de soldados basado en su nivel de vida, usando burbuja y selección
    public void mostrarRankingSoldados(int numEjercito, ArrayList<Soldado> ejercito){
        // Ordenamiento por burbuja
        ArrayList<Soldado> ejercitoBurbuja=(ArrayList<Soldado>) ejercito.clone();   // Clona el ejército original
        burbujaOrdenar(ejercitoBurbuja);    // Ordena usando el algoritmo de burbuja
        System.out.println("Ranking de soldados ejercito "+numEjercito+" (Burbuja): ");
        for(Soldado soldado : ejercitoBurbuja){
            System.out.println(soldado);    // Imprime los soldados ordenados    
        }
        // Ordenamiento por selección
        ArrayList<Soldado> ejercitoSeleccion=(ArrayList<Soldado>) ejercito.clone(); // Clona el ejército original
        seleccionOrdenar(ejercitoSeleccion);    // Ordena usando el algoritmo de selección
        System.out.println("Ranking de soldados ejercito "+numEjercito+" (Seleccion): ");
        for(Soldado soldado : ejercitoSeleccion){
            System.out.println(soldado);    // Imprime los soldados ordenados
        }
        System.out.println();
    }
    // Método de ordenamiento por burbuja para ordenar soldados por nivel de vida (descendente)
    private void burbujaOrdenar(ArrayList<Soldado> soldados){
        for(int i=0;i<soldados.size()-1;i++){
            for(int j=0;j<soldados.size()-1-i;j++){
                if(soldados.get(j).getNivelVida()<soldados.get(j+1).getNivelVida()){
                    // Intercambia los soldados si el nivel de vida del siguiente es mayor
                    Soldado temp=soldados.get(j);
                    soldados.set(j, soldados.get(j+1)); 
                    soldados.set(j+1, temp);
                }
            }
        }
    }
    // Método de ordenamiento por selección para ordenar soldados por nivel de vida (descendente)
    private void seleccionOrdenar(ArrayList<Soldado> soldados){
        for(int i=0;i<soldados.size()-1;i++){
            int maxIndex=i; // Asume que el soldado en la posición i tiene el mayor nivel de vida
            for(int j=i+1;j<soldados.size();j++){
                if(soldados.get(j).getNivelVida()>soldados.get(maxIndex).getNivelVida()){
                    maxIndex=j; // Actualiza la posición del soldado con mayor nivel de vida
                }
            }
            // Intercambia el soldado en i con el de mayor nivel de vida encontrado
            Soldado temp=soldados.get(i);
            soldados.set(i, soldados.get(maxIndex));  
            soldados.set(maxIndex, temp); 
        }
    }  
    // Método que determina y muestra el ejército ganador basado en el número de soldados
    public void mostrarEjercitoGanador(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2){
        if(ejercito1.size()>=ejercito2.size()){
            if(ejercito1.size()==ejercito2.size())
                System.out.println("Hubo un EMPATE de ejercitos, ambos con "+ejercito1.size()+" soldados...");
            else
                System.out.println("Gano el EJERCITO 1 con "+ejercito1.size()+" soldados!");
        }
        else
            System.out.println("Gano el EJERCITO 2 con "+ejercito2.size()+" soldados!");
    }
}
