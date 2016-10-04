package ru.bstu.iitus.vt41.Terekhova;

import java.util.Scanner;

public class Weight extends Fitness {
    public static final SportType WEIGHTLIFTING = SportType.WEIGHTLIFTING;
    String appointment;    //назначение
    double levelConvenience;    //степень удобства

    @Override
    public void init(Scanner scan) throws MyException {
        super.init(scan);
        System.out.println("Введите назначение гири: ");
        appointment = scan.nextLine();

        System.out.println("Введите стеепень удобства гири: ");
        levelConvenience = InizialEquipment.TypeVerification(scan);
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
