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

import static ru.bstu.iitus.vt41.Terekhova.enums.SportType.WEIGHT;

@Data

public class Fitness extends SportsEquipment implements Serializable {

    public static Comparator<Fitness> comparator = (o1, o2) -> o1.material.length()- o2.material.length();

    String material;    //материал

    @Override
    public SportsEquipment init() {

        super.init();

        material = ReadFromConsole.readString("Введите материал, из которого изготовлен инвентарь: ");


        super.type =SportType.WEIGHT;

        return this;
    }

    @Override
    public String toString() {
        return "Инвентарь - тренажерный, вид спорта - тяжелая атлетика, масса - " + weight
                + ", производитель - " + manufacturer
                + ", материал - " + material;
    }

    @Override
    public void initSportEquipment(SportsEquipment sportsEquipment, List<String> properties) {

        super.initSportEquipment(sportsEquipment, properties);
        Pattern patternMaterial = Pattern.compile(RegExp.MATERIAL_EQUIPMENTS.RegExp);
        sportsEquipment.type=SportType.WEIGHT;
        for(String s: properties) {

            Matcher matcherMaterial = patternMaterial.matcher(s);

            if(matcherMaterial.matches()) {
                ((Fitness) sportsEquipment).material = matcherMaterial.group(1);
            }
        }
    }
}
