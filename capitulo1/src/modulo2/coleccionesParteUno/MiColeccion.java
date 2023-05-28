package modulo2.coleccionesParteUno;

public class MiColeccion {
    private static int CAP_INICIAL = 10;
    private  Object datos[]=null;
    private int len = 0;


    public MiColeccion(){
        this.datos = new Object[CAP_INICIAL];
    }

    public Object getObtain(int pos){
        return this.datos[pos];
    }

    public int getAmout(){
        return this.len;
    }


    private void verifyYEnlarge(){
        if (this.len == this.datos.length) {
            Object nuevo[] = new Object[CAP_INICIAL*2];
            for (int i = 0; i < datos.length; i++) {
                nuevo[i]=datos[i];
            }
            datos = nuevo;
            nuevo = null;
        }
    }


    private void insert(Object obj, int pos){
        this.verifyYEnlarge();
        if (this.len!=0){
            for (int i = this.len-1; i>=pos ; i--) {
                datos[i+1]=datos[i];
            }
            datos[pos]= obj;
        }else {
//            this.datos.agregar();
        }
    }




}
