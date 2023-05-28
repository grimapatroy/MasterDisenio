package modulo2.clasesYObjetos;

import modulo2.javaafondo.util.Fecha;

import java.util.Scanner;

public class TestFecha {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("INGRESE LA FECHA1 (DIA, MES y ANIO) : ");
        int dia = sc.nextInt();
        int mes = sc.nextInt();
        int anio = sc.nextInt();

        Fecha f1 = new Fecha(dia,mes,anio);
        System.out.println("INGRESE LA FECHA2 (DIA, MES y ANIO) : ");
         dia = sc.nextInt();
         mes = sc.nextInt();
         anio = sc.nextInt();
        Fecha f2 = new Fecha(dia,mes,anio);

        System.out.println("LA FECHA 1: "+f1.toString());
        System.out.println("LA FECHA 2: "+f2.toString());

//        if (f1.equals(f2)) {
//            System.out.println("LAS FECHAS SON IGUALES");
//        }else {
//            System.out.println("LAS FECHAS SON DIFERENTES");
//        }

        System.out.println(Fecha.isBisiesto(f2.getAnio()));
        System.out.println(Fecha.isBisiesto(f1.getAnio()));




        sc.close();
    }
}