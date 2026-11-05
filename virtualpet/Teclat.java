package Programacion.src.Proyecto.virtualpet;

import java.util.Scanner;

public class Teclat {

    private static Scanner sc = new Scanner(System.in);

    public static int llegirInt() {
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    public static double llegirDouble() {
        double valor = sc.nextDouble();
        sc.nextLine();
        return valor;
    }

    public static String llegirString() {
        return sc.nextLine();
    }
}
