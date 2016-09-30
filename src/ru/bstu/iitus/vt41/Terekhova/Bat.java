package ru.bstu.iitus.vt41.Terekhova;

import java.util.Scanner;

//ракетка
public class Bat extends SportsEquipment {
    public static final SportType TENNIS = SportType.TENNIS;
    double sizeRim; //размер обода
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

        System.out.println("Введите размер обода: ");
        if (scan.hasNextDouble()) {
            sizeRim = scan.nextDouble();
        } else {
            //ругнуться
        }

        System.out.println("Введите длину ракетки: ");
        if (scan.hasNextDouble()) {
            length = scan.nextDouble();
        } else {
            //ругнуться
        }
    }

    @Override
    public SportType getSportType() {

        return TENNIS;
    }

    @Override
    public String toString() {
        return "Инвентарь - ракетка, вид спорта - теннис, масса - " + this.weight
                + ", производитель - " + this.manufacturer
                + ", размер обода - " + sizeRim
                + ", длина ракетки - " + length + '\n';
    }
}
