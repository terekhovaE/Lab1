package ru.bstu.iitus.vt41.Terekhova.writer;

import com.google.gson.Gson;
import ru.bstu.iitus.vt41.Terekhova.sport.equipment.SportsEquipment;
import ru.bstu.iitus.vt41.Terekhova.strategy.StrategyOutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteEquipmentToJSON implements StrategyOutput {

    OutputStream outputStream;

    public WriteEquipmentToJSON(String fileName) {
        try {
            outputStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    @Override
        public void writeSportEquipment(SportsEquipment equipment) throws Exception {

        Gson gson = new Gson();
        String s= gson.toJson(equipment);
        outputStream.write(equipment.getType().name.getBytes());
        outputStream.write((s+'\n').getBytes());

    }

    @Override
    public void close() throws Exception {

    }
}
