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

public class TennisBall extends Ball implements Serializable {

    public static Comparator<TennisBall> comparator = (o1, o2) -> Double.compare(o1.levelElasticity, o2.levelElasticity);

    double levelElasticity;    //уровень упругости

    @Override
    public SportsEquipment init() {

        super.init();

        levelElasticity = ReadFromConsole.readDouble("Введите уровень упругости мяча: ");

        super.type =SportType.TENNIS;

        return this;
    }


    @Override
    public String toString() {
        return "Инвентарь - теннисный мяч, вид спорта - теннис, масса - " + this.weight
                + ", производитель - " + this.manufacturer
                + ", материал - " + this.material
                + ", радиус мяча - " + this.size
                + ", уровень упругости - " + levelElasticity + '\n';
    }

    @Override
    public void initSportEquipment(SportsEquipment sportsEquipment, List<String> properties) {

        super.initSportEquipment(sportsEquipment, properties);
        Pattern patternLevelElasticity = Pattern.compile(RegExp.LEVEL_ELASTICITY_EQUIPMENTS.RegExp);
        sportsEquipment.type=SportType.TENNIS;
        for(String s: properties) {

            Matcher matcherLevelElasticity = patternLevelElasticity.matcher(s);

            if(matcherLevelElasticity.matches()) {
                ((TennisBall) sportsEquipment).levelElasticity = Double.parseDouble(matcherLevelElasticity.group(1));
            }
        }
    }
}
