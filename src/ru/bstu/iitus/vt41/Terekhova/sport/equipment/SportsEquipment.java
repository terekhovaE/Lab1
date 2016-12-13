package ru.bstu.iitus.vt41.Terekhova.sport.equipment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.bstu.iitus.vt41.Terekhova.enums.RegExp;
import ru.bstu.iitus.vt41.Terekhova.enums.SportType;
import ru.bstu.iitus.vt41.Terekhova.reader.ReadFromConsole;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public abstract class SportsEquipment implements Serializable{

    public static Comparator<SportsEquipment> comparator = (o1, o2) -> Double.compare(o1.weight, o2.weight);

    double weight;      //масса
    String manufacturer;    //производитель
    SportType type; //вид спорта

    public SportsEquipment init() {
        weight = ReadFromConsole.readDouble("Введите массу: ");
        manufacturer = ReadFromConsole.readString("Введите производителя: ");

        return this;
    }

    public SportType getType(){
        return type;
    }



    public static SportsEquipment buildEquipments(int typeEquipment) throws IllegalAccessException, InstantiationException {
        SportType type = SportType.getEquipmentType(typeEquipment);
        return type.getEquipmentClass().newInstance();
    }

    public static SportsEquipment buildEquipments(String typeEquipment) throws IllegalAccessException, InstantiationException {
        SportType type = SportType.getEquipmentType(typeEquipment);
        return type.getEquipmentClass().newInstance();
    }

    public void initSportEquipment (SportsEquipment sportsEquipment, List<String> properties) {

        Pattern patternWeight = Pattern.compile(RegExp.WEIGHT_EQUIPMENTS.RegExp);
        Pattern patternManufacturer = Pattern.compile(RegExp.MANUFACTURER_EQUIPMENTS.RegExp);

        for(String s: properties) {

            Matcher matcherWeight = patternWeight.matcher(s);
            Matcher matcherManufacturer = patternManufacturer.matcher(s);

            if(matcherWeight.matches()) {
                sportsEquipment.weight = Double.parseDouble(matcherWeight.group(1));
            }
            else if(matcherManufacturer.matches()) {
                sportsEquipment.manufacturer = matcherManufacturer.group(1);
            }
        }
    }
}

