package com.code.may;

import com.code.july.Java8Learn;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Test  {

    public static void main(String[] args) {

        //System.out.println(convertEpochToUTCTime("1747808464"));
       new Test().usingExtendsInList();
    }



    private  void usingExtendsInList() {

    }

    public static String convertEpochToUTCTime(final String string) {
        long epochSeconds = Long.parseLong(string);
        ZonedDateTime utcTime = Instant.ofEpochSecond(epochSeconds).atZone(ZoneId.of("UTC"));

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
                .appendOffset("+HH:MM", "+00:00")
                .toFormatter();

        return formatter.format(utcTime);
    }
}
