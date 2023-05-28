package modulo2.gestorVuelos;

import java.util.Scanner;

public class GestorVuelos {

    private Vuelo vuelo;

    public GestorVuelos(){
        this.vuelo = new Vuelo("0001","12122023","12:00");
    }

    public void simular(){
      System.out.println("*************BIENVENIDO AL SISTEMA DE VUELOS****************");
      Menu menu = new Menu();
      Scanner scanner = new Scanner(System.in);
      int opcion;
      int numeroAsiento;
      char letra;
      do {
          menu.mostrar();
          opcion = menu.getOpcion();
          switch (opcion){
              case  1:
                  do {
                      this.vuelo.asientosDisponibles();
                      System.out.println("INGRESE NUMERO DE ASIENTO: ");
                      numeroAsiento = scanner.nextInt();
                      System.out.println("INGRESE LETRA FILA DE ASIENTO: ");
                      letra = scanner.next().charAt(0);
                  }while(!this.vuelo.venderAsiento(numeroAsiento,letra));
                  break;
              case  2:
                  do {
                      this.vuelo.asientosDisponibles();
                      System.out.println("INGRESE NUMERO DE ASIENTO: ");
                      numeroAsiento = scanner.nextInt();
                      System.out.println("INGRESE LETRA FILA DE ASIENTO: ");
                      letra = scanner.next().charAt(0);
                  }while(!this.vuelo.reservarAsiento(numeroAsiento,letra));
                  break;
              case  3:
                  do {
                      this.vuelo.asientosDisponibles();
                      System.out.println("INGRESE NUMERO DE ASIENTO A CANCELAR: ");
                      numeroAsiento = scanner.nextInt();
                      System.out.println("INGRESE LETRA FILA DE ASIENTO: ");
                      letra = scanner.next().charAt(0);
                  }while(!this.vuelo.cancelarAsiento(numeroAsiento,letra));
                  break;
              case  4:
                  break;
          }
      }while(opcion!=4);
    }


    public static void main(String[] args) {
        new GestorVuelos().simular();
    }

}
