package modulo2.gestorVuelos;

public class Vuelo {
    private String codigo;
    private String fecha;
    private String hora;
    private Asiento[] asientos;


    public Vuelo(String codigo,String fecha,String hora){
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.asientos = new Asiento[20];
        for (int i = 0; i < this.asientos.length; i++) {
            this.asientos[i] = new Asiento(i);
        }
    }

    public void asientosDisponibles() {
        for (int i = 0; i < this.asientos.length; i++) {
            System.out.println(asientos[i].toString());
        }
//        return  this.asientos;
    }

    public boolean venderAsiento(int asiento, char letra){
//        assert this.asientos.length!=(asiento-1);
        int i;
        for (i = this.asientos.length; i!=(asiento-1); i--);
        if (!this.asientos[i].reservarAsiento() && !this.asientos[i].venderAsiento()){
            this.asientos[i].setEstado("vendido");
            this.asientos[i].setFila('V');
            return true;
        }
        return false;
    }

    public boolean reservarAsiento(int numeroAsiento, char letra) {
        int i;
        for (i = this.asientos.length; i!=(numeroAsiento-1); i--);
        if (!this.asientos[i].reservarAsiento() && !this.asientos[i].venderAsiento()){
            this.asientos[i].setEstado("reservado");
            this.asientos[i].setFila('R');
            return true;
        }
        return false;
    }

    public boolean cancelarAsiento(int numeroAsiento, char letra) {
        int i;
        for (i = this.asientos.length; i != (numeroAsiento - 1); i--) ;
        if (this.asientos[i].reservarAsiento() && this.asientos[i].venderAsiento() && !this.asientos[i].cancelarAsiento()) {
            this.asientos[i].setEstado("cancelado");
            this.asientos[i].setFila('C');
            return true;
        }
        return false;
    }

//    @Override
//    public String toString(){
//        return this.asientos[].
//    }
}
