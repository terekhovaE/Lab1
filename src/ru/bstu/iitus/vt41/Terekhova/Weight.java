package ru.bstu.iitus.vt41.Terekhova;

import java.util.Scanner;

/**
 * Created by ekate on 20.09.2016.
 */
public class Weight extends Fitness {
    public static final SportType WEIGHTLIFTING = SportType.WEIGHTLIFTING;
    String appointment;    //назначение
    double levelConvenience;    //степень удобства

    @Override
    public void init(Scanner scan) {
        super.init(scan);

        System.out.println("Введите назначение гири: ");
        appointment = scan.nextLine();

        System.out.println("Введите стеепень удобства гири: ");
        if (scan.hasNextDouble()) {
            levelConvenience = scan.nextDouble();
        } else {
            //ругнуться
        }
    }

    @Override
    public SportType getSportType() {

        return WEIGHTLIFTING;
    }

    @Override
    public String toString() {
        return "Инвентарь - гиря, вид спорта - тяжелая атлетика, масса - " + this.weight
                + ", производитель - " + this.manufacturer
                + ", материал - " + this.material
                + ", назначение - " + appointment
                + ", степень удобства - " + levelConvenience + '\n';
    }
}
