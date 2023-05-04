package com.codeclan.classroombooking.modules.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DayType {
    @JsonProperty("Monday") MON("Monday"),
    @JsonProperty("Tuesday") TUE("Tuesday"),
    @JsonProperty("Wednesday") WED("Wednesday"),
    @JsonProperty("Thursday") THU("Thursday"),
    @JsonProperty("Friday") FRI("Friday");
    private final String formatted;

    DayType(String formatted) {
        this.formatted = formatted;
    }

    public static DayType convertToDayType(String day) {
        String formatted = day.substring(0,3);
        String capitalised = formatted.toUpperCase();
        DayType dayType = DayType.valueOf(capitalised);
        return dayType;
    }

    public String formatted() {
        return formatted;
    }
}
