package modulo2.clasesYObjetos.vistaPublica.ContratoLimpiezav1;

public class Menu {
    private static final String[] TITULOS = new String[]{
            "\n1. INGRESAR EL NOMBRE DE LA EMPRESA Y AÑO",
            "\n2. MOSTRAR COSTO ANUAL",
            "\n3. CANCELAR UNA FECHA DENTRO DEL CONTRATO",
            "\n4. CAMBIAR EL RANGO DE INTERVALO DE HORA DE UNA FECHA",
            "\n5. ALARGAR EL RANGO DE INTERVALO DE HORA DE UNA FECHA",
    };
    private static final Interval OPCIONES = new Interval(1,5);


    public void mostrar(){
        for (String titulo:TITULOS) {
            Console.getInstance().writeln(titulo);
            }
    }

    public int getOpcion(){
        int op;
        boolean error;
        do {
            op=Console.getInstance().readInt("INGRESE OPCION DEL [1-5]");
            error = !OPCIONES.includes(op);
            if (error) {
                Console.getInstance().writeln("Error!!!!, la opcion debe ser del 1 al 5");
            }
        }while (error);
        return op;
    }

}
