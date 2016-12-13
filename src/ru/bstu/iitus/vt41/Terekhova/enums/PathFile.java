package ru.bstu.iitus.vt41.Terekhova.enums;


public enum PathFile {
    FILE_PROPERTIES("src\\resource\\config.properties"),
    JSON_READ ("jsonFileRead"),
    JSON_WRITE ("jsonFileWrite"),
    JSON_TEMP ("jsonTemp"),
    JSON_MAX ("jsonMaxValue");

    public String filePath;

    PathFile(String jsonFilePath) {
        filePath = jsonFilePath;
    }
}
