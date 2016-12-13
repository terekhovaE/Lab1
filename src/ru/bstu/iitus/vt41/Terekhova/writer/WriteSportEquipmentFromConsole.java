package ru.bstu.iitus.vt41.Terekhova.writer;


import ru.bstu.iitus.vt41.Terekhova.sport.equipment.SportsEquipment;
import ru.bstu.iitus.vt41.Terekhova.strategy.StrategyOutput;

public class WriteSportEquipmentFromConsole implements StrategyOutput{

    @Override
    public void writeSportEquipment(SportsEquipment equipment) {
        System.out.println(equipment.toString());
    }

    @Override
    public void close() throws Exception {

    }
}
