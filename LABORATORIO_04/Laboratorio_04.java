/*
  Autor: Chipana Jeronimo German Arturo
  Propostio: Laboratorio 04
*/
package laboratorio_04;

import java.util.*;
public class Laboratorio_04 {

    public static void main(String[] args) {
        Nave [] misNaves = new Nave[8];
        Scanner sc = new Scanner(System.in);
        String nomb, col;
        int fil, punt;
        boolean est;

        for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i+1));
            System.out.print("Nombre: ");
            nomb = sc.next();
            System.out.println("Fila ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.next();
            System.out.print("Estado: ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();

            misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves

            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
        }

        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        mostrarPorNombre(misNaves);
        mostrarPorPuntos(misNaves);
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
        
        //leer un nombre
        System.out.println("Ingrese nombre de la nave a buscar: ");
        String nombre=sc.next();
        //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
        int pos=busquedaLinealNombre(misNaves,nombre);
        for(int i=0;i<misNaves.length;i++){
            if(i==pos){
                mostrarNave
            }
        }
        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves); 

        //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
        pos=busquedaBinariaNombre(misNaves,nombre);
        
        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);
    }
    //Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota){
       //REUTILIZAR
       for(Nave nave : flota){
            System.out.println(nave.toString());
        }
    }

    //Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota){
        //REUTILIZAR
        Scanner scan=new Scanner(System.in);
        System.out.println("Ingrese nombre de la nave a buscar: ");
        String naveBuscar=scan.next();
        System.out.println("Naves encontradas con el nombre "+naveBuscar+" : ");
        for(Nave nave : flota){
            if(nave.getNombre().equals(naveBuscar)){
                System.out.println(nave.toString());
            }
        }
    }

    //Método para mostrar todas las naves con un número de puntos inferior o igual
    //al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave[] flota){
        //REUTILIZAR
        Scanner scan=new Scanner(System.in);
        System.out.println("Ingrese el numero max de puntos: ");
        int maxPuntos=scan.nextInt();
        System.out.println("Naves con puntos inferiores a "+maxPuntos);
        for(Nave nave : flota){
            if(nave.getPuntos()<=maxPuntos){
                System.out.println(nave.toString());
            }
        }      
    }

    //Método que devuelve la Nave con mayor número de Puntos
    public static Nave mostrarMayorPuntos(Nave[] flota){
        //REUTILIZAR
        Nave naveMaxPuntos=flota[0];
        for(Nave nave : flota){
            if(nave.getPuntos()>naveMaxPuntos.getPuntos()){
                naveMaxPuntos=nave;
            }
        }   
        return naveMaxPuntos; 
    }
    //Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaLinealNombre(Nave[] flota, String s){
        for(int i=0;i<flota.length;i++){
            if(flota[i].getNombre().equals(s)){
                return i;
            }
        }
        return -1;
    }
    //Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosBurbuja(Nave[] flota){
        for(int i=1;i<flota.length;i++){
            for(int j=0;j<flota.length-i;j++){
                if(flota[j].getPuntos()>flota[j+1].getPuntos()){
                    intercambiar(flota,j,j+1);
                }
            }
        }
    }
    //Método que ordena por nombre de A a Z
    public static void ordenarPorNombreBurbuja(Nave[] flota){
        for(int i=1;i<flota.length;i++){
            for(int j=0;j<flota.length-i;j++){
                // Comparar las letras iniciales de los nombres
                char letraInicial1=flota[j].getNombre().charAt(0);
                char letraInicial2=flota[j+1].getNombre().charAt(0);
                if (letraInicial1>letraInicial2) {
                    // Intercambiar las naves si están en el orden incorrecto
                    intercambiar(flota,j,j+1);
                }
            }
        }     
    }
    //Método para buscar la primera nave con un nombre que se pidió por teclado
    public static int busquedaBinariaNombre(Nave[] flota, String s){
        int baja=0;
        int alta=flota.length-1;
        while(baja<=alta) {
            int media=(alta+baja)/2;
            // Comparar usando compareTo
            int comparacion = flota[media].getNombre().compareTo(s);
            if (comparacion==0) {
                return media; // Se encontró la nave
            } else if (comparacion>0) {
                alta=media-1; // Buscar en la mitad inferior
            } else {
                baja=media+1; // Buscar en la mitad superior
            }
        }
        return -1; // No se encontró la nave
    }
    //Método que ordena por número de puntos de menor a mayor
    public static void ordenarPorPuntosSeleccion(Nave[] flota){
        for(int i=0;i<flota.length;i++){
            int indiceMinimo=i;
            for(int j=i+1;j<flota.length;j++){
                if(flota[j].getPuntos()<flota[indiceMinimo].getPuntos()){
                    indiceMinimo=j;
                }
                intercambiar(flota,j,i);                    
            }
        }
    }
    //Método que ordena por nombre de A a Z
    public static void ordenarPorNombreSeleccion(Nave[] flota){
        for(int i=0;i<flota.length;i++) {
            int indiceMinimo=i;
            for(int j=i+1;j<flota.length;j++) {
                char letraInicial1 = flota[j].getNombre().charAt(0);
                char letraInicial2 = flota[indiceMinimo].getNombre().charAt(0);
                if(letraInicial1<letraInicial2) {
                    indiceMinimo = j; // Actualiza el índice mínimo
                }
            }
            // Intercambiar el elemento en la posición i con el mínimo encontrado
            if(indiceMinimo!=i) {
                intercambiar(flota,i,indiceMinimo);
            }
        }
    }
    //Método que muestra las naves ordenadas por número de puntos de mayor a menor
    public static void ordenarPorPuntosInsercion(Nave[] flota){
        for(int i=1;i<flota.length;i++){
            Nave clave=flota[i];
            int j=i-1;
            while(j>=0 && flota[j].getPuntos()<clave.getPuntos()){
                flota[j+1]=flota[j];
                j=j-1;
            }
            flota[j+1]=clave;
        }
    }
    //Método que muestra las naves ordenadas por nombre de Z a A
    public static void ordenarPorNombreInsercion(Nave[] flota){
        for(int i=1;i<flota.length;i++) {
            Nave clave=flota[i]; // Guardamos el objeto Nave
            int j=i-1;
            // Mover las naves que tienen un nombre menor que clave (para ordenar de Z a A)
            while (j>=0 && flota[j].getNombre().compareTo(clave.getNombre())<0) {
                flota[j+1]=flota[j];
                j=j-1;
            }
            // Colocar la clave en su posición correcta
            flota[j+1]=clave;
        }
    }
    public static void intercambiar(Nave[] flota,int i, int j){
        Nave temp;                  
        temp=flota[i];
        flota[i]=flota[j];
        flota[j]=temp;
    }   
}
