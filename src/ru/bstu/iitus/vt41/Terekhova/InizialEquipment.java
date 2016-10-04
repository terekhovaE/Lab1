package ru.bstu.iitus.vt41.Terekhova;

import java.util.Scanner;

public class InizialEquipment {

    static Scanner scan = new Scanner(System.in);
    static SportsEquipment[] arrayEq;

    public static int Inizial() {

        System.out.println("Введите название инвентаря: " + '\n' + "1 - волейбольный мяч" + '\n' + "2 - теннисный мяч" + '\n' + "3 - ракетка" + '\n' +
                "4 - метательное копье" + '\n' + "5 - тренажерный инвентарь");
        int a = Integer.parseInt(scan.nextLine());
        return a;
    }

    public static double TypeVerification(Scanner scan) throws MyException {
        if (!scan.hasNextDouble()) {
            throw new MyException("Введите числовое значение!");
        } else {
            return Double.parseDouble( scan.nextLine());
        }
    }

    public static void CreateArray() throws InstantiationException, IllegalAccessException {

        System.out.println("Введите количество инвентаря: ");
        int quantity = Integer.parseInt(scan.nextLine());
        arrayEq = new SportsEquipment[quantity];
        for (int i = 0; i < quantity;) {
            try {
                arrayEq[i] = buildEquipments(Inizial());
                arrayEq[i].init(scan);
                i++;
            } catch (MyException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static SportsEquipment buildEquipments(int typeEquipment) throws IllegalAccessException, InstantiationException {
        SportType type = SportType.valueOf(typeEquipment);      //todo throw sels generated Exception
        return type.getEquipmentClass().newInstance();
    }

    public static void TennisEquipment() {

        for (SportsEquipment anArrayEq : arrayEq)
            if (SportType.TENNIS == anArrayEq.getSportType()) {
                System.out.println(anArrayEq.toString());
            }

    }
}
