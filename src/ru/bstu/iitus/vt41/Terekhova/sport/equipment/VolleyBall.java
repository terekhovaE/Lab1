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

public class VolleyBall extends Ball implements Serializable {

    public static Comparator<VolleyBall> comparator = (o1, o2) -> o1.pump.length() - o2.pump.length();

    String pump;    //тип насоса

    @Override
    public SportsEquipment init() {

        super.init();

        pump = ReadFromConsole.readString("Введите тип насоса: ");

        super.type =SportType.VOLLEYBALL;

        return this;
    }

    @Override
    public String toString() {
        return "Инвентарь - волейбольный мяч, вид спорта - волейбол, масса - " + this.weight
                + ", производитель - " + this.manufacturer
                + ", материал - " + this.material
                + ", радиус мяча - " + this.size
                + ", тип насоса - " + pump + '\n';
    }

    @Override
    public void initSportEquipment(SportsEquipment sportsEquipment, List<String> properties) {

        super.initSportEquipment(sportsEquipment, properties);
        Pattern patternPump = Pattern.compile(RegExp.PUMP_EQUIPMENTS.RegExp);
        sportsEquipment.type=SportType.VOLLEYBALL;
        for(String s: properties) {

            Matcher matcherPump = patternPump.matcher(s);

            if(matcherPump.matches()) {
                ((VolleyBall) sportsEquipment).pump = matcherPump.group(1);
            }
        }
    }
}
