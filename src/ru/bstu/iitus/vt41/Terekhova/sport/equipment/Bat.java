package ru.bstu.iitus.vt41.Terekhova.sport.equipment;

import lombok.Data;
import ru.bstu.iitus.vt41.Terekhova.enums.RegExp;
import ru.bstu.iitus.vt41.Terekhova.enums.SportType;
import ru.bstu.iitus.vt41.Terekhova.reader.ReadFromConsole;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data

//ракетка
public class Bat extends SportsEquipment implements Serializable {

    public static Comparator<Bat> comparator = (o1, o2) -> Double.compare(o1.sizeRim, o2.sizeRim);

    double sizeRim; //размер обода
    double length;    //длина

    @Override
    public SportsEquipment init() {

        super.init();

        sizeRim = ReadFromConsole.readDouble("Введите размер обода: ");
        length = ReadFromConsole.readDouble("Введите длину ракетки: ");

        super.type =SportType.BAT;

        return this;
    }



    @Override
    public String toString() {
        return "Инвентарь - ракетка, вид спорта - теннис, масса - " + this.weight
                + ", производитель - " + this.manufacturer
                + ", размер обода - " + sizeRim
                + ", длина ракетки - " + length + '\n';
    }

    @Override
    public void initSportEquipment(SportsEquipment sportsEquipment, List<String> properties) {

        super.initSportEquipment(sportsEquipment, properties);
        Pattern patternSizeRim = Pattern.compile(RegExp.SIZE_RIM_EQUIPMENTS.RegExp);
        Pattern patternLength = Pattern.compile(RegExp.LENGTH_EQUIPMENTS.RegExp);
        sportsEquipment.type=SportType.TENNIS;
        for(String s: properties) {

            Matcher matcherLength = patternLength.matcher(s);
            Matcher matcherSizeRim = patternSizeRim.matcher(s);

            if(matcherSizeRim.matches()) {
                ((Bat) sportsEquipment).sizeRim = Double.parseDouble(matcherSizeRim.group(1));
            }
            else if(matcherLength.matches()) {
                ((Bat) sportsEquipment).length = Double.parseDouble(matcherLength.group(1));
            }
        }
    }
}
