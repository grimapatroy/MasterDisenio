package modulo2.clasesYObjetos.vistaPublica.ContratoLimpiezav1;

public class Coordinate {
    private int x;
    private int y;


    public Coordinate(int valorx,int valory){
        this.x=valorx;
        this.y=valory;
    }

    public Coordinate(){
        this(0,0);
    }

   public int getX(){
        return this.x;
   }

   public int getY(){
        return this.y;
   }

}
