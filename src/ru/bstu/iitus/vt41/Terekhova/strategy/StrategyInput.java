package ru.bstu.iitus.vt41.Terekhova.strategy;

import ru.bstu.iitus.vt41.Terekhova.sport.equipment.SportsEquipment;

import java.io.IOException;

public interface StrategyInput {
    SportsEquipment readSportEquipment() throws InstantiationException, IllegalAccessException, IOException;

    boolean hasNext();
}