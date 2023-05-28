package game3Rayas.topdow;

import java.util.Random;

public class Turno {

    private int valor;

    public Turno() {
        valor = new Random().nextInt(2);
    }

    public int toca() {
        return valor;
    }

    public int noToca() {
        return (valor + 1) % 2;
    }

    public void cambiar() {
        valor = this.noToca();
    }

//    para hacer unas prubas chiquitas != de junit y unitarias
    public static void main(String[] args) {
        Turno turno;
        for (int i = 0; i < 10; i++) {
            turno = new Turno();
            System.out.print("Toca: " + turno.toca() + "\n");
            System.out.print("No toca: " + turno.noToca() + "\n");
            turno.cambiar();
            System.out.print("Cambiado\n");
            System.out.print("Toca: " + turno.toca() + "\n");
            System.out.print("No toca: " + turno.noToca() + "\n");
            System.out.print("\n");
        }
    }



}
