package com.codeclan.classroombooking.modules;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DemeritType {
    @JsonProperty("First Warning") FIRST_WARNING("First Warning"),
    @JsonProperty("Second Warning") SECOND_WARNING("Second Warning"),
    @JsonProperty("Group Call") GROUP_CALL("Group Call");
    private final String formatted;

    DemeritType(String formatted) {
        this.formatted = formatted;
    }

    public String formatted() {
        return formatted;
    }
}
