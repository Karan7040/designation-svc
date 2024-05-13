package com.colruytgroup.designation.model.enums;

public class Indicator {
    private static final String YES = "Y";
    private static final String NO = "N";

    public static boolean convertToBoolean(String value) {
        if (YES.equals(value)) {
            return true;
        }
        if (NO.equals(value)) {
            return false;
        }
        throw new IllegalArgumentException("Provide valid argument");
    }

    public static String convertToString(boolean value) {
        return value ? YES : NO;
    }
}
