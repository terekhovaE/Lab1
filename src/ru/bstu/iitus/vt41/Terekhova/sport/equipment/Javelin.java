package ru.bstu.iitus.vt41.Terekhova.sport.equipment;

import lombok.Data;
import ru.bstu.iitus.vt41.Terekhova.enums.RegExp;
import ru.bstu.iitus.vt41.Terekhova.enums.SportType;
import ru.bstu.iitus.vt41.Terekhova.reader.ReadFromConsole;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data

//Метательное копье
public class Javelin extends SportsEquipment {

    public static Comparator<Javelin> comparator = (o1, o2) -> Double.compare(o1.length, o2.length);

    double angleTip;    //угол острия
    double length;    //длина

    @Override
    public SportsEquipment init () {

       super.init();

        angleTip = ReadFromConsole.readDouble("Введите угол острия: ");
        length = ReadFromConsole.readDouble("Введите длину копья: ");

        super.type =SportType.JAVELIN_THROWING;

        return this;
    }


    @Override
    public String toString() {
        return "Инвентарь - копье, вид спорта - метание копья, масса - " + this.weight
                + ", производитель - " + this.manufacturer
                + ", угол острия - " + angleTip
                + ", длина - " + length + '\n';
    }


    @Override
    public void initSportEquipment(SportsEquipment sportsEquipment, List<String> properties) {

        super.initSportEquipment(sportsEquipment, properties);
        Pattern patternAngleTip = Pattern.compile(RegExp.ANGLE_TIP_EQUIPMENTS.RegExp);
        Pattern patternLength = Pattern.compile(RegExp.LENGTH_EQUIPMENTS.RegExp);
        sportsEquipment.type=SportType.JAVELIN_THROWING;
        for(String s: properties) {

            Matcher matcherAngleTip = patternAngleTip.matcher(s);
            Matcher matcherLength = patternLength.matcher(s);

            if(matcherAngleTip.matches()) {
                ((Javelin) sportsEquipment).angleTip = Double.parseDouble(matcherAngleTip.group(1));
            }
            else if(matcherLength.matches()) {
                ((Javelin) sportsEquipment).length = Double.parseDouble(matcherLength.group(1));
            }
        }
    }
}
