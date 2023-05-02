package com.codeclan.classroombooking.modules;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DayType {
    @JsonProperty("Monday") MON("Monday"),
    @JsonProperty("Tuesday") TUES("Tuesday"),
    @JsonProperty("Wednesday") WED("Wednesday"),
    @JsonProperty("Thursday") THURS("Thursday"),
    @JsonProperty("Friday") FRI("Friday");
    private final String formatted;

    DayType(String formatted) {
        this.formatted = formatted;
    }

    public String formatted() {
        return formatted;
    }
}
