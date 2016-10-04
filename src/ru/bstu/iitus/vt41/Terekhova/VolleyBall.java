package ru.bstu.iitus.vt41.Terekhova;

import java.util.Scanner;

public class VolleyBall extends Ball {

    public static final SportType VOLLEYBALL = SportType.VOLLEYBALL;
    String typePump;    //тип насоса

    @Override
    public void init(Scanner scan) throws MyException {
        super.init(scan);
        System.out.println("Введите тип насоса: ");
        typePump = scan.nextLine();
    }

    @Override
    public SportType getSportType() {

        return VOLLEYBALL;
    }

    @Override
    public String toString() {
        return "Инвентарь - волейбольный мяч, вид спорта - волейбол, масса - " + this.weight
                + ", производитель - " + this.manufacturer
                + ", материал - " + this.material
                + ", радиус мяча - " + this.size
                + ", тип насоса - " + typePump + '\n';
    }
}
