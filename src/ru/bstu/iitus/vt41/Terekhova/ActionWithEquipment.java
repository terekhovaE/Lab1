package ru.bstu.iitus.vt41.Terekhova;


import com.google.gson.Gson;
import ru.bstu.iitus.vt41.Terekhova.enums.PathFile;
import ru.bstu.iitus.vt41.Terekhova.enums.SportType;
import ru.bstu.iitus.vt41.Terekhova.reader.ReadFromJSON;
import ru.bstu.iitus.vt41.Terekhova.sport.equipment.SportsEquipment;
import ru.bstu.iitus.vt41.Terekhova.strategy.StrategyInput;
import ru.bstu.iitus.vt41.Terekhova.strategy.StrategyOutput;
import ru.bstu.iitus.vt41.Terekhova.writer.WriteEquipmentToJSON;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActionWithEquipment {

    public static List<SportsEquipment> readSportEquipment(StrategyInput strategyInput) {

        List<SportsEquipment> listSportsEquipment = new ArrayList<>();
        try {
            while (strategyInput.hasNext()) {
                listSportsEquipment.add(strategyInput.readSportEquipment());
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода");
        }
        return listSportsEquipment;
    }

    public static List<SportsEquipment> readEquipmentUnique(List<SportsEquipment> equipmentList, SportType sportType) {

        List<SportsEquipment> resultList = new ArrayList<>();

        for (SportsEquipment sportsEquipment : equipmentList) {
            if (sportsEquipment.getClass().isAssignableFrom(sportType.getEquipmentClass())) {
                resultList.add(sportsEquipment);
            }
        }
        return resultList;
    }

    public static void RemoveEquipmentFromFile(SportsEquipment equipment, String fileName) {

        String newFileName = PathFile.JSON_TEMP.filePath;

        try (ReadFromJSON eqFromJSON = new ReadFromJSON(fileName);
             WriteEquipmentToJSON equipmentToJSON = new WriteEquipmentToJSON(newFileName)) {
            while (eqFromJSON.hasNext()) {
                SportsEquipment spEquipment = eqFromJSON.readSportEquipment();
                if (!spEquipment.equals(equipment)) {
                    equipmentToJSON.writeSportEquipment(spEquipment);
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при удалении элемента");
            return;
        }
        File oldfile = new File(fileName);
        if (oldfile.delete()) {
            File newFile = new File(newFileName);
            newFile.renameTo(oldfile);
        }
    }

    public static void writeSportEquipments(StrategyOutput strategyOutput, List<SportsEquipment> listEquipment) {

        for (SportsEquipment se : listEquipment) {

            try {
                strategyOutput.writeSportEquipment(se);
            } catch (Exception ex) {
                System.out.println("Ошибка вывода");
            }
        }
    }

    public static void writeSportEquipmentMaxValue(List<SportsEquipment> equipmentList, String fileName) {

        Gson gson = new Gson();

        String sp = "";
        Optional<SportsEquipment> equipmentMax = equipmentList.stream().max(SportsEquipment.comparator);
        if (equipmentMax.isPresent()) {
            sp = gson.toJson(equipmentMax.get()) + '\n';
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {

            fileWriter.write(sp);

            for (SportType type : SportType.values()) {
                Optional<SportsEquipment> max = (equipmentList.stream()
                        .filter(sportsEquipment -> type.getEquipmentClass().isAssignableFrom(sportsEquipment.getClass()))
                        .map(sportsEquipment -> type.getEquipmentClass().cast(sportsEquipment))
                        .max(type.getComparator()));
                if (max.isPresent()) {
                    fileWriter.write(gson.toJson(max.get()) + '\n');
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка работы с файлом");
        }
    }
}
