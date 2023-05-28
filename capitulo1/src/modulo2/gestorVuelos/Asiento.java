package modulo2.gestorVuelos;

public class Asiento {
    private int nroAsiento;
    private char fila;
    private String estado;

    public  Asiento(int i ){
            this.nroAsiento = i+1;
            this.fila = '_';
            this.estado = "libre";
    }

    public void setEstado(String valor) {
            this.estado = valor;
    }

    public void setFila(char v) {
            this.fila = v;
    }

    public boolean reservarAsiento() {
        return this.estado.equals("libre") && !this.estado.equals("vendido");
    }

    public boolean venderAsiento() {
        return this.estado.equals("libre") && !this.estado.equals("reservado");
    }

    public boolean cancelarAsiento() {
        return this.estado.equals("vendido") || this.estado.equals("reservado");
    }

    @Override
    public String toString(){
        return this.nroAsiento + " " + this.fila + " " + this.estado;
    }
}
