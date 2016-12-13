package ru.bstu.iitus.vt41.Terekhova.reader;


import java.util.Scanner;

public class ReadFromConsole {

    private final static Scanner SCANNER = new Scanner(System.in);

    public static String readString(String message){

        System.out.println(message);
        return SCANNER.nextLine();
    }

    public static Integer readInteger(String message){

        System.out.println(message);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static Double readDouble(String message){

        System.out.println(message);
        return Double.parseDouble(SCANNER.nextLine());
    }

}