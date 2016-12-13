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

public class Weight extends Fitness implements Serializable {

    public static Comparator<Weight> comparator = (o1, o2) -> Double.compare(o1.levelConvenience, o2.levelConvenience);

    double levelConvenience;    //степень удобства

    @Override
    public SportsEquipment init() {
        super.init();

        levelConvenience = ReadFromConsole.readDouble("Введите степень удобства гири: ");

        super.type =SportType.WEIGHT;

        return this;
    }


    @Override
    public String toString() {
        return "Инвентарь - гиря, вид спорта - тяжелая атлетика, масса - " + this.weight
                + ", производитель - " + this.manufacturer
                + ", материал - " + this.material
                + ", степень удобства - " + levelConvenience + '\n';
    }

    @Override
    public void initSportEquipment(SportsEquipment sportsEquipment, List<String> properties) {

        super.initSportEquipment(sportsEquipment, properties);
        Pattern patternLevelConvenience = Pattern.compile(RegExp.LEVEL_CONVENIENCE_EQUIPMENTS.RegExp);
        sportsEquipment.type=SportType.WEIGHT;
        for(String s: properties) {

            Matcher matcherLevelConvenience = patternLevelConvenience.matcher(s);

           if(matcherLevelConvenience.matches()) {
                ((Weight) sportsEquipment).levelConvenience = Double.parseDouble(matcherLevelConvenience.group(1));
            }
        }
    }
}
