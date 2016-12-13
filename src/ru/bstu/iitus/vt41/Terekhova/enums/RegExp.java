package ru.bstu.iitus.vt41.Terekhova.enums;


import java.util.regex.Pattern;

public enum RegExp {

    VALUE_EQUIPMENTS ("\\s*\"value\"\\s*:\\s*\"([а-яА-Яa-zA-z]+\\s*[а-яА-Яa-zA-z]*)+\"\\s*"),

    MATERIAL_EQUIPMENTS ("\\s*\"material\"\\s*:\\s*\"([а-яА-Яa-zA-z]+)\"\\s*."),

    MANUFACTURER_EQUIPMENTS ("\\s*\"manufacturer\"\\s*:\\s*\"([а-яА-Яa-zA-z]+)\"\\s*."),

    WEIGHT_EQUIPMENTS ("\\s*\"weight\"\\s*:\\s*\"(\\d+[.,]?\\d*)\"\\s*."),

    SIZE_EQUIPMENTS ("\\s*\"size\"\\s*:\\s*\"(\\d+[.,]?\\d*)\"\\s*."),

    SIZE_RIM_EQUIPMENTS ("\\s*\"sizeRim\"\\s*:\\s*\"(\\d+[.,]?\\d*)\"\\s*."),

    LENGTH_EQUIPMENTS ("\\s*\"length\"\\s*:\\s*\"(\\d+[.,]?\\d*)\"\\s*."),

    ANGLE_TIP_EQUIPMENTS ("\\s*\"angleTip\"\\s*:\\s*\"(\\d+[.,]?\\d*)\"\\s*."),

    LEVEL_ELASTICITY_EQUIPMENTS ("\\s*\"levelElasticity\"\\s*:\\s*\"(\\d+[.,]?\\d*)\"\\s*."),

    LEVEL_CONVENIENCE_EQUIPMENTS ("\\s*\"levelConvenience\"\\s*:\\s*\"(\\d+[.,]?\\d*)\"\\s*."),

    PUMP_EQUIPMENTS ("\\s*\"pump\"\\s*:\\s*\"([а-яА-Яa-zA-z]+)\"\\s*.");

    public String RegExp;

    RegExp(String s) {
    RegExp = s;
    }
}
