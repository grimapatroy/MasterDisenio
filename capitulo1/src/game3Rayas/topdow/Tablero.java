package game3Rayas.topdow;

public class Tablero {

    private Coordenada[][] fichas;
    private static final int DIMENSION = 3;
    private static final char VACIA = '_';


    public Tablero() {
        fichas = new Coordenada[2][3];
    }
    public void mostrar() {
        GestorIO gestorIO = new GestorIO();
        for (int i = 1; i <= DIMENSION; i++) {
            for (int j = 1; j <= DIMENSION; j++) {
                gestorIO.out(this.getColor(new Coordenada(i, j)) + " ");
            }
            gestorIO.out("\n");
        }
        gestorIO.out("\n");
    }
    private char getColor(Coordenada coordenada) {
        if (this.ocupada(coordenada, 'o')) {
            return 'o';
        }
        if (this.ocupada(coordenada, 'x')) {
            return 'x';
        }
        return VACIA;
    }
    public boolean hayTresEnRaya() {
        return this.hayTresEnRaya('o') || this.hayTresEnRaya('x');
    }
    private boolean hayTresEnRaya(char jugador) {
        if (!this.estaCompleto(jugador)) {
            return false;
        }
        int fila = this.getFila(jugador);
        int direccion = fichas[fila][0].direccion(fichas[fila][1]);
        if (direccion == -1) {
            return false;
        }
        return direccion == fichas[fila][1].direccion(fichas[fila][2]);
    }
    public boolean estaCompleto(Jugador jugador) {
        assert jugador != null;
        return this.estaCompleto(jugador.color());
    }
    private boolean estaCompleto(char jugador) {
        int fila = this.getFila(jugador);
        int contador = 0;
        for (int i = 0; i < fichas[fila].length; i++) {
            if (fichas[fila][i] != null) {
                contador++;
            }
        }
        return contador == DIMENSION;
    }
    public boolean ocupada(Coordenada coordenada, char color) {
        assert coordenada != null;
        int fila = this.getFila(color);
        for (int i = 0; i < fichas[fila].length; i++) {
            if (fichas[fila][i] != null && fichas[fila][i].igual(coordenada)) {
                return true;
            }
        }
        return false;
    }
    public boolean ocupada(Coordenada coordenada) {
        return this.ocupada(coordenada, 'o') || this.ocupada(coordenada, 'x');
    }
    public void ponerFicha(Coordenada coordenada, char color) {
        assert coordenada != null;
        int fila = this.getFila(color);
        int i = 0;
        while (fichas[fila][i] != null) {
            i++;
        }
        fichas[fila][i] = coordenada;
    }
    private int getFila(char color) {
        if (color == 'o') {
            return 0;
        }
        return 1;
    }
    public void retirarFicha(Coordenada coordenada) {
        assert coordenada != null;
        assert this.ocupada(coordenada);
        for (int i = 0; i < fichas.length; i++) {
            for (int j = 0; j < fichas[i].length; j++) {
                if (fichas[i][j] != null && fichas[i][j].igual(coordenada)) {
                    fichas[i][j] = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        GestorIO gestorIO = new GestorIO();
        Coordenada[][] coleccionesCoordenadas = new Coordenada[][] {
                {new Coordenada(1, 1), new Coordenada(2, 1), new Coordenada(3, 1)},
                {new Coordenada(1, 2), new Coordenada(2, 2), new Coordenada(3, 2)},
                {new Coordenada(1, 3), new Coordenada(2, 3), new Coordenada(3, 3)},
                {new Coordenada(1, 1), new Coordenada(1, 2), new Coordenada(1, 3)},
                {new Coordenada(2, 1), new Coordenada(2, 2), new Coordenada(2, 3)},
                {new Coordenada(3, 1), new Coordenada(3, 2), new Coordenada(3, 3)},
                {new Coordenada(1, 1), new Coordenada(2, 2), new Coordenada(3, 3)},
                {new Coordenada(1, 3), new Coordenada(2, 2), new Coordenada(3, 1)},
                {new Coordenada(1, 1), new Coordenada(2, 2), new Coordenada(3, 1)},
                {new Coordenada(1, 2), new Coordenada(2, 1), new Coordenada(3, 3)},
                {new Coordenada(2, 3), new Coordenada(1, 2), new Coordenada(3, 2)}
        };
        for (Coordenada[] coleccionCoordenadas : coleccionesCoordenadas) {
            gestorIO.out("----------------------------------\n");
            Tablero tablero = new Tablero();
            tablero.mostrar();
            for (Coordenada coordenada : coleccionCoordenadas) {
                tablero.ponerFicha(coordenada, 'x');
                tablero.mostrar();
                gestorIO.out("Completo: " + tablero.estaCompleto(new Jugador('x')) + "\n");
                gestorIO.out("Ocupada la coordenada (2,2): " + tablero.ocupada(new Coordenada(2, 2)) + "\n");
                gestorIO.out("Ocupada la coordenada (2,2) por una x: " + tablero.ocupada(new Coordenada(2, 2), 'x') + "\n");
                gestorIO.out("Ocupada la coordenada (2,2) por un o: " + tablero.ocupada(new Coordenada(2, 2), 'o') + "\n");
            }
            gestorIO.out("Tres en raya: " + tablero.hayTresEnRaya() + "\n");
            for (Coordenada coordenada : coleccionCoordenadas) {
                tablero.retirarFicha(coordenada);
                tablero.mostrar();
                gestorIO.out("Completo: " + tablero.estaCompleto(new Jugador('x')) + "\n");
                gestorIO.out("Ocupada la coordenada (2,2): " + tablero.ocupada(new Coordenada(2, 2)) + "\n");
                gestorIO.out("Ocupada la coordenada (2,2) por una x: " + tablero.ocupada(new Coordenada(2, 2), 'x') + "\n");
                gestorIO.out("Ocupada la coordenada (2,2) por un o: " + tablero.ocupada(new Coordenada(2, 2), 'o') + "\n");
            }
        }
    }
}
