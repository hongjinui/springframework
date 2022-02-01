package com.test.springframework.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {


    /**
     * LocalDate -> String
     *
     * @param localDateTime (LocalDate)
     * @return String
     */
    public static String getLocalDateToString(LocalDateTime localDateTime){

        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    }
}
