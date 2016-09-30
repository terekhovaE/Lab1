package ru.bstu.iitus.vt41.Terekhova;

import com.sun.istack.internal.NotNull;

/**
 * Created by ekate on 21.09.2016.
 */
public enum SportType {
    VOLLEYBALL("волейбол", 1, VolleyBall.class), //волейбол
    TENNIS("тенис", 2, TennisBall.class), //теннис
    WEIGHTLIFTING("метания копья", 3, Weight.class),  //метание копья
    JAVELIN_THROWING("тяжелая атлетика", 4, Javelin.class), //тяжелая атлетика
    BALL_SPORT("мяч", 5, Ball.class),  //мяч
    FITNESS("фитнесс", 6, Fitness.class); //фитнесс

    String name;
    int typeOrdinal;
    Class<? extends SportsEquipment> clazz;

    SportType(String name, int i, Class<? extends SportsEquipment> clazz) {
        this.name = name;
        typeOrdinal = i;
        this.clazz = clazz;
    }

    static SportType valueOf(int typeOrdinal) {
        for (SportType type : SportType.values()) {
            if (type.typeOrdinal == typeOrdinal) {
                return type;
            }
        }
        return null; //todo throw new Exception
    }

    public Class<? extends SportsEquipment> getEquipmentClass() {
        return clazz;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
