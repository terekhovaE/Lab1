package ru.bstu.iitus.vt41.Terekhova.enums;

import lombok.Data;
import lombok.Getter;
import ru.bstu.iitus.vt41.Terekhova.sport.equipment.*;

import java.util.Comparator;

@Getter

public enum SportType {
    VOLLEYBALL("волейбол", 1, VolleyBall.class, VolleyBall.comparator), //волейбол
    TENNIS("теннис", 2, TennisBall.class, TennisBall.comparator), //теннис
    BAT("ракетка", 3, Bat.class, Bat.comparator),  //метание копья
    JAVELIN_THROWING("копье", 4, Javelin.class, Javelin.comparator), //легкая атлетика
    WEIGHT("гиря", 5, Weight.class, Weight.comparator), //фитнесс
    BALL_SPORT("мяч", 6, Ball.class, Ball.comparator);  //мяч

    public String name;
    public int typeOrdinal;
    Class<? extends SportsEquipment> clazz;
    Comparator comparator;

    SportType(String name, int i, Class<? extends SportsEquipment> clazz, Comparator comparator) {
        this.name = name;
        typeOrdinal = i;
        this.clazz = clazz;
        this.comparator=comparator;
    }

    public Comparator getComparator(){
        return comparator;
    }
    public static SportType getEquipmentType(int typeOrdinal) throws IllegalAccessException {
        for (SportType type : SportType.values()) {
            if (type.typeOrdinal == typeOrdinal) {
                return type;
            }
        }
        throw new IllegalAccessException();
    }

    public static SportType getEquipmentType(String typeOrdinal) throws IllegalAccessException {
        typeOrdinal = typeOrdinal.toLowerCase();
        for (SportType type : SportType.values()) {
            if (type.name.equals(typeOrdinal)) {
                return type;
            }
        }
        throw new IllegalAccessException();
    }

    public Class<? extends SportsEquipment> getEquipmentClass() {
        return clazz;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
