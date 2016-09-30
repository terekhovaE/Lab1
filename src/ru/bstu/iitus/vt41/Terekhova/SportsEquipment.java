package ru.bstu.iitus.vt41.Terekhova;

import java.util.Scanner;

//спортивный инвентарь
public abstract class SportsEquipment {

    double weight;      //масса
    String manufacturer;    //производитель
    SportType ks; //вид спорта

    public abstract void init(Scanner scanner) throws MyException;

    public abstract SportType getSportType();
}
