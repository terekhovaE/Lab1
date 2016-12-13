package ru.bstu.iitus.vt41.Terekhova.reader;

import ru.bstu.iitus.vt41.Terekhova.sport.equipment.SportsEquipment;
import ru.bstu.iitus.vt41.Terekhova.strategy.StrategyInput;


public class ReadSportEquipmentFromConsole implements StrategyInput {

    @Override
    public SportsEquipment readSportEquipment() throws InstantiationException, IllegalAccessException {

        int sportType = ReadFromConsole.readInteger(
                "1 - волейбольный мяч \n"  +
                        "2 - теннисный мяч \n" +
                        "3 - ракетка \n" +
                        "4 - метательное копье \n" +
                        "5 - тренажерный инвентарь \n");
        return SportsEquipment.buildEquipments(sportType).init();
    }

    @Override
    public boolean hasNext() {
        return ReadFromConsole.readInteger("Ввести спортивный инвентарь?\n\t 1 - да\n\t 0 - нет") != 0;
    }
}
