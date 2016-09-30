package ru.bstu.iitus.vt41.Terekhova;

import java.util.Scanner;

import static ru.bstu.iitus.vt41.Terekhova.SportType.FITNESS;

public class Fitness extends SportsEquipment {

    String material;    //материал
    String color;   //цвет

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

        System.out.println("Введите материал, из которого изготовлен инвентарь: ");
        material = scan.nextLine();

        System.out.println("Введите цвет инвентаря: ");
        color = scan.nextLine();
    }

    @Override
    public SportType getSportType() {
        return FITNESS;
    }

    @Override
    public String toString() {
        return "Инвентарь - тренажерный, вид спорта - тяжелая атлетика, масса - " + weight
                + ", производитель - " + manufacturer
                + ", материал - " + material;
    }
}
