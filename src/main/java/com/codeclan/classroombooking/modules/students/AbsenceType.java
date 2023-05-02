package com.codeclan.classroombooking.modules.students;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AbsenceType {
    @JsonProperty("Late") LATE("Late"),
    @JsonProperty("No Show") NO_SHOW("No Show"),
    @JsonProperty("Medical") MEDICAL("Medical");
    private final String formatted;

    AbsenceType(String formatted) {
        this.formatted = formatted;
    }

    public String formatted() {
        return formatted;
    }
}
