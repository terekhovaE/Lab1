package ru.bstu.iitus.vt41.Terekhova;

import java.util.Scanner;

public class TennisBall extends Ball {
    public static final SportType TENNIS = SportType.TENNIS;
    double levelElasticity;    //уровень упругости

    @Override
    public void init(Scanner scan) throws MyException {
        super.init(scan);
        System.out.println("Введите уровень упругости мяча: ");
        levelElasticity = InizialEquipment.TypeVerification(scan);
    }

    @Override
    public SportType getSportType() {

        return TENNIS;
    }

    @Override
    public String toString() {
        return "Инвентарь - теннисный мяч, вид спорта - теннис, масса - " + this.weight
                + ", производитель - " + this.manufacturer
                + ", материал - " + this.material
                + ", радиус мяча - " + this.size
                + ", уровень упругости - " + levelElasticity + '\n';
    }
}
