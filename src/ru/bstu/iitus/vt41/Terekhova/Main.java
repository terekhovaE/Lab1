package ru.bstu.iitus.vt41.Terekhova;

import ru.bstu.iitus.vt41.Terekhova.enums.PathFile;
import ru.bstu.iitus.vt41.Terekhova.reader.ReadFromConsole;
import ru.bstu.iitus.vt41.Terekhova.reader.ReadFromJSON;
import ru.bstu.iitus.vt41.Terekhova.reader.ReadSportEquipmentFromConsole;
import ru.bstu.iitus.vt41.Terekhova.sport.equipment.SportsEquipment;
import ru.bstu.iitus.vt41.Terekhova.strategy.StrategyInput;
import ru.bstu.iitus.vt41.Terekhova.strategy.StrategyOutput;
import ru.bstu.iitus.vt41.Terekhova.writer.WriteEquipmentToJSON;
import ru.bstu.iitus.vt41.Terekhova.writer.WriteSportEquipmentFromConsole;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        int strategyInput = ReadFromConsole.readInteger("Выберите тип ввода: \n\t 1 - консоль\n\t 2 - JSON-файл\n");
        StrategyInput strategyRead;
        StrategyOutput strategyOutput;
        if (strategyInput == 1) {
            strategyRead = new ReadSportEquipmentFromConsole();
        } else {
            strategyRead = new ReadFromJSON(ApplicationProperties.getInstance().getProperty(PathFile.JSON_READ.filePath));
        }
        strategyInput = ReadFromConsole.readInteger("Выберите тип вывода: \n\t 1 - консоль\n\t 2 - JSON-файл\n");

        if (strategyInput == 1) {
            strategyOutput = new WriteSportEquipmentFromConsole();
        } else {
            strategyOutput = new WriteEquipmentToJSON(ApplicationProperties.getInstance().getProperty(PathFile.JSON_WRITE.filePath));
        }

        List<SportsEquipment> listEquipment = ActionWithEquipment.readSportEquipment(strategyRead);

        //ActionWithEquipment.RemoveEquipmentFromFile(listEquipment.get(listEquipment.size()-1), ApplicationProperties.getInstance().getProperty(PathFile.JSON_READ.filePath));

        ActionWithEquipment.writeSportEquipmentMaxValue(listEquipment, ApplicationProperties.getInstance().getProperty(PathFile.JSON_MAX.filePath));

        ActionWithEquipment.writeSportEquipments(strategyOutput, listEquipment);


    }
}
