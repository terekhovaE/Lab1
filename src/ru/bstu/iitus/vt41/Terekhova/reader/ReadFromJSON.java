package ru.bstu.iitus.vt41.Terekhova.reader;


import jdk.nashorn.internal.parser.JSONParser;
import ru.bstu.iitus.vt41.Terekhova.enums.RegExp;
import ru.bstu.iitus.vt41.Terekhova.sport.equipment.SportsEquipment;
import ru.bstu.iitus.vt41.Terekhova.strategy.StrategyInput;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFromJSON implements StrategyInput, AutoCloseable {

    private ListIterator<String> iterator;

    public ReadFromJSON(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            iterator = lines.listIterator();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при открытии Файла");
        }
    }

    @Override
    public SportsEquipment readSportEquipment() throws IOException {
        while (iterator.hasNext()) {
            String strJSON = iterator.next().trim();
            Pattern pattern = Pattern.compile(RegExp.VALUE_EQUIPMENTS.RegExp);
            Matcher matcherValue = pattern.matcher(strJSON);
            if (matcherValue.matches()) {
                try {
                    SportsEquipment  s = SportsEquipment.buildEquipments(matcherValue.group(1));
                    List<String> listProperties = getProperties();
                    s.initSportEquipment(s, listProperties);
                    return s;
                } catch (Exception ignored) {
                }
            }
        }
        throw new IOException("Объекты отсутствуют!");
    }

    private List<String> getProperties() {
        List<String> listProperties = new ArrayList<>();
        while (!iterator.next().contains("}")) ;

        String s;
        while (iterator.hasNext() && !(s = iterator.next()).contains("type")) {
            String trimString = s.trim().replace(',', '.');
            if (!trimString.equals("")) {
                listProperties.add(trimString);
            }
        }
        iterator.previous();
        return listProperties;
    }

    @Override
    public boolean hasNext() {

        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.contains("type")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void close() throws Exception {

    }
}
