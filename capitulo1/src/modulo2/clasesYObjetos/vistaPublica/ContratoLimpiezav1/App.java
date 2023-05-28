package modulo2.clasesYObjetos.vistaPublica.ContratoLimpiezav1;

public class App {
    public static void main(String[] args) {
//        final int YEAR = 2022;
//        ServicesContract servicesContract = new ServicesContract("USantaTecla", YEAR);

//        servicesContract.writeln();
//        double cost = servicesContract.getCost();
//        Console.getInstance().writeln("Coste anual del contrato: " + cost);
//
//        servicesContract.cancel(new Date(25, 12, YEAR));
//        servicesContract.writeln();
//        cost = servicesContract.getCost();
//        Console.getInstance().writeln("Coste anual del contrato: " + cost);
//
//        servicesContract.enlarge(new Date(24, 12, YEAR), 2.0);
//        servicesContract.writeln();
//        cost = servicesContract.getCost();
//        Console.getInstance().writeln("Coste anual del contrato: " + cost);
//
//        servicesContract.shift(new Date(26, 12, YEAR), 1.0);
//        servicesContract.writeln();
//        cost = servicesContract.getCost();
//        Console.getInstance().writeln("Coste anual del contrato: " + cost);
        Console.getInstance().writeln("BIENVENIDOS A LA GESTION DE CONTRATOS POR FECHAS");
        Menu menu = new Menu();
        int op;
        ServicesContract servicesContract = null;
        final int YEAR = Console.getInstance().readInt("INGRESE AÑO: ");
        do {
            double cost,interval;
            int dia,mes;
            menu.mostrar();
            op = menu.getOpcion();
            switch (op) {
                case 1:

                    String nom = Console.getInstance().readString("INGRESE NOMBRE DE LA EMPRESA: ");
                    servicesContract = new ServicesContract(nom,YEAR);
                    break;
                case 2:
                    cost = servicesContract.getCost();
                    servicesContract.writeln();
                    Console.getInstance().writeln("Coste anual del contrato: " + cost);
                    break;
                case 3 :
                    dia = Console.getInstance().readInt("INGRESA DIA: ");
                    mes = Console.getInstance().readInt("INGRESA MES: ");
                    servicesContract.cancel(new Date(dia,mes,YEAR));
                    cost = servicesContract.getCost();
                    servicesContract.writeln();
                    Console.getInstance().writeln("Coste anual del contrato: " + cost);
                    break;
                case 4 :
                    dia = Console.getInstance().readInt("INGRESA DIA: ");
                    mes = Console.getInstance().readInt("INGRESA MES: ");
                    interval = Console.getInstance().readDouble("INGRESA LA ESCALA");
                    servicesContract.shift(new Date(dia, mes, YEAR), interval);
                    servicesContract.writeln();
                    cost = servicesContract.getCost();
                    Console.getInstance().writeln("Coste anual del contrato: " + cost);
                break;
                case 5 :
                    dia = Console.getInstance().readInt("INGRESA DIA: ");
                    mes = Console.getInstance().readInt("INGRESA MES: ");
                    interval = Console.getInstance().readDouble("INGRESA LA ESCALA");
                    servicesContract.enlarge(new Date(dia,mes, YEAR), interval);
                    servicesContract.writeln();
                    cost = servicesContract.getCost();
                    Console.getInstance().writeln("Coste anual del contrato: " + cost);
                    // secuencia de sentencias.
                    break;
                case 6 :
                    break;
            }
        }while(op!=6);
    }
}
