package ru.bstu.iitus.vt41.Terekhova.strategy;

import ru.bstu.iitus.vt41.Terekhova.sport.equipment.SportsEquipment;

import java.io.IOException;

public interface StrategyOutput extends AutoCloseable{

    void writeSportEquipment (SportsEquipment equipment) throws Exception;
}
