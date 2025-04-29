package com.xiaodao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculateDaysToToday {
    public static long CountDay (String day) {
        LocalDate inputDate = LocalDate.parse(day);
        LocalDate now = LocalDate.now();
        return ChronoUnit.DAYS.between(inputDate, now);
    }
}
