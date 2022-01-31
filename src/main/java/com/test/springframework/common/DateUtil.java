package com.test.springframework.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {


    /**
     * LocalDate -> String
     *
     * @param localDate (LocalDate)
     * @return String
     */
    public static String getLocalDateToString(LocalDate localDate){

        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    }
}
