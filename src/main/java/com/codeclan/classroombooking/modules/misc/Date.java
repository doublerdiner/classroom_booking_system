package com.codeclan.classroombooking.modules.misc;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Date {
    public static LocalDate threeMonthsAgo(){
        return LocalDate.now().minus(3, ChronoUnit.MONTHS);
    }
}
