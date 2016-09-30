package ru.bstu.iitus.vt41.Terekhova;

import java.util.Scanner;

//Метательное копье
public class Javelin extends SportsEquipment {
    public static final SportType JAVELIN_THROWING = SportType.JAVELIN_THROWING;
    double angleTip;    //угол острия
    double length;    //длина

    @Override
    public void init(Scanner scan) {
        System.out.println("Введите массу инвентаря: ");
        if (scan.hasNextDouble()) {
            weight = scan.nextDouble();
        } else {
            //ругнуться
        }

        System.out.println("Введите производителя инвентаря: ");
        manufacturer = scan.nextLine();

        System.out.println("Введите угол острия: ");
        if (scan.hasNextDouble()) {
            angleTip = scan.nextDouble();
        } else {
            //ругнуться
        }

        System.out.println("Введите длину копья: ");
        if (scan.hasNextDouble()) {
            length = scan.nextDouble();
        } else {
            //ругнуться
        }

    }

    @Override
    public SportType getSportType() {

        return JAVELIN_THROWING;
    }

    @Override
    public String toString() {
        return "Инвентарь - копье, вид спорта - метание копья, масса - " + this.weight
                + ", производитель - " + this.manufacturer
                + ", угол острия - " + angleTip
                + ", длина - " + length + '\n';
    }
}
