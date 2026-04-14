package com.api.utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DateTimeUtil {

    private DateTimeUtil() {
    }

    public static String getTimeWithDate(int day) {
        return Instant.now()
                .minus(day, ChronoUnit.DAYS)
                .toString();  // ✅ Now works
    }
}