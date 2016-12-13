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

import static ru.bstu.iitus.vt41.Terekhova.enums.SportType.BALL_SPORT;

@Data

public class Ball extends SportsEquipment implements Serializable {

    public static Comparator<Ball> comparator = (o1, o2) -> Double.compare(o1.size, o2.size);
    double size;    //размер
    String material;    //материал

    @Override
    public SportsEquipment init () {

        super.init();

        size = ReadFromConsole.readDouble("Введите радиус мяча: ");
        material = ReadFromConsole.readString("Введите материал, из которого изготовлен мяч: ");

        super.type =SportType.BALL_SPORT;
        return this;
    }

    @Override
    public void initSportEquipment(SportsEquipment sportsEquipment, List<String> properties) {

        super.initSportEquipment(sportsEquipment, properties);
        Pattern patternSize = Pattern.compile(RegExp.SIZE_EQUIPMENTS.RegExp);
        Pattern patternMaterial = Pattern.compile(RegExp.MATERIAL_EQUIPMENTS.RegExp);
        sportsEquipment.type=SportType.BALL_SPORT;
        for(String s: properties) {

            Matcher matcherSize = patternSize.matcher(s);
            Matcher matcherMaterial = patternMaterial.matcher(s);

            if(matcherSize.matches()) {
                ((Ball) sportsEquipment).size = Double.parseDouble(matcherSize.group(1));
            }
            else if(matcherMaterial.matches()) {
                ((Ball) sportsEquipment).material = matcherMaterial.group(1);
            }
        }
    }

    @Override
    public String toString() {
        return "Инвентарь - мяч, масса - " + weight
                + ", производитель - " + manufacturer
                + ", материал - " + material
                + ", радиус мяча - " + size;
    }

}
