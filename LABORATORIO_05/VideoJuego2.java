/*
  Clase VideoJuego2
*/
package ejercicio01lab05;


public class VideoJuego2{
    private Soldado[][] tablero;  // Tablero bidimensional de soldados
    private Soldado[] soldados;    // Arreglo de soldados
    private int cantidadSoldados;  // Cantidad de soldados
    // Constructor
    public VideoJuego2(){
        this.tablero=new Soldado[10][10];
        this.cantidadSoldados=(int)(Math.random()*10+1); // Entre 1 y 10 soldados
        this.soldados=new Soldado[cantidadSoldados];
        inicializarSoldados();
    }
    // Método para inicializar los soldados en el tablero
    private void inicializarSoldados(){
        for(int i=0;i<cantidadSoldados;i++){
            String nombre="Soldado"+i;
            int nivelVida=(int)(Math.random()*5+1);  // Nivel de vida entre 1 y 5
            int fila, columna;
            // Generar una posición única para el soldado
            do{
                fila=(int)(Math.random()*10);
                columna=(int)(Math.random()*10);
            }while(tablero[fila][columna]!=null);  // Asegurarse de que el espacio esté ocupado

            Soldado soldado=new Soldado(nombre, nivelVida, fila, columna);
            tablero[fila][columna]=soldado;  // Asignar el soldado al tablero
            soldados[i]=soldado;  // Guardar soldado en el arreglo
        }
    }
    // Método para mostrar el tablero
    public void mostrarTablero(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(tablero[i][j]==null){
                    System.out.print("| _________ ");  // Posición vacía
                }else{
                    System.out.print("|  "+tablero[i][j].getNombre()+" ");  // Posición con un soldado
                }
            }
            System.out.println("|");
        }
    }
    // Método para mostrar el soldado con mayor nivel de vida
    public void mostrarSoldadoMayorVida(){
        Soldado mayorVida=soldados[0];
        for(Soldado soldado : soldados){
            if(soldado.getNivelVida()>mayorVida.getNivelVida()){
                mayorVida=soldado;
            }
        }
        System.out.println("Soldado con mayor nivel de vida: "+mayorVida);
    }   
}
