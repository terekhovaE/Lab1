package ru.bstu.iitus.vt41.Terekhova;

import java.util.Scanner;

import static ru.bstu.iitus.vt41.Terekhova.SportType.BALL_SPORT;

public class Ball extends SportsEquipment {
    double size;    //размер
    String material;    //материал

    @Override
    public void init(Scanner scan) throws MyException {
        System.out.println("Введите массу мяча: ");
        if (scan.hasNextDouble()) {
            weight =Double.parseDouble( scan.nextLine());
        } else {
            throw new MyException("Введите числовое значение!");
        }

        System.out.println("Введите производителя мяча: ");
        manufacturer = scan.nextLine();

        System.out.println("Введите радиус мяча: ");
        if (scan.hasNextDouble()) {
            size =Double.parseDouble( scan.nextLine());
        } else {
            throw new MyException("Введите числовое значение!");
        }
        System.out.println("Введите материал, из которого изготовлен мяч: ");
        material = scan.nextLine();
    }

    @Override
    public SportType getSportType() {
        return BALL_SPORT;
    }

    @Override
    public String toString() {
        return "Инвентарь - мяч, масса - " + weight
                + ", производитель - " + manufacturer
                + ", материал - " + material
                + ", радиус мяча - " + size;
    }
}
